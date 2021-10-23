package com.api.common;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

public class UsefulMethods {

    public static int getResponseCode(String status) {
        int code = 0;
        if (status.equalsIgnoreCase("Success")) {
            code = 200;
        } else if (status.equalsIgnoreCase("Not Found")) {
            code = 404;
        }
        return code;
    }

    public static JSONObject createJSON(String productId, String productName, String description) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", productId);
        requestParams.put("name", productName);
        requestParams.put("description", description);

        return requestParams;
    }

    public static Response getProductGetResponse(String productId) {
        Response response = SerenityRest.given().log().all().header("Content-Type", "application/json")
                .spec(CommonRequestSpec.commonReqSpec()).basePath("/{id}").pathParam("id", productId)
                .get().then().extract().response();

        return response;
    }

    public static Response getProductGetResponseWithouParam() {
        Response response = SerenityRest.given().header("Content-Type", "application/json")
                .spec(CommonRequestSpec.commonReqSpec())
                .get().then().extract().response();

        return response;
    }

    public static Response getProductPostResponse(JSONObject requestParams) {
        Response response = SerenityRest.given().header("Content-Type", "application/json")
                .spec(CommonRequestSpec.commonReqSpec()).body(requestParams.toJSONString())
                .post().then().extract().response();

        return response;
    }

    public static Response getProductPutResponse( JSONObject requestParams, String productId) {
        Response response = SerenityRest.given().log().all().header("Content-Type", "application/json")
                .spec(CommonRequestSpec.commonReqSpec()).basePath("/{id}").pathParam("id", productId)
                .body(requestParams.toJSONString()).put().then().extract().response();

        return response;

    }

    public static Response getProductDeleteResponse(String productId) {
        Response response = SerenityRest.given().log().all().header("Content-Type", "application/json")
                .spec(CommonRequestSpec.commonReqSpec()).basePath("/{id}").pathParam("id", productId)
                .delete().then().extract().response();

        return response;

    }

}
