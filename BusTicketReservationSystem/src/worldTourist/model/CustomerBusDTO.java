package worldTourist.model;

public class CustomerBusDTO {

	private int cid;
	private String cusername;
	
	private String bsource;
	private String bdestination;
	private String busId;
	private int seats;
	
	public CustomerBusDTO() {
		// TODO Auto-generated constructor stub
	}

	public CustomerBusDTO(int cid, String cusername, String bsource, String bdestination, String busId, int seats) {
		super();
		this.cid = cid;
		this.cusername = cusername;
		this.bsource = bsource;
		this.bdestination = bdestination;
		this.busId = busId;
		this.seats = seats;
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

	public String getBsource() {
		return bsource;
	}

	public void setBsource(String bsource) {
		this.bsource = bsource;
	}

	public String getBdestination() {
		return bdestination;
	}

	public void setBdestination(String bdestination) {
		this.bdestination = bdestination;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
}
