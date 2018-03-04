package dao;

import java.util.Date;

public class SearchParams {
	private boolean hasLocation = false;
	private boolean hasDates = false;
	private boolean hasGuests = false;
	
	
	private String location = "";
	private int guests = 0;
	private Date arrDate = null;
	private Date depDate = null;
	
	public void setDates(Date arrDate, Date depDate){
		this.arrDate = arrDate;
		this.depDate = depDate;
		this.hasDates = true;
	}
	
	public Date getArrDate(){
		return this.arrDate;
	}
	
	public Date getDepDate(){
		return this.depDate;
	}
	
	public boolean hasDates(){
		return this.hasDates;
	}
	
	public void setGuests(int guests){
		this.guests = guests;
		this.hasGuests = true;
	}
	
	public int getGuests(){
		return this.guests;
	}
	
	public boolean hasGuests(){
		return this.hasGuests;
	}
	
	public void setLocation(String location){
		this.location = location;
		this.hasLocation = true;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public boolean hasLocation(){
		return this.hasLocation;
	}
}
