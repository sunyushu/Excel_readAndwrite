package model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name="om_cust_price_list_cust")
public class Om_cust_price_list {
	private int id;
	private String cust_name;
	private String type;
	private String PL_YH_ITEM;
	private Date effective_date_from;
    private Date effective_date_to;
    private String user_def1;
    private String user_def2;
    private String user_def3;
    private String user_def4;
    private String user_def5;
    private String user_def6;
    private String user_def7;
    private String user_def8;
    private String user_def9;
    private String user_def10;
    private String user_def11;
    private String user_def12;
    private String user_def13;
    private String user_def14;
    private String user_def15;
    private String user_def16;
    private String user_def17;
    private String user_def18;
    private String user_def19;
    private String user_def20;
    private String user_def21;
    private String user_def22;
    private String user_def23;
    private String user_def24;
    private String user_def25;
    private String user_def26;
    private String user_def27;
    private String user_def28;
    private String user_def29;
    private String user_def30;
    public Om_cust_price_list() {
	}
	public Om_cust_price_list(int id, String cust_name, String type, String pL_YH_ITEM, Timestamp effective_date_from,
			Timestamp effective_date_to, String user_def1, String user_def2, String user_def3, String user_def4,
			String user_def5, String user_def6, String user_def7, String user_def8, String user_def9, String user_def10,
			String user_def11, String user_def12, String user_def13, String user_def14, String user_def15,
			String user_def16, String user_def17, String user_def18, String user_def19, String user_def20,
			String user_def21, String user_def22, String user_def23, String user_def24, String user_def25,
			String user_def26, String user_def27, String user_def28, String user_def29, String user_def30) {
		super();
		this.id = id;
		this.cust_name = cust_name;
		this.type = type;
		PL_YH_ITEM = pL_YH_ITEM;
		this.effective_date_from = effective_date_from;
		this.effective_date_to = effective_date_to;
		this.user_def1 = user_def1;
		this.user_def2 = user_def2;
		this.user_def3 = user_def3;
		this.user_def4 = user_def4;
		this.user_def5 = user_def5;
		this.user_def6 = user_def6;
		this.user_def7 = user_def7;
		this.user_def8 = user_def8;
		this.user_def9 = user_def9;
		this.user_def10 = user_def10;
		this.user_def11 = user_def11;
		this.user_def12 = user_def12;
		this.user_def13 = user_def13;
		this.user_def14 = user_def14;
		this.user_def15 = user_def15;
		this.user_def16 = user_def16;
		this.user_def17 = user_def17;
		this.user_def18 = user_def18;
		this.user_def19 = user_def19;
		this.user_def20 = user_def20;
		this.user_def21 = user_def21;
		this.user_def22 = user_def22;
		this.user_def23 = user_def23;
		this.user_def24 = user_def24;
		this.user_def25 = user_def25;
		this.user_def26 = user_def26;
		this.user_def27 = user_def27;
		this.user_def28 = user_def28;
		this.user_def29 = user_def29;
		this.user_def30 = user_def30;
	}
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="cust_name")
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	
	@Column(name="TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="PL_YH_ITEM")
	public String getPL_YH_ITEM() {
		return PL_YH_ITEM;
	}
	public void setPL_YH_ITEM(String pL_YH_ITEM) {
		PL_YH_ITEM = pL_YH_ITEM;
	}
	
	@Column(name="effective_date_from",columnDefinition="Date")
	public Date getEffective_date_from() {
		return effective_date_from;
	}
	public void setEffective_date_from(Date date) {
		this.effective_date_from = date;
	}
	
	@Column(name="effective_date_to",columnDefinition="Date")
	public Date getEffective_date_to() {
		return effective_date_to;
	}
	public void setEffective_date_to(Date effective_date_to) {
		this.effective_date_to = effective_date_to;
	}
	
	@Column(name="user_def1")
	public String getUser_def1() {
		return user_def1;
	}
	public void setUser_def1(String user_def1) {
		this.user_def1 = user_def1;
	}
	
	@Column(name="user_def2")
	public String getUser_def2() {
		return user_def2;
	}
	public void setUser_def2(String user_def2) {
		this.user_def2 = user_def2;
	}
	
	@Column(name="user_def3")
	public String getUser_def3() {
		return user_def3;
	}
	public void setUser_def3(String user_def3) {
		this.user_def3 = user_def3;
	}
	
	@Column(name="user_def4")
	public String getUser_def4() {
		return user_def4;
	}
	public void setUser_def4(String user_def4) {
		this.user_def4 = user_def4;
	}
	
	@Column(name="user_def5")
	public String getUser_def5() {
		return user_def5;
	}
	public void setUser_def5(String user_def5) {
		this.user_def5 = user_def5;
	}
	
	@Column(name="user_def6")
	public String getUser_def6() {
		return user_def6;
	}
	public void setUser_def6(String user_def6) {
		this.user_def6 = user_def6;
	}
	
	@Column(name="user_def7")
	public String getUser_def7() {
		return user_def7;
	}
	public void setUser_def7(String user_def7) {
		this.user_def7 = user_def7;
	}
	
	@Column(name="user_def8")
	public String getUser_def8() {
		return user_def8;
	}
	public void setUser_def8(String user_def8) {
		this.user_def8 = user_def8;
	}
	
	@Column(name="user_def9")
	public String getUser_def9() {
		return user_def9;
	}
	public void setUser_def9(String user_def9) {
		this.user_def9 = user_def9;
	}
	
	@Column(name="user_def10")
	public String getUser_def10() {
		return user_def10;
	}
	public void setUser_def10(String user_def10) {
		this.user_def10 = user_def10;
	}
	
	@Column(name="user_def11")
	public String getUser_def11() {
		return user_def11;
	}
	public void setUser_def11(String user_def11) {
		this.user_def11 = user_def11;
	}
	
	@Column(name="user_def12")
	public String getUser_def12() {
		return user_def12;
	}
	public void setUser_def12(String user_def12) {
		this.user_def12 = user_def12;
	}
	
	@Column(name="user_def13")
	public String getUser_def13() {
		return user_def13;
	}
	public void setUser_def13(String user_def13) {
		this.user_def13 = user_def13;
	}
	
	@Column(name="user_def14")
	public String getUser_def14() {
		return user_def14;
	}
	public void setUser_def14(String user_def14) {
		this.user_def14 = user_def14;
	}
	
	@Column(name="user_def15")
	public String getUser_def15() {
		return user_def15;
	}
	public void setUser_def15(String user_def15) {
		this.user_def15 = user_def15;
	}
	
	@Column(name="user_def16")
	public String getUser_def16() {
		return user_def16;
	}
	public void setUser_def16(String user_def16) {
		this.user_def16 = user_def16;
	}
	
	@Column(name="user_def17")
	public String getUser_def17() {
		return user_def17;
	}
	public void setUser_def17(String user_def17) {
		this.user_def17 = user_def17;
	}
	
	@Column(name="user_def18")
	public String getUser_def18() {
		return user_def18;
	}
	public void setUser_def18(String user_def18) {
		this.user_def18 = user_def18;
	}
	
	@Column(name="user_def19")
	public String getUser_def19() {
		return user_def19;
	}
	public void setUser_def19(String user_def19) {
		this.user_def19 = user_def19;
	}
	
	@Column(name="user_def20")
	public String getUser_def20() {
		return user_def20;
	}
	public void setUser_def20(String user_def20) {
		this.user_def20 = user_def20;
	}
	
	@Column(name="user_def21")
	public String getUser_def21() {
		return user_def21;
	}
	public void setUser_def21(String user_def21) {
		this.user_def21 = user_def21;
	}
	
	@Column(name="user_def22")
	public String getUser_def22() {
		return user_def22;
	}
	public void setUser_def22(String user_def22) {
		this.user_def22 = user_def22;
	}
	
	@Column(name="user_def23")
	public String getUser_def23() {
		return user_def23;
	}
	public void setUser_def23(String user_def23) {
		this.user_def23 = user_def23;
	}
	
	@Column(name="user_def24")
	public String getUser_def24() {
		return user_def24;
	}
	public void setUser_def24(String user_def24) {
		this.user_def24 = user_def24;
	}
	
	@Column(name="user_def25")
	public String getUser_def25() {
		return user_def25;
	}
	public void setUser_def25(String user_def25) {
		this.user_def25 = user_def25;
	}
	
	@Column(name="user_def26")
	public String getUser_def26() {
		return user_def26;
	}
	public void setUser_def26(String user_def26) {
		this.user_def26 = user_def26;
	}
	
	@Column(name="user_def27")
	public String getUser_def27() {
		return user_def27;
	}
	public void setUser_def27(String user_def27) {
		this.user_def27 = user_def27;
	}
	
	@Column(name="user_def28")
	public String getUser_def28() {
		return user_def28;
	}
	public void setUser_def28(String user_def28) {
		this.user_def28 = user_def28;
	}
	
	@Column(name="user_def29")
	public String getUser_def29() {
		return user_def29;
	}
	public void setUser_def29(String user_def29) {
		this.user_def29 = user_def29;
	}
	
	@Column(name="user_def30")
	public String getUser_def30() {
		return user_def30;
	}
	public void setUser_def30(String user_def30) {
		this.user_def30 = user_def30;
	}
    
   
}
