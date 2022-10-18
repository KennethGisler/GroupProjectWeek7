package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Player;
import model.Unit;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/new-list.jsp"; //sets up where you're going to go, and the unit helper
		UnitHelper uh = new UnitHelper(); 
		
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer day = Integer.parseInt(request.getParameter("day"));  //gets the date strings and parses them now.
		Integer year = Integer.parseInt(request.getParameter("year"));
		
		String listName = request.getParameter("listName"); //gets the other strings and allocates them
		String playerName = request.getParameter("playerName");
		String playerArmy = request.getParameter("army");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(year, month, day); //set up the local date variable
		}catch(NumberFormatException ex) {
			ld= LocalDate.now();
		}
		
		String[] selectedUnits = request.getParameterValues("allItemsToAdd"); //get's the selected units from the page
		List<Unit> unitsToAdd = new ArrayList<Unit>(); //set's up the unit list
		
		if(selectedUnits != null && selectedUnits.length != 0) { //sees if the list received is empty, and not null
			for(int i = 0; i < selectedUnits.length; i++) { //goes threw the list and finds the Units by their id and adds them
				System.out.println(selectedUnits[i]); //shows what id is being given
				Unit u = uh.searchForUnitById(Integer.parseInt(selectedUnits[i]));
				unitsToAdd.add(u);
			}
		}
		
		Player newPlayer = new Player(playerName,playerArmy); //creates a new player!
		ListDetails newList = new ListDetails(listName,ld,newPlayer); //creates the new ListDetails 
		newList.setRoster(unitsToAdd); //adds the roster!
		
		ListDetailsHelper ldh = new ListDetailsHelper(); //makes the helper to insert the new list!
		ldh.insertListDetails(newList);
		
		System.out.println("Success!"); //outputs if it works as well as the list's toString.
		System.out.println(newList.toString());
		
		getServletContext().getRequestDispatcher((path)).forward(request, response); //sends you back to the new-list.jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
