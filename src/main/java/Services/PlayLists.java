package Services;
import helper.Helper;
import io.restassured.response.Response;
import org.json.JSONObject;
import spec.RequestSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PlayLists extends RequestSpec {

    public PlayLists() {
        super("/v1/playlists");
    }

    public int getPlaylistSize(String playlistId){
        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .get("/{playlist_id}",playlistId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        int trackListSize =  response.jsonPath().getList("tracks.items").size();
        //System.out.println("Listedeki şarkı sayısı : "+trackList.size());
        return trackListSize;
    }

    public void AddPlayListTrack(String playListId, List<String> uris ){
        for(String track : uris) {
            Response response = given()
                    .spec(super.getRequestSpecification())
                    .queryParam("uris", track)
                    .post("/{playlist_id}/tracks", playListId)
                    .then()
                    .statusCode(201)
                    .extract()
                    .response();
        }
    }
    public void deleteTrack(String trackUri, String playlistId){
        JSONObject deleteBody = Helper.readJsonFile("deleteBody");
        deleteBody.getJSONArray("tracks").getJSONObject(0).put("uri",trackUri);

        given()
                .spec(super.getRequestSpecification())
                .body(deleteBody.toString())
                .delete("/{playlist_id}/tracks",playlistId)
                .then();
    }
}
