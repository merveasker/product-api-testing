Feature: Product Service - Post Product - Save New Product

  Scenario: Save a valid product
    When I call endpoint with "1" product id and "test product" product name and "description of product" description for saving the new product
    Then "Success" response should be retrieved
    And The schema should match with the specification defined in "success_response_for_posting_product.json"
    And Response's "id" field's value should be "1"
    And Response's "name" field's value should be "test product"
    And Response's "description" field's value should be "description of product"

  Scenario: Delete product before add again
    When I call endpoint with "1" product id for deleting the product
    Then "Success" response should be retrieved
    And The schema should match with the specification defined in "delete_response_for_deleting_product.json"
    And Response's "ok" field's value should be "1"

  Scenario: Delete non existing product
    When I call endpoint with "1" product id for deleting the product
    Then "Success" response should be retrieved
    And The schema should match with the specification defined in "delete_response_for_deleting_product.json"
    And Response's "ok" field's value should be "0"