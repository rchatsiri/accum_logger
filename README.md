accum_logger
============

* Accumulation logger from HDFS and Flume seeds data into spark services.
* Simple test
	* ``` sbt testOnly DateUtilsSpec ```

* Logstash 
	``` 
sudo docker run -d --net=logstash-new --name logstash  \
--add-host="kafka-1:10.20.152.92" \
--add-host="kafka-2:10.20.152.93" \
--add-host="kafka-3:10.20.152.94" \
-v /opt/cb/prod/pipeline/logstash/config:/usr/share/logstash/config/  \
-v /opt/cb/prod/pipeline/logstash/pipeline:/usr/share/logstash/pipeline \
-v /opt/cb/prod/pipeline/logstash/logs:/usr/share/logstash/logs \
-v /opt/cb/prod/pipeline/logstash/sincedb:/usr/share/logstash/sincedb \
-v /opt/cb/prod/web/nginx/log:/var/log/nginx/ \
--log-driver=json-file \
--log-opt max-size=100m \
--log-opt max-file=5 \
logstash:7.6.1
	```

* Kafka create topic
	```
kafka-topics --create --topic CBPAY-NGINX-MSG-DEVACS-00 \
--zookeeper 10.20.152.92:2181/kafka \
--partitions 3 \
--replication-factor 1
	```