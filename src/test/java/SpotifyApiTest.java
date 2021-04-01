import Services.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SpotifyApiTest {

    CreateUser createUser = new CreateUser();
    CreatePlaylist createPlaylist = new CreatePlaylist();
    PlayLists playLists = new PlayLists();
    Search search = new Search();

    @Test
    public void spotifyCreatePlayList(){
        String userId = createUser.getUserId();
        String playListId = createPlaylist.createPlayList(userId,"playListBody");
        Assert.assertNotNull(playListId);
    }

    @Test
    public void spotifyCheckPlayListSize(){
        String userId = createUser.getUserId();
        String playListId = createPlaylist.createPlayList(userId,"playListBody");
        Assert.assertNotNull(playListId);
        int playListCount = playLists.getPlaylistSize(playListId);
        Assert.assertEquals(0 , playListCount, "Yeni oluşturulan listenin içi dolu");
    }
    @Test
    public void spotifyAddPlayListTrack(){
        String userId = createUser.getUserId();
        String playListId = createPlaylist.createPlayList(userId,"playListBody");
        List<String> trackList = new ArrayList<>();
        trackList.add(search.findTrack("Peşimde"));
        trackList.add(search.findTrack("Beni Benimle Bırak"));
        trackList.add(search.findTrack("Dünyanın Sonuna Doğmuşum"));
        playLists.AddPlayListTrack(playListId, trackList);
        int playListCount = playLists.getPlaylistSize(playListId);
        Assert.assertTrue(playListCount == 3);
    }
    @Test
    public void spotifyDeletePlayListTrack(){
        String userId = createUser.getUserId();
        String playListId = createPlaylist.createPlayList(userId,"playListBody");
        List<String> trackList = new ArrayList<>();
        trackList.add(search.findTrack("Peşimde"));
        trackList.add(search.findTrack("Beni Benimle Bırak"));
        trackList.add(search.findTrack("Dünyanın Sonuna Doğmuşum"));
        playLists.AddPlayListTrack(playListId, trackList);
        playLists.deleteTrack(trackList.get(2),playListId);
    }

    GetTrackList getTrackList = new GetTrackList();
    String artistId;
    @Test
    public void spotifyGetArtist(){
        artistId =  getTrackList.getArtist("Tania Bowra");
        Assert.assertNotNull(artistId , "ilgili artist listede görüntülenemedi");
    }
    Artists artist = new Artists();
    @Test
    public void GetTopTracks(){
        artistId =  getTrackList.getArtist("Tania Bowra");
        List<String> popularityTopTrack = new ArrayList<>();
        popularityTopTrack.add(artist.getTopTracks(artistId).get(0));
        popularityTopTrack.add(artist.getTopTracks(artistId).get(1));
        popularityTopTrack.add(artist.getTopTracks(artistId).get(2));
        Assert.assertEquals(popularityTopTrack.size() ,3);
    }








}
