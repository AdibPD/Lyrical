import java.util.List;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

public class RetrievingLyrics {
	
	private final String musixMatchAPIKey = "76e38a26a27c53a5ead37cbf49cadf3d";
	
	public static void main(String[] args){
		new RetrievingLyrics();
	}
	
	public RetrievingLyrics(){
		getLyrics("Don't stop the Party", "The Black Eyed Peas");
	}
	
	public void getLyrics(String songName, String artistName){
		MusixMatch musixMatch = new MusixMatch(musixMatchAPIKey);
		try {
			Track track = musixMatch.getMatchingTrack(songName, artistName);
			TrackData data = track.getTrack();
			int trackID = data.getTrackId();
			Lyrics lyrics = musixMatch.getLyrics(trackID);
			//System.out.println(lyrics.getLyricsLang());
			List<Track> tracks = musixMatch.searchTracks("I'm the fuckin' man, you don't get it do ya?", "Drake", "", 10, 10, false);
			for(Track t: tracks){
				System.out.println(t.getTrack().getTrackName());
			}
		} catch (MusixMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
