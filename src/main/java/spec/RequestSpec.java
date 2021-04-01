package spec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    RequestSpecification requestSpecification;
    private String baseUrl = "https://api.spotify.com";
    private String token = "BQDvQ6aKPqvuJv93C2A9Tnc-89DubhZIjWAjJrYD7n58VTLBZR6fT-vX6_2-xzYA27Skj1FFJfLbvImt7KkT5ENhbvtG-ZNrIXMWEIdQvg50DNqNyfHZL7NWZ3VzRP-Vgxy58daXnUfNzHsH-gfF0kUoqOHebPLAdvABdDxk23J1sHRSy9sYuEBdSslI5rrg4j9vXR-oGUk8SvxlpFNXEMhDNCeBFoS9y-sTeV8PPUgJo3R5k4KCAugjthUE_jmDLn58vU0DAW5fL-CWJmHsbY3px6szNC2-Cp23TUGI";
    public RequestSpec(String endPoint){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl+endPoint)
                .addHeader("Authorization","Bearer " +token)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
