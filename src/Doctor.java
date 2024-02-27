
public class Doctor{
	private String First_name;
	private String Last_name;
	private String DocMinitial;
	private String Address;
	private String Contact_num;
	private String Phone_num;
	private String Birth_date;
	private String Doc_id;
	private String Doc_ssn;
	
	public Doctor(String First_name,String Last_name,String DocMinitial,
			String Address,String Contact_num,
			String Phone_num,String Birth_date,String Doc_id,String Doc_ssn)
	{
		this.setFirst_name(First_name);
		this.setLast_name(Last_name);
		this.setDocMinitial(DocMinitial);
		this.setAddress(Address);
		this.setContact_num(Contact_num);
		this.setPhone_num(Phone_num);
		this.setBirth_date(Birth_date);
		this.setDoc_id(Doc_id);
		this.setDoc_ssn(Doc_ssn);
	}
	public String addDoctordata()
	{
		String doctorData = getDoc_ssn() + getFirst_name() +getDocMinitial() + getLast_name()+ getDoc_id() +
				getAddress() + getContact_num() + getBirth_date()+ getPhone_num();
		return doctorData;
	}
	
	
	
	
	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public String getDocMinitial() {
		return DocMinitial;
	}

	public void setDocMinitial(String Docminitial) {
		DocMinitial = Docminitial;
	}

	public String getContact_num() {
		return Contact_num;
	}

	public void setContact_num(String contact_num) {
		Contact_num = contact_num;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone_num() {
		return Phone_num;
	}

	public void setPhone_num(String phone_num) {
		Phone_num = phone_num;
	}

	public String getBirth_date() {
		return Birth_date;
	}

	public void setBirth_date(String birth_date) {
		Birth_date = birth_date;
	}

	public String getDoc_id() {
		return Doc_id;
	}

	public void setDoc_id(String doc_id) {
		Doc_id = doc_id;
	}

	public String getDoc_ssn() {
		return Doc_ssn;
	}

	public void setDoc_ssn(String doc_ssn) {
		Doc_ssn = doc_ssn;
	}

}
