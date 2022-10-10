package model;

import java.time.LocalDate;
import java.util.List;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 10, 2022
 */
public class ListDetails {
	
	private int id;
	private String listName; //we had this penned as "name", changing it to listName for a bit more specificity.
	private LocalDate dateAdded;
	private Player player;
	private List<Unit> roster;
	
	/**
	 * 
	 */
	//constructors
	public ListDetails() {
		super();
	}
	public ListDetails(int id, String name, LocalDate ld, Player player, List<Unit> ul) {  //defalut no arg followed by the three I think we will need. One has all, the next all but id, the last, all but id and list
		this.id = id;
		listName = name;
		dateAdded = ld;
		this.player = player;
		roster = ul;
	}
	public ListDetails(String name, LocalDate ld, Player player, List<Unit> ul) {
		listName = name;
		dateAdded = ld;
		this.player = player;
		roster = ul;
	}
	public ListDetails(String name, LocalDate ld, Player player) {
		listName = name;
		dateAdded = ld;
		this.player = player;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getListName() {
		return listName;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public Player getPlayer() {
		return player;
	}
	public List<Unit> getRoster() {
		return roster;
	}
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void setRoster(List<Unit> roster) {
		this.roster = roster;
	}
	
	//methods
	@Override
	public String toString() {
		return "[List Name: " + listName + ", Date Added: " + dateAdded + ", Player Info: " + player.toString() + ", Roster:" + roster;
	}
}
