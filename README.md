# running-information-analysis
Cs504 homework


Steps to run the 'running information analysis' service

1. git clone https://github.com/Sisy/running-information-analysis.git into your local 

2. Make sure your local has maven, java path, and docker set up
      mac: https://www.mkyong.com/java/maven-java_home-is-not-defined-correctly-on-mac-osx/
      windows: https://www.mkyong.com/maven/how-to-install-maven-in-windows/
      ....
      docker: https://docs.docker.com/engine/installation/
      
3. After you download the running-information-analysis service.
    cd running-information-analysis
    run mvn clean install

4. Make sure you have local server 8080 and mysql 3306 ports available.
    Troubleshooting:
    1) If your local service is not shutting down: google it.
    2) If mysql is not shutting down:
      docker-compose stop
      docker-compose rm
 
5. Start your local mysql db. Under running-information-analysis folder:
    run docker-compose up
        
    
6. Start your server: 
    run ls, user should see the target file 
    cd target
    run java -jar <the compiled Jar file>


Steps to test the rest api
    
    
    1. Api http://localhost:8080/runningInformation 
    
      (Post) Create a list of the running information. Please use the appropriate Json file. For instance:  
       [{
            "runningId": "7c08973d-bed4-4cbd-9c28-9282a02a6032",
            "latitude": "38.9093216",
            "longitude": "-77.0036435",
            "runningDistance": "39492",
            "totalRunningTime": 2139.25,
            "heartRate": 0,
            "timestamp": "2017-04-01T18:50:35Z",    
            "username": "ross0",
            "address": "504 CS Street, Mountain View, CA 88888"
        }]  
        After the request succeeded, dev should see the 201 code, with no returned body.
    
    2. Api http://localhost:8080/http://localhost:8080/runningInformation/username/{username}?page={page}&size={size} 
       (Get) Query the running information with username. 
       
        When request succeeded, dev should see the running information list, with the query username 
        
    3  Api http://localhost:8080/runningInformation/runningId/{runningId}?page={page}&size={size} 
       
       (Get) Query the running information with runningId.
       
       When request succeeded, dev should see the running information list, with the query runningId.
       
    4  Api http://localhost:8080/runningInformation?page={page}
    
       (Get) Query the running information
       
       When request succeeded, dev should see the running information list with 2 items per page. 
       The list should be ordered by healthWarningLevel from HIGH to LOW.
       
    5  Api http://localhost:8080/runningInformation/runningId/{runningId} 
        
       (Delete) Delete the running information with query runningId
        
        When request succeeded, the dev should see the 200 code, with no return body.
        
       
       
       
       
        
    
