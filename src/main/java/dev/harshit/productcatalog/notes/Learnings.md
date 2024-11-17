### If there are 2 types of a particular interface
- Dependency injection won't work in constructor, we have to
use @Qualifier("name") in the constructor which should match the name given to the service
in @Service("name")
- we can also define a variable in application.properties and use that in
@Qualifier


### Type erasure
- ArrayList<Integer> -> it only works at compile time for compiler to check if all the ele in the list is integer or not
- At runtime, the info about data type of generic is erased
- So ArrayList<Integer> at runtime will be ArrayList.class
- Before Java 5, there were no generics
- To ensure backward compatibility, java introduced generics via type erasure

### Difference between @Primary & @Qualifier
- Both are used when there are multiple implementation classes of a interface
- @Primary is used on a specific implementation class to mark it as a primary class to use
- @Qualifier is used in the calling class where we define which implementation to use


### @Value
- we can @Value to use values from application.properties
- eg. @Value("${fakestore.api.url}")
  private String fakeStoreDomain;


### protobuffs
- In requests, data is sent as a json string
- JSON is optimized for readability
- JSON is not directly sent over the network, it is serialized first
- converting a json string to an object will take time
- Converting an object to a string is called serialization
- reverse is deserialization
- This takes time while receiving and sending json payload

- Protocol buffers are language neutrals, platform neutrals, extensible mechanism for serializing structured data
- Protobuff sends the binary of object over the network
- Proto is already an Object, it does not serializes it.. it directly sends the binary of the object
over the network

Pros:
- Protobuffs are faster since we do not have to serialize the data

cons:
- you cannot read payload or response
- 

eg proto
```proto
message Animal {
  int32 age;
  String name;
  String type;
}
```

Protos are structured data while jsons are not
Here 32 bytes will be reserved for age, 20 for name and 20 for type
Even if you don't send the age, 32 bytes will be reserved

Now, this structured data will be sent over the network in binary

### RPC's (Remote Procedural Calls)

Client -> Call Rest Endpoint

Client -> Call method

Calling a method directly is RPC
eg. calling ProductService.createProduct();

This is not popular primary reason being they are not structured.

There is a new implementation of RPC by Google is called gRPC
gRPC is used with proto buffs
gRPC is used for interserver communication
https://www.baeldung.com/spring-rest-api-with-protocol-buffers
 






















