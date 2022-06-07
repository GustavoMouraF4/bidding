curl --connect-timeout 5 \
     --max-time 10 \
     --retry 6 \
     --retry-delay 0 \
     --retry-max-time 80 \
     --retry-connrefused \
     -X POST -H "Content-Type: application/json" http://localhost:8083/connectors -d '{
  "name": "mongo-source",
  "config": {
    "connector.class": "com.mongodb.kafka.connect.MongoSourceConnector",
    "connection.uri": "mongodb://mongo",
    "database": "bidding",
    "collection": "outboxEvent",
    "publish.full.document.only": true
  }
}'