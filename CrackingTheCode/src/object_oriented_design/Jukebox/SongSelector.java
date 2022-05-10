package object_oriented_design.Jukebox;

public class SongSelector {
	
	private Song currentSong;
	
	public SongSelector(Song s) { 
		currentSong=s; 
		}
	
	public void setSong(Song s) { 
		currentSong = s;	
		}
	public Song getCurrentSong() { 
		return currentSong;	
		}

}
