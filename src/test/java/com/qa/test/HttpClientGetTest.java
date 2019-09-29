package com.qa.test;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.qa.client.HttpClientGet;

public class HttpClientGetTest {

	@Test
	public void httpClientValidateJson() throws ClientProtocolException, IOException {

		HttpClientGet httpClient = new HttpClientGet();
		CloseableHttpResponse closeableHttpResponse = httpClient
				.httpClientGet("https://restcountries.eu/rest/v2/capital/Washington");
		System.out.println("STATUS CODE USING HTTP CLIENT : " + closeableHttpResponse.getStatusLine().getStatusCode());
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		responseString = responseString.substring(1, responseString.length()-1);
		JSONObject jsonObj = new JSONObject(responseString);
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
	

	}

}
