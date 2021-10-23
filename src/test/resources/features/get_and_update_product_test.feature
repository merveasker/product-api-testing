Feature: Product Service - Get Products End Point results

  Scenario: Save a valid product before getting it
    When I call endpoint with "9" product id and "test product" product name and "product description" description for saving the new product
    Then "Success" response should be retrieved

  Scenario: Get a valid product's result
    When I call endpoint with "9" product id for getting the product's information
    Then "Success" response should be retrieved
    And The schema should match with the specification defined in "success_response_for_getting_specified_product.json"
    And Response's "id" field's value should be "9"
    And Response's "name" field's value should be "test product"
    And Response's "description" field's value should be "product description"

  Scenario: Get all the products' result
    When I call endpoint without any product id for getting all the product's information
    Then "Success" response should be retrieved
    And The schema should match with the specification defined in "success_response_for_getting_all_products.json"

#  Scenario Outline: Failure response should be returned while using invalid query parameters
#    When I call endpoint with "<productId>" product id for getting the product's information
#    Then "Not Found" response should be retrieved
#    #TODO And The schema should match with the specification defined in "fail_response_for_getting_product.json"
#    Examples:
#      | productId |
#      | 1000000   |
#      | abc       |

  Scenario: Update a valid product's information
    When I call endpoint with "9" product id and give new values as "updated test product" product name and "updated description" description for updating the product
    Then "Success" response should be retrieved
    And The schema should match with the specification defined in "success_response_for_updating_product.json"
    And Response's "id" field's value should be "9"
    And Response's "name" field's value should be "updated test product"
    And Response's "description" field's value should be "updated description"

  Scenario: Delete product before adding again
    When I call endpoint with "9" product id for deleting the product
    Then "Success" response should be retrieved
    And Response's "ok" field's value should be "1"
