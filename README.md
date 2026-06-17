# florinda-eats-microservices

Florinda Eats is a food delivery application for Dona Florinda's restaurant.

**Requirements:** JDK 25 and Maven 3.9+

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
| [TECHNOLOGIES.md](TECHNOLOGIES.md) | Stack overview (Quarkus, Flyway, Kafka, Hibernate Reactive, etc.) and where each technology is used |
| [kafka-commands.md](kafka-commands.md) | Step-by-step Kafka setup, topic management, and message testing |
| [kafka-commands.sh](kafka-commands.sh) | Quick reference shell script with the most common Kafka commands |

## What you need to do

### Run Kafka

The `docker-compose.yml` file at the project root starts Kafka on port **9092**.

From the project root:

```sh
docker compose up
```

Wait a moment for Kafka to become ready.

To create the topic and run other useful commands, see [kafka-commands.md](kafka-commands.md).

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
