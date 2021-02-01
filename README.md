
## Asset Administration Shell Registry Interface 

The Asset

|                         Name Space                                                  |        GET         |        PUT         |       DELETE       |
|------------------------------------------------------------------------------------ | ------------------ | ------------------ | ------------------ |
|http://localhost:9120/api/v1/registry                                                | :heavy_check_mark: |       :x:          |      :x:           |  
|http://localhost:9120/api/v1/registry/ &lt;aasId&gt;                                 | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |              
|http://localhost:9120/api/v1/registry/ &lt;aasId&gt;/submodels/&lt;submodelId&gt;    | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |              
|http://localhost:9120/api/v1/registry/ &lt;aasId&gt;/submodels                       | :heavy_check_mark: |       :x:          |      :x:           |                
  


### Configuration
<pre><code>
LIA_MONGO_HOST=vws_aas_registry_mongo          IP Address of the external Mongo Database
LIA_MONGO_PORT=27107                           Port of the external Mongo Database
LIA_MONGO_CONTAINER=vws_aas_registry_mongo     In case a new mongo database is required, docker image is provided in the docker-compose.yml file. 
LIA_AAS_RESTAPI_HOST_EXTERN=localhost          IP address of the registry interface at which the REST API services are available
LIA_AAS_RESTAPI_PORT_EXTERN=9021               Port of the registry interface at which the REST API services are available  
LIA_AAS_RESTAPI_PORT_INTERN=80                 Internal port for rest api interface in case multiple docker imgaes providing rest services
LIA_AAS_MQTT_HOST=localhost                    IP address of the external MQTT server (THe application listens to the topic VWS_AAS_Registry over this server) 
LIA_AAS_MQTT_PORT=1883                         Port of the external MQTT server 
LIA_AAS_OPCUA_HOST=localhost                   IP address of the registry interface at which OPCUA services are available  (Currently not operationl.)
LIA_AAS_OPCUA_PORT=4840                        Port of the registry interface at which the OPCUA services are available 
LIA_AAS_ETHEREUM_HOST=localhost                IP address of the external ethereum network  
LIA_AAS_ETHEREUM_PORT=31003                    Port of the external ethereum network 
LIA_dockerimage=mongo                          Mogo Database docker image
LIA_preferedI40EndPoint=MQTT                   The prefered communication endpoint over which the registry interface looks for incoming messages
LIA_preferredCommunicationFormat=JSON          The prefered communication format 
LIA_ethereumHashId=2222-3333-44444-4444        Ethereum hash Id for this registry interface 
</code></pre>

