package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListArtist;

/**
 * Servlet implementation class editArtistServlet
 */
@WebServlet("/editArtistServlet")
public class editArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtistServlet() {
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
		ListArtistHelper dao = new ListArtistHelper();
		Integer tempId=Integer.parseInt(request.getParameter("id"));
		ListArtist artistToUpdate = dao.searchForArtistById(tempId);
		String artistEntered = request.getParameter("artistName");  
		//set fields to newly entered strings
		artistToUpdate.setArtistName(artistEntered);
		//update the entry with matching ID to match this object
		dao.updateArtist(artistToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllArtistsServlet").forward(request, response);
		
	}

}
