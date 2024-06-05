Draft of spark las reader-writer
# Build
docker-compose build
# Run test inside container 
```console 
docker-compose run  sedonadocker /bin/bash
```
	- Test for LAS reading
		```sbt run``` to run test or ```sbt console``` to run interpretor 
	- Sedona console
   ```console 
	/opt/spark/bin/spark-shell  --jars /opt/spark/jars/sedona-spark-shaded-3.4_2.12-1.5.0-SNAPSHOT.jar
   ```
