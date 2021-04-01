package Services;

import io.restassured.response.Response;
import spec.RequestSpec;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Artists extends RequestSpec {
    public Artists() {
        super("/v1/artists");
    }


    public List<String> getTopTracks(String artistId){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("market","tr")
                        .get("/{id}/top-tracks",artistId)
                        .then()
                        .extract()
                        .response();

        List<String> trackListPopularty  = response.jsonPath().getList("tracks.popularity");
        return trackListPopularty;

    }
}
