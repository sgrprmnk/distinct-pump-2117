package worldTourist.model;

public class Bus {
private int busId;
private String busName;
private String busRoute;
private String busType;
private int seats;
private String sourceTravel;
private String sourceDestination;

public Bus() {
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Bus [busId=" + busId + ", busName=" + busName + ", busRoute=" + busRoute + ", busType=" + busType
			+ ", seats=" + seats + ", sourceTravel=" + sourceTravel + ", sourceDestination=" + sourceDestination + "]";
}

public Bus(int busId, String busName, String busRoute, String busType, int seats, String sourceTravel,
		String sourceDestination) {
	super();
	this.busId = busId;
	this.busName = busName;
	this.busRoute = busRoute;
	this.busType = busType;
	this.seats = seats;
	this.sourceTravel = sourceTravel;
	this.sourceDestination = sourceDestination;
}

public int getBusId() {
	return busId;
}

public void setBusId(int busId) {
	this.busId = busId;
}

public String getBusName() {
	return busName;
}

public void setBusName(String busName) {
	this.busName = busName;
}

public String getBusRoute() {
	return busRoute;
}

public void setBusRoute(String busRoute) {
	this.busRoute = busRoute;
}

public String getBusType() {
	return busType;
}

public void setBusType(String busType) {
	this.busType = busType;
}

public int getSeats() {
	return seats;
}

public void setSeats(int seats) {
	this.seats = seats;
}

public String getSourceTravel() {
	return sourceTravel;
}

public void setSourceTravel(String sourceTravel) {
	this.sourceTravel = sourceTravel;
}

public String getSourceDestination() {
	return sourceDestination;
}

public void setSourceDestination(String sourceDestination) {
	this.sourceDestination = sourceDestination;
}


}
