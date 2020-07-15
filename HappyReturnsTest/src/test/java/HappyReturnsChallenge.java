import com.google.gson.*;
import org.json.*;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class HappyReturnsChallenge {

    private static final String baseuri = "https://happyreturnsqatest.free.beeceptor.com/";



    @Test
    public void getProductVariants(){

       Response response = when().get(baseuri + "getProductVariants").
                then().
                contentType(ContentType.JSON).
                extract().response();

        JSONObject jsonObject = new JSONObject(response.body().asString());

        String result = given().baseUri(baseuri)
                .header("Content-Type", "application/json")
                .when()
                .body(jsonObject)
                .request("POST", "order")
                .then().statusCode(201)
                .extract()
                .body().jsonPath().prettyPrint();

        System.out.println(result);

    }




}
