package com.qa.test;

import org.json.JSONObject;
import org.testng.annotations.Test;
import com.qa.client.RestAssuredGet;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredGetTest {
	
	@Test
	public void restAssuredValidateJson() {
		
		RestAssuredGet restAssuredGet = new RestAssuredGet();
		Response response = restAssuredGet.restAssuredGet("https://restcountries.eu/rest/v2/capital/Washington");
		String responseString = response.getBody().asString();
		responseString = responseString.substring(1, responseString.length()-1);
		JSONObject jsonObj = new JSONObject(responseString);
		
		// APPROACH 1 TO FETCH ELEMENTS FROM JSON RESPONSE
		System.out.println(jsonObj.get("name").toString());
		System.out.println(jsonObj.getString("name"));
		System.out.println(jsonObj.getJSONObject("translations"));
		System.out.println(jsonObj.getJSONArray("topLevelDomain").get(0));
		System.out.println(jsonObj.getJSONArray("callingCodes").get(0));
		System.out.println(jsonObj.getJSONArray("altSpellings").get(2));
		System.out.println(jsonObj.getJSONArray("latlng"));
		System.out.println(jsonObj.getJSONArray("timezones").get(0));
		System.out.println(jsonObj.getJSONArray("currencies").getJSONObject(0).getString("code"));
		System.out.println(jsonObj.getJSONArray("languages").getJSONObject(0).getString("nativeName"));
		System.out.println(jsonObj.getJSONObject("translations").getString("pt"));
		System.out.println(jsonObj.getJSONArray("regionalBlocs").getJSONObject(0).getJSONArray("otherNames").get(1));
		
		
		// APPROACH 2 TO FETCH ELEMENTS FROM JSON RESPONSE
		JsonPath jPath = response.jsonPath();
		System.out.println(jPath.getString("name"));
		System.out.println(jPath.getString("topLevelDomain").replace("[", "").replace("]", ""));
		System.out.println(jPath.getString("altSpellings").replace("[", "").replace("]", ""));
		System.out.println(jPath.getString("timezones").replace("[", "").replace("]", ""));
		System.out.println(jPath.getString("currencies").replace("[", "").replace("]", ""));
		System.out.println(jPath.getString("regionalBlocs"));

		
		
		
	}

}
