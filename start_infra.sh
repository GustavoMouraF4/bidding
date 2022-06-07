docker-compose up -d
sleep 30
./rs-init.sh
sleep 10
./config-connect.sh
