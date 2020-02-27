
import java.util.List;

import controller.ListArtistHelper;
import controller.ListSongHelper;
import model.ListArtist;
import model.ListSong;

public class Tester { 
  public static void main(String[] args) {   
	  ListArtistHelper arthelper = new ListArtistHelper();
	  ListSongHelper songhelper = new ListSongHelper();
	  ListArtist temp = new ListArtist("tempArtist");
	  arthelper.insertArtist(temp);
	 List<ListArtist> tempList =  arthelper.searchForArtistByName(temp.getArtistName());
	 System.out.println("Artist: " + tempList.get(0));
	 
	 ListSong tempSong = new ListSong(temp, "tempSong");

	 songhelper.insertSong(tempSong);
	 List<ListSong> tempListSong =  songhelper.searchForSongByTitle(tempSong.getTitle());
	 System.out.println("Song by Title:" +tempListSong.get(0));

	/*List<ListSong> tempListSongArtist =  songhelper.searchForSongByArtist("tempArtist");
	 System.out.println("Song by Artist:" + tempListSongArtist.get(0));
*/
	 
	 System.out.println("deleting");

	 arthelper.deleteArtist(temp);
	 System.out.println("deleting done");

	 tempList =  arthelper.searchForArtistByName(temp.getArtistName());
	 System.out.println("tempList.isEmpty() "+tempList.isEmpty());
	 tempListSong =  songhelper.searchForSongByTitle(tempSong.getTitle());
	 System.out.println("tempListSong.isEmpty()"+tempListSong.isEmpty());
	// tempListSongArtist =  songhelper.searchForSongByArtist(temp.getArtistName());
	// System.out.println("tempListSongArtist.isEmpty()"+tempListSongArtist.isEmpty());

  }}
