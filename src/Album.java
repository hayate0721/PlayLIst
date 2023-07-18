import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        Song song = songs.findSong(title);
        if(song == null){
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){

        Song song = songs.findSong(trackNumber);
        if(song != null){
             playlist.add(song);
             return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song song = songs.findSong(title);
        if(song != null){
            playlist.add(song);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    public static class SongList{

        private ArrayList<Song> songs;

        public SongList(){
            songs = new ArrayList<>();
        }

        public boolean add(Song song){
            if(findSong(song.getTitle()) == null){
                songs.add(song);
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

        private Song findSong(int trackNumber){
            if(trackNumber >= 1 && trackNumber <= songs.size()){
                return songs.get(trackNumber - 1);
            }
            return null;
        }



    }
}
