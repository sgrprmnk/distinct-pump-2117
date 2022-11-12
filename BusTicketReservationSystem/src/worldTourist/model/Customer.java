package worldTourist.model;

public class Customer {

private int id;	
private String username;
private String password;
private String sourceOfTravel;
private String destinationOfTravel;

public Customer() {
	// TODO Auto-generated constructor stub
}

public Customer(int id, String username, String password, String sourceOfTravel, String destinationOfTravel) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.sourceOfTravel = sourceOfTravel;
	this.destinationOfTravel = destinationOfTravel;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getSourceOfTravel() {
	return sourceOfTravel;
}

public void setSourceOfTravel(String sourceOfTravel) {
	this.sourceOfTravel = sourceOfTravel;
}

public String getDestinationOfTravel() {
	return destinationOfTravel;
}

public void setDestinationOfTravel(String destinationOfTravel) {
	this.destinationOfTravel = destinationOfTravel;
}

@Override
public String toString() {
	return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", sourceOfTravel="
			+ sourceOfTravel + ", destinationOfTravel=" + destinationOfTravel + "]";
}




}
