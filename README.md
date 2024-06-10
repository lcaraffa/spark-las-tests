Draft of spark las reader-writer
# Build
docker-compose build
# Run test inside container 
```console 
docker-compose run  sedonadocker /bin/bash
```
##  Run LAS reading tests
to run test : 
```sbt run```
to run interpretor :
```sbt console``` 
# Run Sedona jupyterlab
   ```console 
   docker-compose up sedonajupyter
   ```
   then go to http://localhost:8888/lab?
