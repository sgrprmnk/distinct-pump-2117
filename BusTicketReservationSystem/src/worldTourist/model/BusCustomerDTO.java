package worldTourist.model;

public class BusCustomerDTO {
	
private int busId;
private String busName;
private String broute;
private String btype;

private int conid;
private String conName;
private String cphone;
public BusCustomerDTO() {
	// TODO Auto-generated constructor stub
}
public BusCustomerDTO(int busId, String busName, String broute, String btype, int conid, String conName,
		String cphone) {
	super();
	this.busId = busId;
	this.busName = busName;
	this.broute = broute;
	this.btype = btype;
	this.conid = conid;
	this.conName = conName;
	this.cphone = cphone;
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
public String getBroute() {
	return broute;
}
public void setBroute(String broute) {
	this.broute = broute;
}
public String getBtype() {
	return btype;
}
public void setBtype(String btype) {
	this.btype = btype;
}
public int getConid() {
	return conid;
}
public void setConid(int conid) {
	this.conid = conid;
}
public String getConName() {
	return conName;
}
public void setConName(String conName) {
	this.conName = conName;
}
public String getCphone() {
	return cphone;
}
public void setCphone(String cphone) {
	this.cphone = cphone;
}
@Override
public String toString() {
	return "BusCustomerDTO [busId=" + busId + ", busName=" + busName + ", broute=" + broute + ", btype=" + btype
			+ ", conid=" + conid + ", conName=" + conName + ", cphone=" + cphone + "]";
}

}
