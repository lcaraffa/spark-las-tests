Draft of spark las reader-writer
# Build
```console 
docker-compose build
```
or 
```console 
./scripts/build_image.sh
```
# Run test inside container 
First run and go inside container
```console 
docker-compose run  sedonadocker /bin/bash
```
or 
```console
./scripts/run_container.sh
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

