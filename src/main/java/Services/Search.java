package Services;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import spec.RequestSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Search extends RequestSpec {


    public Search() {
        super("/v1/search");
    }

    public String findTrack(String trackName){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("q",trackName)
                        .queryParam("type","track")
                        .queryParam("limit","1")
                        .get()
                        .then()
                        .extract()
                        .response();


        List<String> a  = ((RestAssuredResponseImpl) response).response().path("tracks.items.uri");
        return a.get(0);
    }
}
