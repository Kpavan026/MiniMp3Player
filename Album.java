import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    public String name;
    private String artist;
    public ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){

    }

    public Song findSong(String title){

        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
         System.out.println(title + "successfully added to the list");
            return true;
        }
        else {
           System.out.println("Song with name "+ title+ " already exist in the list");
            return false;
        }
    }

    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for(Song checkedSong : this.songs){
            if (checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
       System.out.println(title + "there is no such song in album");
        return false;
    }
}
