package test;

public class CustomerBean {
	private int customerId;
	private String customerName;
	private String dob;
	private String gender;
	private String address;
	private String phone;
	private String email;
	
	public CustomerBean(String customerName, String dob, String gender, String address, String phone, String email) {
		super();
		this.customerName = customerName;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		
	}

	public CustomerBean() {
		// TODO Auto-generated constructor stub
	}

	

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
