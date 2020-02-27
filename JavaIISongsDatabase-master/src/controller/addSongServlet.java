package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListArtist;
import model.ListSong;

/**
 * Servlet implementation class addSongServlet
 */
@WebServlet("/addSongServlet")
public class addSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addSongServlet() {
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title"); 
		
		//artist
		String artistEntered = request.getParameter("artist");  
		System.out.println("title"+ title +" artistEntered "+artistEntered);
		ListArtistHelper arthelper = new ListArtistHelper();
		List<ListArtist> matchArtists = arthelper.searchForArtistByName(artistEntered);
		if(matchArtists.isEmpty()) {//if no match, add new artist to the database then get that entry from the database so we know the id.
			ListArtist selectedArtist= new ListArtist();
			selectedArtist.setArtistName(artistEntered);
			arthelper.insertArtist(selectedArtist);
			matchArtists = arthelper.searchForArtistByName(artistEntered);
		}
		ListArtist updatedArtist = matchArtists.get(0);
		//
		ListSong li = new ListSong(updatedArtist, title);
		ListSongHelper dao = new ListSongHelper();
		dao.insertSong(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	
	}

}
