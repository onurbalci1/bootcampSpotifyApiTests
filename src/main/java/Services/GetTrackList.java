package Services;
import io.restassured.response.Response;
import spec.RequestSpec;

import static io.restassured.RestAssured.given;

public class GetTrackList extends RequestSpec {
    public GetTrackList() {
        super("/v1/search");
    }

    public String getArtist(String artistName){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("q",artistName)
                        .queryParam("type","artist")
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        String artistId  = response.jsonPath().getString("artists.items.id[0]");
        return artistId;

    }




}
