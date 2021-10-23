package com.api.steps;

import io.restassured.response.Response;
import com.api.common.CommonRequestSpec;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static com.api.common.UsefulMethods.*;
import static org.assertj.core.api.Assertions.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Actions {

    private Response response;

    @Step("Response should be retrieved with code {integer}")
    public void verifyResponseCode(int responseCode, Response lastResponse) {
        assertThat(lastResponse.statusCode()).isEqualTo(responseCode);
    }

    @Step("The schema should match with the specification defined in {string}")
    public void verifyResponseSchema(Response lastResponse, String schemaJson) {
        lastResponse.then().body(matchesJsonSchemaInClasspath("schema/" + schemaJson));
    }

    @Step("call endpoint with {String} product id for getting the product's information")
    public Response sendGetRequestWithProductId(String productId) {
        response = getProductGetResponse(productId);
        response.prettyPrint();
        System.out.println(response);
        return response;
    }

    @Step("call endpoint with {String} product id for deleting the product's information")
    public Response sendDeleteRequestWithProductId(String productId) {
        response = getProductDeleteResponse(productId);
        response.prettyPrint();
        System.out.println(response);
        return response;
    }

    @Step("call endpoint without any product id for getting all the product's information")
    public Response sendGetRequestWithoutProductId() {
        response = getProductGetResponseWithouParam();
        response.prettyPrint();
        System.out.println(response);
        return response;
    }

    @Step("call endpoint with {string} product id and give new values as {string} product name and {string} description for updating the product")
    public Response sendUpdateRequestWithProductId(String productId, String productName, String description) {
        JSONObject requestParams = createJSON(productId, productName, description);

        response = getProductPutResponse(requestParams, productId);
        response.prettyPrint();
        System.out.println(response);
        return response;
    }


    @Step("Get field value from response")
    public String getFieldValue(String field, Response response) {
        return (response.getBody().jsonPath().getString(field));
    }

    @Step("{string} field's value should be {string}")
    public void validateFieldValue(String field, String fieldValue, Response lastResponse) {
        assertThat(getFieldValue(field, lastResponse)).isEqualToIgnoringCase(fieldValue);
    }

    @Step("Verify that response is empty list")
    public void responseShouldBeEmptyList(Response lastResponse) {
        assertThat(lastResponse.getBody().jsonPath().getList("").size()).isEqualTo(0);
    }

    @Step("I call endpoint with {string} product id and {string} product name and {string} description for saving the new product")
    public Response sendPostRequest(String productId, String productName, String description) {
        JSONObject requestParams = createJSON(productId, productName, description);

        response = getProductPostResponse(requestParams);
        response.prettyPrint();
        System.out.println(response);
        return response;
    }

}
