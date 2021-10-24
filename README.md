# Product API Test Automation

# Introduction

This is a Product Rest API test solution for sample endpoints. The published API represents a product application where users can add a new product, get the products' information, delete and update a product.

Tests are written using a combination of SerenityBDD, RestAssured, Cucumber, Junit & Maven.

# The project directory structure

```Gherkin
src
  + test
    + java                                              Test runners and supporting code
      + common                                          Package for all common actions
          CommonRequestSpec                             Common Request Spec for the End point calls
          UsefulMethods                                 Methods for the calling and checking End points 
      + run
          CucumberTestSuite                             Cucumber configurations and options
      + stepdefinitions                                 Step definitions for the BDD features          					
      + steps                                           Domain model package consisting of all actions to get weatherstack functionality
          Actions                                       End point calls on Product API
    + resources
      + features                                        Feature files directory
          get_and_update_product.feature                Feature containing BDD scenarios
          post_and_delete_product.feature               Feature containing BDD scenarios
      + schema                                          Folder containing json schema for End point schema validation
      serenity.conf                                     Configurations file

```
# Executing the tests
Run `mvn clean verify` from the command line.

The test results will be recorded here `target/site/serenity/index.html`.
Please run the below command from root directory to open the result after execution.
```bash
open target/site/serenity/index.html 
```

Here is the direct link to the GitHub project page: https://github.com/merveasker/product-api-testing

# Additional configurations

Additional command line parameters can be passed for switching the application environment.
```json
$ mvn clean verify -Denvironment=dev
```
Configurations to for different environments are set in the `test/resources/serenity.conf` file. In real time projects each environment can be configured with its baseurl to run the tests based on different environments.
