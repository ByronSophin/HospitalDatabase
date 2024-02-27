import java.util.ArrayList;

public class Department {
	private String Dep_name;
	private String Office_phone;
	private String Office_number;
	private String Dep_code;
	private ArrayList<Procedure> Procedure_List;
	
public Department(String Dep_name, String Office_phone,String Office_number,String Dep_code)
{
	this.Dep_name = Dep_name;
	this.Office_phone =Office_phone;
	this.Office_number = Office_number;
	this.Dep_code = Dep_code;
	
}

public String addDepartment()
{
	String departmentInfo = getDep_name() + getOffice_phone() + getOffice_number()+ getDep_code();
	return departmentInfo;
}

public String getDep_name() {
	return Dep_name;
}

public void setDep_name(String dep_name) {
	Dep_name = dep_name;
}

public String getOffice_phone() {
	return Office_phone;
}

public void setOffice_phone(String office_phone) {
	Office_phone = office_phone;
}

public String getOffice_number() {
	return Office_number;
}

public void setOffice_number(String office_number) {
	Office_number = office_number;
}

public String getDep_code() {
	return Dep_code;
}

public void setDep_code(String dep_code) {
	Dep_code = dep_code;
}
}