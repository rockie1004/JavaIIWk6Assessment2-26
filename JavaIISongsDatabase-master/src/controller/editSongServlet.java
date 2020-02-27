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
 * Servlet implementation class editSongServlet
 */
@WebServlet("/editSongServlet")
public class editSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ListSongHelper dao = new ListSongHelper();
		String updatedTitle = request.getParameter("title"); 
		Integer tempId=Integer.parseInt(request.getParameter("id"));
		ListSong songToUpdate = dao.searchForSongById(tempId);

		ListArtistHelper arthelper = new ListArtistHelper();
		String artistEntered = request.getParameter("artist");  
		List<ListArtist> matchArtists = arthelper.searchForArtistByName(artistEntered);
		if(matchArtists.isEmpty()) {//if no match, add new artist to the database then get that entry from the database so we know the id.
			ListArtist selectedArtist= new ListArtist();
			selectedArtist.setArtistName(artistEntered);
			arthelper.insertArtist(selectedArtist);
			matchArtists = arthelper.searchForArtistByName(artistEntered);
		}
		ListArtist updatedArtist = matchArtists.get(0);
		songToUpdate.setTitle(updatedTitle);
		songToUpdate.setArtist(updatedArtist);
		
		dao.updateSong(songToUpdate);
		
		
		getServletContext().getRequestDispatcher("/viewAllSongsServlet").forward(request, response);
		
	}

}
