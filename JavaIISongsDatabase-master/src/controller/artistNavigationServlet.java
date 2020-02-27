package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListArtist;

/**
 * Servlet implementation class artistNavigationServlet
 */
@WebServlet("/artistNavigationServlet")
public class artistNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public artistNavigationServlet() {
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

		String act = request.getParameter("doThisToItem");
		// after all changes, we should redirect to the viewAllArtists servlet
		//	The only time we don't is if they select to add a new item or edit
		String path = "/viewAllArtistsServlet";
		boolean test = false;
				
		if(act.equals("delete")) {
			try {
				if(test) {System.out.println("start delete");}
				Integer tempArtistId = Integer.parseInt(request.getParameter("id"));
				ListArtist artistToDelete = dao.searchForArtistById(tempArtistId);
					dao.deleteArtist(artistToDelete);
					
		} catch(NumberFormatException e) {
			System.out.println("Forgot to select an artist");
		}
			
			
			}
		else if	(act.equals("edit")) {
			try {
				if(test) {System.out.println("start edit");}

			Integer tempID = Integer.parseInt(request.getParameter("id"));
			ListArtist artistToEdit = dao.searchForArtistById(tempID);
			request.setAttribute("artistToEdit", artistToEdit);
			path = "/edit-artist.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select a artist");
			}
			
			
		}
		

		getServletContext().getRequestDispatcher(path).forward(request, response);
		}
	}
