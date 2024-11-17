### Spring Data JPA
- The information about the entities in your code, you would also like to keep them in your db in the form
of tables
- OOP -> Objects -> Persist in DB
- ORM : Object relational mapper
- ORM Provides you an easy way to interact with db & converting data into classes and obj:
  - write queries
  - convert results to queries
  - joins
  - methods / functions to make working with db easier
  - Eg. Hibernate

- Now if we want to move to another API, we'll have to change the apis i.e methods called to apis
- Here we are coding to an implementation, instead we should code to an interface
- JPA (Jakarta Persistence API) comes to rescue, it is just an interface (no implementation) which gives us standard
apis or methods to interact with different ORM libraries.
- Hibernate is one of the libraries which implements JPA

- Now, Hibernate or any ORM library will not directly connect to Mysql Driver or MongoDB driver.
- Hibernate connects to an interface called JDBC (Java DB Connector) which is implemented by Mysql driver,
Postgres Driver, Mongo driver, etc.
- finally Mysql driver talks to the actual database

- Now, we as a spring boot dev don't directly connect with JPA, we talk to Spring Data JPA which provide sensible
defaults to talk to JPA

FLOW 
`DEV -> Spring Data JPA -> JPA -> Hibernate -> JDBC -> Mysql Driver -> Database`

### Repository Pattern
Code to interact with persistence layer should be separate from the business logic
i.e Service layer should not directly talk to db

Service will talk to repository layer which will talk to db

FLOW

`DEV -> Controller -> Service -> Repo -> Spring Data JPA -> JPA -> Hibernate -> JDBC -> Mysql Driver -> DB`


### Types of Tables Annotation
1. Mapped Superclass
- No table for parent class
- Each child class will a table
- Attributes of parent class will be present in the child class table

2. Table per class
- Table will be there for Parent class and Child class both
- Attributes of parent class will be present in the child class table
- Con is if where clause is on parent attribute, we have to check all the child tables
- Pro is if where clause is on child attribute, it is very fast

3. Joined Table
- Table will be there for Parent class and Child class both
- Attributes of parent class will not be present in the child class table
- To return all the attributes, we have to join parent & child tables
- Here pro is if where is on parent attribute, we just have to query parent table
- Con is with child table, we have to join with parent table

4. Single Table
- Here parent and all child attributes are part of single table
- Pro is queries are faster, we don't have to do joins
- Con is we can't insert a row where there is not null attribute and we don't have value for it,
also redundant col values and null values are more in such tables


### Cardinality Mappings
4 types of cardinality
1:1, 1:M, M:1, M:N

How to represent them in DB?
- 1:1 -> id of one side on other side
- 1:M or M:1 -> id of 1 side on M side
- M:N -> separate mapping table


There can be many relations between two same entities on different attributes in a class
Eg. 
Group to Users
Members field : 1 group can have n members and 1 member can be part of n groups, m:n
groupCreator field : 1 group can have 1 creator and 1 creator can create many groups, m:1

Therefore, we represent relations at field level in a class

Eg. Annotate Category in Product class, then JPA will create a category_id in product table
and annotate product in Category class

### Fetch types: Eager and Lazy Loading in Hibernate
For eg.
If a Category class has List<Product>
in eager loading, JPA will load all the attributes of category as well as all the products associated
with the category, it will use join on both tables and therefore it is not a good choice where
we have thousands of products

In lazy loading, it will load the category only and product will be loaded on demand.

### Cascade Types
CascadeType.PERSIST
- While saving an entity into db PERSIST also create associated entities in the table
- Eg. While creating product, it will first create an entry into category and price and then
into Product table
- @ManyToOne(cascade = CascadeType.PERSIST)


CascadeType.REMOVE
- This removes the associated entity if the parent entity is removed
- Eg. If we delete Product, price should be deleted as well


### Fetch modes : SELECT, SUBSELECT, JOIN


### N+1 problem
- Take an example where we're sending a list of category ids to a method whose job is to return
all the category object and it also has list of products associated with each category
- With default FetchMODE.SELECT it will make 1 db call to fetch all the categories with those ids
and n calls to product table to fetch products associated with each n category and here
we're making n+1 calls
- With FETCHMODE.SUBSELECT it will make only 2 calls, 1 to fetch all the categories and another to
fetch the products with in (?,?,?) all category ids


### manual schema creation
- When we set spring.jpa.hibernate.ddl-auto=update, JPA automatically creates tables for us
- when we set spring.jpa.hibernate.ddl-auto=none, JPA does not create tables for us and does even give 
compile time error.. error comes at runtime
- spring.jpa.hibernate.ddl-auto=validate, for this we get error on compile time only.. it is better than none
- We can use flyway init migration & flyway versioned migration option from JPA buddy to create scripts
that will be run to create tables. This is useful when we already have a production ready schema
and we have add a table / column.. versioned schemas are useful
- In resources/db.migration it creates scripts like V1__init_db.sql and write all the queries in that


### Schema migration libraries
- flyway : can be used for 90% of people
- liquibase : has more features


















