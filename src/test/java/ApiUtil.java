public class ApiUtil {

    public static String bodyAddPlaceApi() {
        return "{\n" +
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
                "}";
    }

    public static String bodyPutPlaceApi(String placeId) {
        return "{\n" +
                "\"place_id\":\"" + placeId + "\"," +
                "\"address\":\"70 winter walk, USA12\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }
}
