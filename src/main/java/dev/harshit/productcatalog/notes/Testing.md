### WHy is testing needed ?
- Testing provides an extra layer of security for the application

### What are unit cases ?
- Unit cases are there to test a specific method
- we write our feature and can test a method for many diff cases

### TDD (test driven development)
- It is where we write all the test cases first and then write the method which these test cases
will test.

### Flaky test
- Flaky test are testcases which undeterministically gives result
- sometimes true and sometimes false for the same data
- It happen when we write async operation or concurrency is involved or when randomization is involved


### Types of Testing:
1. Integration testing
- This is a testing where we don't mock results from any 3rd party service or database
- Call to a service will call 3rd or db and fetch the actual data.
- This is helpful when we want to test the 3rd party services as well and do end to end testing of an
api.
- A problem with these testing is most of times it fails
    - A case where network fails or database is down or 3rd party service is down.. in such cases
  integration testing gives failure

2. Unit Testing
- Typically test a small unit of your app, method or class
- It is short and fast
- Not dependent on external dependencies
- Here we don't call external dependencies, we mock their results assuming that is working fine.. we 
test 1 method in isolation.
- Here each public method in your codebase, we write multiple testcases.
- What all cases we should test a method for:
  - bad cases : unexpected cases
  - corner cases: situations where things can go wrong
  - happy cases: Things which should go right
For eg. doSomething(arr, index)
  - For this what all cases should we test
  - Test cases for arr: when arr is null, [], [1], [1,2], [1,2,3]
  - Test cases for index: when index is 0, -1, len(arr), len(arr)-1
  - We should test all these cases

3. Functional testing
- It is testing a codebase against a functionality end to end
- It typically tests a business logic
- You hit the api from a test.. it will run all the logic and you will check the output of the api


So unit cases tests a small unit -> mostly used
integration test tests the entire method without mocking -> less used
functional test tests the entire api -> very less used


### Unit Testing Best Practices
1. It should be fast
  - Arrange: setup environment i.e create object of the class whose method you want to test
  - Act: call the method you want to test
  - Assert: check the result
It is also called CCC (create, call, check)

2. Isolation
- mock every external dependency

3. Repeatable
- no flakiness

4. Self checking
- no manual inputs required

5. Test Behaviour, not implementation
- Test what you expect from a unit, not how that behaviour is implemented
- eg. Don't test what DP is used, or any arraylist is used or not.. just test the response of a
unit.. if it is returning correct thing or not


In Test folder, `hierarchy should be similar to code`
for eg. controller, service folders
Test class should be like `ProductControllerTest` and annotate it with `@SpringBootTest`
Every method should be annotated with `@Test`

We've few asserts
- assert()
- assertEquals(expected, actual, message)
- assertTrue(condition, message)
- assertNull
- assertNotNull
- assertThrows(exception.class, () -> {})
















