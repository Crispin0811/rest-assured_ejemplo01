import io.restassured.RestAssured;
// se tiene que importar el static manualmente
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ejemplo {

    public static void main(String[] args) {

//        GIVEN - es donde configuro todo los detalle
//        WHEN -  es donde golpeo al metodo
//        THEN -  donde hago las validaciones




        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}")
                .when().log().all()
                .post("maps/api/place/add/json")
                .then().log().all()
                .assertThat()
                .statusCode(200)
//                validar el un valor de la respuesta
                .body("scope", equalTo("APP"));
    }
}
