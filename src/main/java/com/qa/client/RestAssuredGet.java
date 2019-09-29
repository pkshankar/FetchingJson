package com.qa.client;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredGet {

	public Response restAssuredGet(String url) {

		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		return httpRequest.request(Method.GET);

	}

}
