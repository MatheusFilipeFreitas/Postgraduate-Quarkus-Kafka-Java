# florinda-eats-microservices

Florinda Eats is a food delivery application for Dona Florinda's restaurant.

**Requirements:** JDK 25 and Maven 3.9+ (for local development). Docker Desktop (or Docker Engine + Compose plugin) to run the full stack.

It is a **microservices architecture** made up of the following services:

| Service | Module folder | Port | Description |
|---------|---------------|------|-------------|
| **Orders** | `orders/` | 8080 | Menu and order management |
| **Payments** | `payments/` | 8081 | Payment confirmation |
| **Invoices** | `invoices/` | 8082 | Generates invoice XML to standard output |
| **Signer** | `signer/` | 8083 | Generates an MD5 hash of the payment event to standard output |

## Documentation

| Document | Description |
|----------|-------------|
| [docs/TECHNOLOGIES.md](docs/TECHNOLOGIES.md) | Stack overview (Quarkus, Flyway, Kafka, Hibernate Reactive, etc.) and where each technology is used |
| [docs/kafka-libraries.md](docs/kafka-libraries.md) | Kafka-related libraries and extensions (`quarkus-messaging-kafka`, MicroProfile Reactive Messaging, Jackson, Mutiny) |
| [docs/kafka-how-it-works.md](docs/kafka-how-it-works.md) | How Kafka is wired in this project (broker, topic, producer, consumers, configuration) |
| [docs/kafka-commands.md](docs/kafka-commands.md) | Step-by-step Kafka setup, topic management, and message testing |
| [docs/kafka-event-flow.md](docs/kafka-event-flow.md) | Payment event flows and verification tests |

## Run everything with Docker Compose

The `docker-compose.yml` file at the project root starts **Kafka**, **MySQL**, and all four microservices.

From the project root:

```sh
docker compose up --build
```

Use `--build` the first time (or after code changes). After that, `docker compose up` is enough.

Run in the background:

```sh
docker compose up --build -d
```

Stop everything:

```sh
docker compose down
```

To also remove MySQL data:

```sh
docker compose down -v
```

### Startup order

1. **MySQL** and **Kafka** start first
2. **kafka-init** creates the `paymentsConfirmed` topic, then exits
3. **orders**, **payments**, **invoices**, and **signer** start after dependencies are ready

The first run can take several minutes while Maven builds all four apps inside Docker.

### Verify it is working

```sh
curl http://localhost:8080/orders
curl http://localhost:8081/payments
```

Confirm a payment (publishes a `PaymentConfirmed` event to Kafka):

```sh
curl -X PUT http://localhost:8081/payments/1
```

Watch invoices and signer process the event:

```sh
docker compose logs -f invoices signer
```

### Ports

| Service | URL |
|---------|-----|
| Orders | http://localhost:8080 |
| Payments | http://localhost:8081 |
| Invoices | http://localhost:8082 |
| Signer | http://localhost:8083 |
| Kafka | localhost:9092 |
| MySQL | localhost:3306 |

If something fails, check service logs:

```sh
docker compose logs orders
docker compose logs payments
```

For event flows and verification tests, see [docs/kafka-event-flow.md](docs/kafka-event-flow.md).

---

## Local development (IntelliJ)

Alternatively, run each service individually with `quarkus:dev` in IntelliJ. You still need Kafka running — start it with:

```sh
docker compose up kafka mysql -d
```

Wait for Kafka to become ready, then create the topic (see [docs/kafka-commands.md](docs/kafka-commands.md)).

### Run the Payments service

Open the `payments/` module in IntelliJ.

Run the service via _Maven_ > _Plugins_ > _Quarkus_ > `quarkus:dev`.

In Postman, confirm a payment with `PUT http://localhost:8081/payments/1`.

When a payment is confirmed, the Payments service publishes a `PaymentConfirmed` event to the `paymentsConfirmed` Kafka topic.

### Run the Orders service

Open the `orders/` module in IntelliJ.

Run the service via _Maven_ > _Plugins_ > _Quarkus_ > `quarkus:dev`.

List orders at `http://localhost:8080/orders`.

Get order details (e.g. id 1) at `http://localhost:8080/orders/1`.

### Run the Signer service

Open the `signer/` module in IntelliJ.

The code is almost complete:

- the Kafka extension is added in `pom.xml`
- the broker address is configured in `application.properties`
- the `PaymentConfirmedEvent` class already exists with the required fields
- the `PaymentConfirmedConsumer` class already calls `Hash` and prints the result to the console

What is missing? Complete the `PaymentConfirmedConsumer` class (wire the `@Incoming` Kafka channel if not already done).

### Answer the quiz question

What is the hash for Godinez's order?
