# API PetStore

This is a project to API testing for PetStore

# Technnologies

- Cucumber
- SerenityRest
- Java


#### Swagger Files
The source of truth is the Swagger File related to each module. Some of these files are:
- https://petstore.swagger.io/


# Project Structure

1) One .feature file describing the test scenarios
2) A Service Class that encapsulates the endpoint
3) A Steps Class that implement all the steps mentioned in the .feature file
4) A Runner class for local tests


#### Re-using feature steps
Each step of the feature file must be implemented, but sometimes someone 
already implemented that step you need in a previous test. Because of this,
**always make sure that your step was not already implemented in other test** before 
start implementing it. 


#### Scenario tags
The test scenarios have different tags that help classifying the different test and
later making it easier to run them locally via runner file.

The different tags are:
- **@findPurchase**: This scenario creates a new order for a pet and then this order can be looked and found by user
- **@GetInventory**: This scenario returns the pet inventory by status
- **@DeletePurchase**: This is scenario delete purchase order by ID

Every step present in a Feature file needs to be implemented in the 
corresponding Steps Definition class.

**maybe your step was already implemented**. You can also add new implementations
to this file, just make sure that the code is generic enough to be usable by
other Services too.

The plugins, libraries, dependencies that should be installed are following:
- Serenity version 2.3.4
- Dependency slf4j version 1.7.7
- Dependency Google guava version 23.6-jre
- Serenity BDD version 2.3.4
- Serenity Core version 2.3.4
- Serenity-junit version 2.3.4
- Serenity-cucumber6 version 2.3.4
- Junit version 4.12
- assertj-core version 3.6.2
- Hamcrest version 1.3
- serenity-single-page-report version 2.1.2
- jackson-databind version 2.10.0.pr1
- json version 20160810
- maven-surefire-plugin version 2.20
- maven-failsafe version 2.18.1
- serenity-maven-plugin 2.3.4
- serenity-core 
- maven-compiler-plugin 


#Runner Class
You can create a Runner class in order to perform the tests in your locale. In case of use
of a Runner, it should be located in `src/test/java/runners`

##Running tests

Once the tests are fully implemented, there are three ways of checking 
the results:
1) Execution of the Runner Class (local)


##Execution of Runner Class
Simply go to the Runner Class and run it from your current IDE. Make
sure that the tags matches with the ones set in your Feature files.
You can check some examples in the folder `src/test/java/runners`.
