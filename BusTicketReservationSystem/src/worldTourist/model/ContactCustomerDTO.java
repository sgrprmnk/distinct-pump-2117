package worldTourist.model;

public class ContactCustomerDTO {
private int conid;
private String conname;

private int cid;
private String cusername;

public ContactCustomerDTO() {
	// TODO Auto-generated constructor stub
}

public ContactCustomerDTO(int conid, String conname, int cid, String cusername) {
	super();
	this.conid = conid;
	this.conname = conname;
	this.cid = cid;
	this.cusername = cusername;
}

public int getConid() {
	return conid;
}

public void setConid(int conid) {
	this.conid = conid;
}

public String getConname() {
	return conname;
}

public void setConname(String conname) {
	this.conname = conname;
}

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getCusername() {
	return cusername;
}

public void setCusername(String cusername) {
	this.cusername = cusername;
}

}
