import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Patient{ 
	// Variable declaration 
	private String Patient_ssn;
	private String Fname;
	private String Minit;
	private String Lname;
	private String Patient_id;
	private String Current_address;
	private String Current_Phone;
	private String Perm_city;
	private String Perm_zip;
	private String Perm_state;
	private String Perm_Phone;
	private LocalDate Birthdate;
	private String Condition;
	private String Sex;
	
	private ArrayList<Medication> Has_Medication = new ArrayList<Medication>();
	
	//private ArrayList<InteractionRecord> Interactionrecords;
	
	
	public Patient(String Patient_ssn, String Fname, String Minit, String Lname, String Patient_id, String Current_address, 
			 String Current_Phone, String Perm_city, String Perm_zip, 
			 String Perm_state, String Perm_Phone, String Birthdate, String Condition, String Sex)

	{this.setFname(Fname);
	this.setFname(Lname);
	this.setMinitial(Minit);
	this.setState(Perm_state);
	this.setCity(Perm_city);
	this.setZip(Perm_zip);
	this.setPerm_Phone(Perm_Phone);
	this.setCurrent_Phone(Current_Phone);
	this.setCurrent_address(Current_address);

	DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("uuuu-MM-dd");
	this.Birthdate = LocalDate.parse(Birthdate, dateformat);
	this.setCondition(Condition);
	this.setSex(Sex);
	this.setPatient_ssn(Patient_ssn);
	this.setPatient_id(Patient_id);
		
	}
	public void AddMedication(Medication new_med) 
	{
		Has_Medication.add(new_med);
	}


	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getMinitial() {
		return Minit;
	}

	public void setMinitial(String minitial) {
		Minit = minitial;
	}

	public String getState() {
		return Perm_state;
	}

	public void setState(String state) {
		Perm_state = state;
	}

	public String getZip() {
		return Perm_zip;
	}

	public void setZip(String zip) {
		Perm_zip = zip;
	}

	public String getCity() {
		return Perm_city;
	}

	public void setCity(String city) {
		Perm_city = city;
	}

	public String getPerm_Phone() {
		return Perm_Phone;
	}

	public void setPerm_Phone(String perm_Phone) {
		Perm_Phone = perm_Phone;
	}

	public String getCurrent_Phone() {
		return Current_Phone;
	}

	public void setCurrent_Phone(String current_Phone) {
		Current_Phone = current_Phone;
	}

	public String getCurrent_address() {
		return Current_address;
	}

	public void setCurrent_address(String current_address) {
		Current_address = current_address;
	}

	public LocalDate getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		Birthdate = birthdate;
	}

	public String getCondition() {
		return Condition;
	}

	public void setCondition(String condition) {
		Condition = condition;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getPatient_ssn() {
		return Patient_ssn;
	}

	public void setPatient_ssn(String patient_ssn) {
		Patient_ssn = patient_ssn;
	}

	public String getPatient_id() {
		return Patient_id;
	}

	public void setPatient_id(String patient_id) {
		Patient_id = patient_id;
	}

}
