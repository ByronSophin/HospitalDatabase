import java.sql.Date;

public class Medication{
	private String Med_name;
	private String Manufacturer;
	private String medDescription;
	
	private Doctor persecibed_by;
	
	Date PrescribedDateTime;
	
	
	
	//SELECT Medication name, Manufacture, med_description, Doctor_ID,DoctorName FROM MEDICATIONS INNER JOIN 
	private String presecribed_by_id;
	
	private String presecription_doctor_name;
	
	
	public Medication(String Med_name, String Manufacturer, String medDescription) 
	{	this.setMed_name(Med_name);
		this.setManufacturer(Manufacturer);
		this.setmedDescription(medDescription);
	}
	
	
	

	public String getMed_name() {
		return Med_name;
	}

	public void setMed_name(String med_name) {
		Med_name = med_name;
	}

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}

	public String getmedDescription() {
		return medDescription;
	}

	public void setmedDescription(String description) {
		medDescription = description;
	}

}
