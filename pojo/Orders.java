package pojo;
import java.util.Date;

public class Orders {

	private int ID; 
    private int Shopper_ID;
    public Orders() {
		super();
	}
	private int Shipping_Address_ID; 
    Date Orders_Date;
    private int Bill;
    private String Status;
    
	public Orders(int iD, int shopper_ID, int shipping_Address_ID, Date orders_Date, int bill, String status) {
		super();
		ID = iD;
		Shopper_ID = shopper_ID;
		Shipping_Address_ID = shipping_Address_ID;
		Orders_Date = orders_Date;
		Bill = bill;
		Status = status;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getShopper_ID() {
		return Shopper_ID;
	}
	public void setShopper_ID(int shopper_ID) {
		Shopper_ID = shopper_ID;
	}
	public int getShipping_Address_ID() {
		return Shipping_Address_ID;
	}
	public void setShipping_Address_ID(int shipping_Address_ID) {
		Shipping_Address_ID = shipping_Address_ID;
	}
	public Date getOrders_Date() {
		return Orders_Date;
	}
	public void setOrders_Date(Date orders_Date) {
		Orders_Date = orders_Date;
	}
	public int getBill() {
		return Bill;
	}
	public void setBill(int bill) {
		Bill = bill;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return ID + ", " + Shopper_ID + ", " + Shipping_Address_ID + ", " + Orders_Date + ", " + Bill + ", " + Status;
	}
    
    
}
