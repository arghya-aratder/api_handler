package api.weathermap.req;

import static io.restassured.RestAssured.*;

public class CityWeather {
	
	
	String baseUrl;
	
	public CityWeather (String Url)
	{
		this.baseUrl=Url;
		
	}
	
	
	public float getCityTemperature(String city, String key){
		 
		   float tem =  ( given().queryParam("q",city)
		           .queryParam("appid",key)
		           .when().get(this.baseUrl+"/data/2.5/weather").then().extract().path("main.temp"));
		   return (float) (tem - 273.15);
		}
	
	

}
