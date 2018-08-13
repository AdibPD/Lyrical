import java.util.List;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

public class RetrievingLyrics {
	
	private final String musixMatchAPIKey = "76e38a26a27c53a5ead37cbf49cadf3d";
	private MusixMatch musixMatch;
	
	public static void main(String[] args){
		new RetrievingLyrics();
	}
	
	public RetrievingLyrics(){
		musixMatch = new MusixMatch(musixMatchAPIKey);
		getLyrics("Don't stop the Party", "The Black Eyed Peas");
		getArtistTrack("Drake");
	}
	
	public void getLyrics(String songName, String artistName){
		try {
			Track track = musixMatch.getMatchingTrack(songName, artistName);
			TrackData data = track.getTrack();
			int trackID = data.getTrackId();
			Lyrics lyrics = musixMatch.getLyrics(trackID);
			//System.out.println(lyrics.getLyricsLang());
		} catch (MusixMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getArtistTrack(String artistName){
		try {
			List<Track> tracks = musixMatch.searchTracks("", "Drake", "", 10, 10, true);
			for(Track t: tracks){
				System.out.println(t.getTrack().getTrackName());
			}
		} catch (MusixMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
