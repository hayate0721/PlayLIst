import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for(Song song: songs){
            if(song.getTitle().equals(title)){
                return song;
            }
        }return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        if(trackNumber > 0 && trackNumber <= playlist.size()){
             Song song = songs.get(trackNumber - 1);
             playlist.add(song);
             return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        if(findSong(title) != null){
            playlist.add(findSong(title));
            return true;
        }
        return false;
    }
}
