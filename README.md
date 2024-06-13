Draft of spark las reader-writer
# Build
docker-compose build
# Run test inside container 
```console 
docker-compose run  sedonadocker /bin/bash
```
##  Run LAS reading tests
to run test : 
```source scripts/run_test_las.sh```
to run interpretor :
```sbt console```

## Run Sedona example
   ```console
   cd /opt/workspace/sedona/examples/spark-sql
   $SPARK_HOME/bin/spark-submit --master local[*] --class Main target/sedona-spark-example-1.6.0.jar
   ```

