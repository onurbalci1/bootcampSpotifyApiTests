package Services;
import helper.Helper;
import io.restassured.response.Response;
import org.json.JSONObject;
import spec.RequestSpec;


import static io.restassured.RestAssured.given;

public class CreatePlaylist extends RequestSpec {
    public CreatePlaylist() {
        super("/v1/users");
    }

    public String createPlayList(String userId, String jsonFileName){

        JSONObject body = Helper.readJsonFile(jsonFileName);

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .body(body.toString())
                        .post("/{userId}/playlists",userId)
                        .then()
                        .statusCode(201)
                        .extract()
                        .response();

        String playlistId =  response.jsonPath().getString("id");
        //System.out.println("Oluşturulan playlist ID : "+playlistId);
        return playlistId;
    }


}
