public class Procedure
{
private String Proc_name;
private String Description;
private String Proc_number;
private String Offering_department;
private String Duration;

public Procedure(String Proc_name, String Description, String Proc_number,
		String Offering_department, String Duration)
{
	this.setProc_name(Proc_name);
	this.setDescription(Description);
	this.setProc_number(Proc_number);
	this.setOffering_department(Offering_department);
	this.setDuration(Duration);
}

public String addProcedureData()
{
	String ProcedureData = getProc_name() + getDescription() + getProc_number() + getOffering_department() + getDuration();
	return ProcedureData;
}

public String getProc_name() {
	return Proc_name;
}

public void setProc_name(String proc_name) {
	Proc_name = proc_name;
}

public String getDescription() {
	return Description;
}

public void setDescription(String description) {
	Description = description;
}

public String getProc_number() {
	return Proc_number;
}

public void setProc_number(String proc_number) {
	Proc_number = proc_number;
}

public String getOffering_department() {
	return Offering_department;
}

public void setOffering_department(String offering_department) {
	Offering_department = offering_department;
}

public String getDuration() {
	return Duration;
}

public void setDuration(String duration) {
	Duration = duration;
}
}
