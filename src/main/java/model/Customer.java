package model;

import java.sql.Date;
import java.sql.Timestamp;

//@Entity(name="customer")
//@Table(name="customer")
public class Customer{
	
	private int customer_id;
	private int store_id;
	private int address_id;
	//private Store store;
	private String first_name;
	private String last_name;
	private String email;
	//private Address address;
	private int active;
	private Date create_date;
	private Timestamp last_update;
	//@Id
	//@Column(name="customer_id",unique=true,nullable=false)
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	//@Column(name="store_id",nullable=false)
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	//@Column(name="address_id",nullable=false)
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
//	public Store getStore() {
//		return store;
//	}
//	public void setStore(Store store) {
//		this.store = store;
//	}
	//@Column(name="first_name",nullable=false)
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	//@Column(name="last_name",nullable=false)
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	//@Column(name="email",nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	//@Column(name="active")
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	//@Column(name="create_date",nullable=false)
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	//@Column(name="last_update",nullable=false)
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public Customer(){};
}