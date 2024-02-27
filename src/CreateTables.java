import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateTables {
	
	DatabaseConnector databaseconnector;
	
	public CreateTables(DatabaseConnector db)
	{
		this.databaseconnector = db;
	}
	
	public void CreatePatient() {
        try {
        	Scanner input = new Scanner(System.in);
        	String Patient_ssn;
    		String Fname;
    		String Minit;
    		String Lname;
    		String Patient_id;
    		String Current_address;
    		String Current_Phone;
    		String Perm_city;
    		String Perm_zip;
    		String Perm_state;
    		String Perm_Phone;
    		String Birthdate;
    		String Condition;
    		String Sex;
    		String primDoc;
    		String secDoc;
    		
    		System.out.print("Enter Patient SSN (AAA-GG-SSSS): ");
    		Patient_ssn = input.nextLine();
    		System.out.print("Enter First Name: ");
    		Fname = input.nextLine();
    		System.out.print("Enter Middle Inital: ");
    		Minit= input.nextLine();
    		System.out.print("Enter Last Name: ");
    		Lname= input.nextLine();
    		System.out.print("Enter Patient ID (P--------): ");
    		Patient_id= input.nextLine();
    		System.out.print("Enter Current Address: ");
    		Current_address= input.nextLine();
    		System.out.print("Enter Current Phone: ");
    		Current_Phone= input.nextLine();
    		System.out.print("Enter City of Permanent Address: ");
    		Perm_city= input.nextLine();
    		System.out.print("Enter Zipcode of Permanent Address: ");
    		Perm_zip= input.nextLine();
    		System.out.print("Enter State of Permanent Address: ");
    		Perm_state= input.nextLine();
    		System.out.print("Enter Permanent Phone: ");
    		Perm_Phone= input.nextLine();
    		System.out.print("Enter Birthdate (YYYY-MM-DD): ");
    	    Birthdate = input.nextLine();
    		System.out.print("Enter Patient Condition: ");
    		Condition= input.nextLine();
    		System.out.print("Enter Patient Sex: ");
    		Sex= input.nextLine();
    		System.out.print("Enter Primary Care Doctor ID(D--------): ");
    		primDoc = input.nextLine();
    		System.out.print("Enter Secondary Care Doctor ID(D--------): ");
    		secDoc = input.nextLine();
    		
        	
            PreparedStatement new_patient = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO PATIENT (Patient_ssn, Fname, Minit, Lname, Patient_id, Current_address," +
                            " Current_Phone, Perm_city, Perm_zip, Perm_state," +
                            " Perm_phone, Birthdate, Condition, Sex) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            new_patient.setString(1, Patient_ssn);
            new_patient.setString(2, Fname);
            new_patient.setString(3, Minit);
            new_patient.setString(4, Lname);
            new_patient.setString(5, Patient_id);
            new_patient.setString(6, Current_address);
            new_patient.setString(7, Current_Phone);
            new_patient.setString(8, Perm_city);
            new_patient.setString(9, Perm_zip);
            new_patient.setObject(10, Perm_state);
            new_patient.setString(11, Perm_Phone);
            new_patient.setString(12, Birthdate);
            new_patient.setString(13, Condition);
            new_patient.setString(14, Sex);

            int updatedrows = new_patient.executeUpdate();
            System.out.println(updatedrows + " Patient record inserted\n");
            
            PreparedStatement new_primdoc = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO PRIMARY_CARE_BY (Patient_ssn, Doc_id) " +
                            "VALUES (?, ?)");
            new_primdoc.setString(1, Patient_ssn);
            new_primdoc.setString(2, primDoc);
            updatedrows = new_primdoc.executeUpdate();
            System.out.println(updatedrows + " Primary Doctor record inserted\n");
            
            PreparedStatement new_secdoc = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO SECONDARY_CARE_BY (Patient_ssn, Doc_id) " +
                            "VALUES (?, ?)");
            new_secdoc.setString(1, Patient_ssn);
            new_secdoc.setString(2, secDoc);
            updatedrows = new_secdoc.executeUpdate();
            System.out.println(updatedrows + " Secondary Doctor record inserted\n");
            
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		}
	public void CreateDoctor() {
        try {
        	Scanner input = new Scanner(System.in);
        	
        	String Doc_ssn;
        	String Fname;
        	String Minit;
        	String Lname;
        	String Doc_id;
        	String Address;
        	String Contact_num;
        	String Birth_date;
        	String Phone_num;
        	String D_code;
        	
        	System.out.print("Enter Doctor SSN (AAA-GG-SSSS): ");
    		Doc_ssn= input.nextLine();
    		System.out.print("Enter First Name: ");
    		Fname = input.nextLine();
    		System.out.print("Enter Middle Inital: ");
    		Minit= input.nextLine();
    		System.out.print("Enter Last Name: ");
    		Lname= input.nextLine();
    		System.out.print("Enter Doctor ID (D--------): ");
    		Doc_id= input.nextLine();
    		System.out.print("Enter Address: ");
    		Address= input.nextLine();
    		System.out.print("Enter Contact Number: ");
    		Contact_num = input.nextLine();
    		System.out.print("Enter Birthdate (YYYY-MM-DD): ");
    		Birth_date = input.nextLine();
    		System.out.print("Enter Phone Number: ");
    		Phone_num = input.nextLine();
        	
            PreparedStatement new_doctor = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO DOCTOR (Doc_ssn, Fname, Minit, Lname, "
                    + "Doc_id, Address, Contact_num, Birth_date, Phone_num) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            new_doctor.setString(1, Doc_ssn);
            new_doctor.setString(2, Fname);
            new_doctor.setString(3, Minit);
            new_doctor.setString(4, Lname);
            new_doctor.setString(5, Doc_id);
            new_doctor.setString(6, Address);
            new_doctor.setString(7, Contact_num);
            new_doctor.setString(8, Birth_date);
            new_doctor.setString(9, Phone_num);
            
            int updatedrows = new_doctor.executeUpdate();
            System.out.println(updatedrows + " Doctor record inserted\n");
		
            System.out.println("Does doctor currently work for a department(Y/N): ");
            String answer = input.nextLine();
            if(answer.equalsIgnoreCase("Y"))
            {
            	System.out.print("Enter Department Code: ");
        		D_code = input.nextLine();
        		
        		PreparedStatement new_worksfor = databaseconnector.getSQLCONN().prepareStatement(
                        "INSERT INTO PRESCRIBED_BY (Doc_id, D_code) " +
                                "VALUES (?, ?)");
        		new_worksfor.setString(1, Doc_id);
        		new_worksfor.setString(2, D_code);

                updatedrows = new_worksfor.executeUpdate();
                System.out.println(updatedrows + " Works For record inserted\n");
            }
            
        }
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
	}
	public void CreateDepartment() {
        try {
        	
        	Scanner input = new Scanner(System.in);
        	
        	String Dep_name;
        	String Office_phone;
        	String Dep_code;
        	String Office_number;
        	String Head_doc_id;
        	
    		System.out.print("Enter Department Name: ");
    		Dep_name = input.nextLine();
    		System.out.print("Enter Office Phone Number: ");
    		Office_phone = input.nextLine();
    		System.out.print("Enter Department Code: ");
    		Dep_code = input.nextLine();
    		System.out.print("Enter Office Number: ");
    		Office_number = input.nextLine();
    		System.out.print("Enter Head of Department ID (D--------): ");
    		Head_doc_id = input.nextLine();
        	
            PreparedStatement new_dep = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO DEPARTMENT (Dep_name, Office_phone, Dep_code, Office_number, "
                    + "Head_doc_id) " +
                            "VALUES (?, ?, ?, ?, ?)");
            new_dep.setString(1, Dep_name);
            new_dep.setString(2, Office_phone);
            new_dep.setString(3, Dep_code);
            new_dep.setString(4, Office_number);
            new_dep.setString(5, Head_doc_id);
           

            int updatedrows = new_dep.executeUpdate();
            System.out.println(updatedrows + " Department record inserted\n");
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
	}
	public void CreateProcedure() {
        try {
        	Scanner input = new Scanner(System.in);
        	
        	String Proc_name;
        	String Description;
        	String Proc_number;
        	String Duration;
        	String Dcode;
        	
        	System.out.print("Enter Procedure Name: ");
    		Proc_name= input.nextLine();
    		System.out.print("Enter Description: ");
    		Description = input.nextLine();
    		System.out.print("Enter Procedure Number (ABC1234): ");
    		Proc_number = input.nextLine();
    		System.out.print("Enter Duration: ");
    		Duration = input.nextLine();
    		System.out.print("Enter Department Code Offering Procedure: ");
    		Dcode= input.nextLine();
        	
            PreparedStatement new_proc = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO PROCED (Proc_name, Description, Proc_number, Duration, "
                    + "Dcode) " +
                            "VALUES (?, ?, ?, ?, ?)");
            new_proc.setString(1, Proc_name);
            new_proc.setString(2, Description);
            new_proc.setString(3, Proc_number);
            new_proc.setString(4, Duration);
            new_proc.setString(5, Dcode);

            int updatedrows = new_proc.executeUpdate();
            System.out.println(updatedrows + " Procedure record inserted\n");
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
	}
	public void CreateMedication() {
        try {
        	Scanner input = new Scanner(System.in);
        	
        	String Med_name;
        	String Manufacturer;
        	String Description;
        	String Duration;
        	String Dcode;
        	
        	System.out.print("Enter Medication Name: ");
        	Med_name= input.nextLine();
    		System.out.print("Enter Manufacturer: ");
    		Manufacturer = input.nextLine();
    		System.out.print("Enter Description: ");
    		Description = input.nextLine();
        	
            PreparedStatement new_med = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO MEDICATION (Med_name, Manufacturer, Description) " +
                            "VALUES (?, ?, ?)");
            new_med.setString(1, Med_name);
            new_med.setString(2, Manufacturer);
            new_med.setString(3, Description);

            int updatedrows = new_med.executeUpdate();
            System.out.println(updatedrows + " Medication record inserted\n");
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
	}
	
	public void CreateInteractRecord() {
        try {
        	Scanner input = new Scanner(System.in);
        	
        	String P_ssn;
        	String Interaction_id;
        	String Description;
        	String Interaction_time;
        	
        	System.out.print("Enter Patient SSN (AAA-GG-SSSS): ");
    		P_ssn= input.nextLine();
    		System.out.print("Enter Interaction ID: ");
    		Interaction_id = input.nextLine();
    		System.out.print("Enter Description: ");
    		Description = input.nextLine();
    		System.out.print("Enter Date of Interaction (YYYY-MM-DD): ");
    		Date Interaction_date = Date.valueOf(input.nextLine());
    		System.out.print("Enter Time of Interaction: ");
    		Interaction_time= input.nextLine();
    		
            PreparedStatement new_interact = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO INTERACTION_RECORD (P_ssn, Interaction_id, Description, Interaction_date, "
                    + "Interaction_time) " +
                            "VALUES (?, ?, ?, ?, ?)");
            new_interact.setString(1, P_ssn);
            new_interact.setString(2, Interaction_id);
            new_interact.setString(3, Description);
            new_interact.setDate(4, Interaction_date);
            new_interact.setString(5, Interaction_time);

            int updatedrows = new_interact.executeUpdate();
            System.out.println(updatedrows + " Interaction record inserted\n");
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
	}
	
	public void CreateIsPrescribed() {
        try {
        	Scanner input = new Scanner(System.in);
        	
        	String Pat_ssn;
        	String Medi_name;
        	String Time_prescribed;
        	String Doc_id;
        	
        	
        	System.out.print("Enter Patient SSN (AAA-GG-SSSS): ");
    		Pat_ssn= input.nextLine();
    		System.out.print("Enter Medication Prescribed to Patient: ");
    		Medi_name = input.nextLine();
    		System.out.print("Enter Time of Prescription: ");
    		Time_prescribed = input.nextLine();
    		System.out.print("Enter Date of Prescription (YYYY-MM-DD): ");
    		Date Date_prescribed = Date.valueOf(input.nextLine());
    		System.out.print("Enter Prescribed By Doctor ID (D--------): ");
    		Doc_id = input.nextLine();
    		
            PreparedStatement new_prescribed = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO IS_PRESCRIBED (Pat_ssn, Medi_name, Time_prescribed, Date_prescribed) " +
                            "VALUES (?, ?, ?, ?)");
            new_prescribed.setString(1, Pat_ssn);
            new_prescribed.setString(2, Medi_name);
            new_prescribed.setString(3, Time_prescribed);
            new_prescribed.setDate(4, Date_prescribed);

            int updatedrows = new_prescribed.executeUpdate();
            System.out.println(updatedrows + " Is Prescribed record inserted\n");
            
            PreparedStatement new_prescribedby = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO PRESCRIBED_BY (Med_name, Doc_id) " +
                            "VALUES (?, ?)");
            new_prescribedby.setString(1, Medi_name);
            new_prescribedby.setString(2, Doc_id);

            updatedrows = new_prescribedby.executeUpdate();
            System.out.println(updatedrows + " Prescribed By record inserted\n");
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
	}
	
	public void CreateUndergoes() {
        try {
        	Scanner input = new Scanner(System.in);
        	
        	String Patient_ssn;
        	String Proced_number;
        	String Time_proc;
        	String Notes;
        	String Doc_id;
        	
        	System.out.print("Enter Patient SSN (AAA-GG-SSSS): ");
        	Patient_ssn= input.nextLine();
    		System.out.print("Enter Procedure Number: ");
    		Proced_number = input.nextLine();
    		System.out.print("Enter Time of Procedure: ");
    		Time_proc = input.nextLine();
    		System.out.print("Enter Date of Precedure (YYYY-MM-DD): ");
    		Date Date_proc = Date.valueOf(input.nextLine());
    		System.out.print("Enter Notes: ");
    		Notes= input.nextLine();
        	
            PreparedStatement new_undergoes = databaseconnector.getSQLCONN().prepareStatement(
                    "INSERT INTO UNDERGOES (Patient_ssn, Proced_number, Time_proc, Date_proc, "
                    + "Notes) " +
                            "VALUES (?, ?, ?, ?, ?)");
            new_undergoes.setString(1, Patient_ssn);
            new_undergoes.setString(2, Proced_number);
            new_undergoes.setString(3, Time_proc);
            new_undergoes.setDate(4, Date_proc);
            new_undergoes.setString(5, Notes);

            int updatedrows = new_undergoes.executeUpdate();
            System.out.println(updatedrows + " Procedure undergone record inserted\n");
		
            System.out.print("Enter List of Doctors ID (D--------) Involved in Procedure(seperate by comma): ");
    		String temp = input.nextLine();
    		String[] list = temp.split(",");
    		
        	updatedrows = 0;
    		for(int i = 0; i < list.length; ++i)
    		{
    			PreparedStatement new_involved = databaseconnector.getSQLCONN().prepareStatement(
	                    "INSERT INTO INVOLVED_IN (Doc_id, Proc_number) " +
	                            "VALUES (?, ?)");
    			Doc_id = list[i].trim();
	            new_involved.setString(1, Doc_id);
	            new_involved.setString(2, Proced_number);
	    		updatedrows = updatedrows + new_involved.executeUpdate();
    		}
            System.out.println(updatedrows + " Doctor involved in record inserted\n");
    		
        
        }
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
	}
	
	

}
