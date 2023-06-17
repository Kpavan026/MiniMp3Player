import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    static int c=0;

    public static void main(String[] args) {
    	

        Album album = new Album("Album1","Arun");

        album.addSong("Song1",4.5);
        album.addSong("Song2",3.5);
        album.addSong("Song3",5.0);
        albums.add(album);
        c++;

        album = new Album("Album2","Akhil");

        album.addSong("Song4",4.5);
        album.addSong("Song5",3.5);
        album.addSong("Song6",4.5);

        albums.add(album);
        c++;

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Song1",playList_1);
        albums.get(0).addToPlayList("Song2",playList_1);
        albums.get(0).addToPlayList("Song3",playList_1);
        albums.get(1).addToPlayList("Song4",playList_1);
        albums.get(1).addToPlayList("Song5",playList_1);
        albums.get(1).addToPlayList("Song6",playList_1);

        play(playList_1);

    }
   static void addalbum(String s1,String s2,int n) {
	   Album album = new Album(s1,s2);
	   for(int i=0;i<n;i++) {
		   System.out.println("Enter song name:");
		   Scanner sc = new Scanner(System.in);
		   String sn=sc.nextLine();
		   System.out.println("Enter Duration of song:");
		   double d=sc.nextDouble();
		   album.addSong(sn, d);
		  }
	   albums.add(album);
	   System.out.println("your album was added succesfully");
	   System.out.println("Start seleceting your options:");
	   
   }
    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    quit = true;
                    break;

                case 1:
                    if(forward!=true){
                        if(listIterator.hasNext()){
                            listIterator.next();
                            
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no song availble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                	System.out.println("Enter Album name:");
                	String s11=sc.nextLine();
                	System.out.println("Enter Artist name:");
                	String s22=sc.nextLine();
                	System.out.println("How many songs you want to insert in your album:");
                	int n=sc.nextInt();
                	addalbum(s11,s22,n);
                	break;
                case 6:
                	System.out.println("Available albums are:");
                	for(Album i:albums) {
                		System.out.println(i.name);
                	}
                	System.out.println("Enter Album name:");
                	int n1=0;
                	String s =sc.nextLine();
                	playList.clear();
                	LinkedList<Song> playlist = new LinkedList<>();
                	for(Album i:albums) {
                		n1++;
                		if(i.name.compareTo(s)==0) {
                			for(Song j:i.songs) {
                			albums.get(n1-1).addToPlayList(j.getTitle(),playlist);
                		}
                		break;}
                	}
                	if(n1>c) {
                		System.out.println("Sorry that Album is not available");
                	}
                	play(playlist);
                case 7:
                    printMenu();
                    break;
                case 8:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - to add new Album\n"+
                "6 - to play your selected Album\n"+
                "7 - print all available options\n"+
                "8 - delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}
