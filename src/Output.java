import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Output {

	public static void printPatientData(Connection conn) throws SQLException {
	    Statement stmt = conn.createStatement();

	    System.out.print("Enter Patient ID: ");
	    String patID = FrontEnd.getString();
	    

	    String sqlqu = "SELECT * FROM PATIENT WHERE Patient_id = '" + patID;
	    ResultSet rs = stmt.executeQuery(sqlqu);

	    if (rs.next()) {
	      System.out.println("Patient Information:");
	      System.out.println("====================");
	      System.out.println("ID: " + rs.getString("Patient_id"));
	      System.out.println("Name: " + rs.getString("Fname") + " " + rs.getString("Minit") + " " + rs.getString("Lname"));
	      System.out.println("Birthdate: " + rs.getDate("Birthdate"));
	      System.out.println("Sex: " + rs.getString("Sex"));
	      System.out.println("Current Address: " + rs.getString("Current_address"));
	      System.out.println("Permanent Address: " + rs.getString("Perm_city") + ", " + rs.getString("Perm_state") + " " + rs.getString("Perm_zip"));
	      System.out.println("Current Phone: " + rs.getString("Current_Phone"));
	      System.out.println("Permanent Phone: " + rs.getString("Perm_phone"));

	 
	      String depQuery = "SELECT Dep_name FROM DEPARTMENT WHERE Dep_code IN (SELECT Dep_code FROM UNDERGOES WHERE Patient_ssn = '" + rs.getString("Patient_ssn") + "')";
	      ResultSet depRs = stmt.executeQuery(depQuery);

	      System.out.print("Departments: ");
	      while (depRs.next()) {
	        System.out.print(depRs.getString("Dep_name") + ", ");
	      }
	      System.out.println();

	    
	      String procQuery = "SELECT * FROM PROCED WHERE Proc_number IN (SELECT Proced_number FROM UNDERGOES WHERE Patient_ssn = '" + rs.getString("Patient_ssn") + "')";
	      ResultSet procRs = stmt.executeQuery(procQuery);

	      System.out.println("Interactions :");
	      System.out.println("=============");
	      while (procRs.next()) {
	        System.out.println("Interaction_id: " + procRs.getString("Interaction_id"));
	        System.out.println("Date: " + procRs.getString("Interaction_date"));
	        System.out.println("Detail: " + procRs.getString("Description"));
	        System.out.println();
	      }
	      
	      procQuery = "SELECT * FROM PROCED WHERE Proc_number IN (SELECT Proced_number FROM UNDERGOES WHERE Patient_ssn = '" + rs.getString("Patient_ssn") + "')";
	      procRs = stmt.executeQuery(procQuery);

	      System.out.println("Medications Prescribed  :");
	      System.out.println("=============");
	      while (procRs.next()) {
	        System.out.println("Medication name: " + procRs.getString("Med_name"));
	        System.out.println("Date: " + procRs.getString("Interaction_date"));
	        System.out.println("Detail: " + procRs.getString("Description"));
	        System.out.println();
	      }
	      
	      
	      
	    } else {
	      System.out.println("Patient not found.");
	    }
	    
	  }
	
	
	
	
}
