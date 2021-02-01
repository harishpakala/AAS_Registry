
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
LIA_MONGO_PORT=27107
LIA_MONGO_CONTAINER=vws_aas_registry_mongo
LIA_MONGO_HOST=vws_aas_registry_mongo
LIA_AAS_RESTAPI_HOST_EXTERN=localhost
LIA_AAS_RESTAPI_PORT_EXTERN=9021
LIA_AAS_RESTAPI_PORT_INTERN=80
LIA_AAS_MQTT_HOST=localhost
LIA_AAS_MQTT_PORT=1883
LIA_AAS_OPCUA_HOST=localhost
LIA_AAS_OPCUA_PORT=4840
LIA_AAS_ETHEREUM_HOST=localhost
LIA_AAS_ETHEREUM_PORT=31003
LIA_dockerimage=mongo
LIA_preferedI40EndPoint=MQTT
LIA_preferredCommunicationFormat=JSON
LIA_ethereumHashId=2222-3333-44444-4444
</code></pre>

