package com.api.stepdefinitions;

import com.api.steps.Actions;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import com.api.common.UsefulMethods;

public class TestSteps {

	@Steps
	Actions steps;

	@And("The schema should match with the specification defined in {string}")
	public void theSchemaShouldMatchWithTheSpecificationDefinedIn(String spec) {
		steps.verifyResponseSchema(lastResponse(), spec);
	}

	@When("I call endpoint with {string} product id for getting the product's information")
	public void callEndpointForGettingProduct(String productId) {
		steps.sendGetRequestWithProductId(productId);
	}

	@When("I call endpoint with {string} product id for deleting the product")
	public void callDeleteEndpointForGettingProduct(String productId) {
		steps.sendDeleteRequestWithProductId(productId);
	}

	@When("I call endpoint without any product id for getting all the product's information")
	public void callEndpointWithoutAnyProductIdForGettingAllTheProductSInformation() {
		steps.sendGetRequestWithoutProductId();
	}

	@When("I call endpoint with {string} product id and give new values as {string} product name and {string} description for updating the product")
	public void callEndpointForUpdatingProduct(String productId, String productName, String description) {
		steps.sendUpdateRequestWithProductId(productId, productName, description);
	}

	@Then("{string} response should be retrieved")
	public void responseShouldBeRetrieved(String status) {
		int code = UsefulMethods.getResponseCode(status);
		steps.verifyResponseCode(code, lastResponse());
	}

	@And("Response's {string} field's value should be {string}")
	public void fieldSShouldBe(String field, String fieldValue) {
		steps.validateFieldValue(field, fieldValue, lastResponse());
	}

	@Then("Empty response should be returned")
	public void emptyResponseShouldBeReturned() {
		steps.responseShouldBeEmptyList(lastResponse());
	}

	@When("I call endpoint with {string} product id and {string} product name and {string} description for saving the new product")
	public void callEndpointForSavingTheNewProduct(String productId, String productName, String description) {
		steps.sendPostRequest(productId, productName, description);
	}

}
