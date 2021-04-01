package Services;

import io.restassured.response.Response;
import spec.RequestSpec;

import static io.restassured.RestAssured.given;

public class CreateUser extends RequestSpec {

    public CreateUser() {
        super("/v1/me");
    }

    public String getUserId(){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        String userId  = response.jsonPath().getString("id");
        //System.out.println("Oluşturulan user ID : " +userId);
        return userId;

    }
}
