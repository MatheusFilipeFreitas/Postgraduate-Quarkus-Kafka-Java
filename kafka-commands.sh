docker exec -it kafka /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic paymentsConfirmed
# Created topic paymentsConfirmed.

docker exec -it kafka /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
# __consumer_offsets
# paymentsConfirmed

docker exec -it kafka /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic paymentsConfirmed
# Topic: paymentsConfirmed  PartitionCount: 3  ReplicationFactor: 1

docker exec -it kafka /opt/kafka/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic paymentsConfirmed
# >{"paymentId": 1, "orderId": 1}
# >{"paymentId":2,"orderId":2}
# >

docker exec -it kafka /opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic paymentsConfirmed --from-beginning
# {"paymentId": 1, "orderId": 1}
# {"paymentId":2,"orderId":2}

docker exec -it kafka /opt/kafka/bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --all-groups --describe
