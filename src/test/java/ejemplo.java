import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
// se tiene que importar el static manualmente
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ejemplo {

    public static void main(String[] args) {

//        GIVEN - es donde configuro todo los detalle
//        WHEN -  es donde golpeo al metodo
//        THEN -  donde hago las validaciones

        String place_id = "";

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(ApiUtil.bodyAddPlaceApi())
                .when().log().all()
                .post("maps/api/place/add/json")
                .then().log().all()
                .assertThat()
                .statusCode(200)
//                validar el un valor de la respuesta
                .body("scope", equalTo("APP"))
                .extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        place_id = jsonPath.getString("place_id");


        //ACTUALIZANDO EL LUGAR

        System.out.println("==============ACTUALIZANDO PLACE================");

        String responsePut = given()
                .queryParam("key", "qaclick123")
                .body(ApiUtil.bodyPutPlaceApi(place_id))
                .when().put("maps/api/place/update/json")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();


    }
}
