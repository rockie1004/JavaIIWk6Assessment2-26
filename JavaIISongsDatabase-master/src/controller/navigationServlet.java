package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListSong;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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

		String act = request.getParameter("doThisToItem");
		// after all changes, we should redirect to the viewAllSongs servlet
		//	The only time we don't is if they select to add a new item or edit
		String path = "/viewAllSongsServlet";
		boolean test = true;
				
		if(act.equals("delete")) {
			try {
				if(test) {System.out.println("start delete");}
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListSong songToDelete = dao.searchForSongById(tempId);
					dao.deleteSong(songToDelete);
		} catch(NumberFormatException e) {
			System.out.println("Forgot to select a song");
		}
			
			}
		else if	(act.equals("edit")) {
			try {
				if(test) {System.out.println("start edit");}

			Integer tempID = Integer.parseInt(request.getParameter("id"));
			ListSong songToEdit = dao.searchForSongById(tempID);
			request.setAttribute("songToEdit", songToEdit);
			path = "/edit-song.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select a song");
			}
			
			
		}
		else if (act.equals("add")) {
			if(test) {System.out.println("start add");}
		path = "/index.html";
		}
		if(test) {System.out.println("path = " + path);}

		getServletContext().getRequestDispatcher(path).forward(request, response);
		}
	}
