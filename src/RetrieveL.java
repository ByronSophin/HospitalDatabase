import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetrieveL {

	public static void ProcedOff5(DatabaseConnector connect) throws SQLException {
		Statement statement = connect.getSQLCONN().createStatement();
		System.out.print("Would you like to search by department name or code ");
		Scanner input = new Scanner(System.in);
		String pick = input.next();
		while (!pick.equalsIgnoreCase("name") && !pick.equalsIgnoreCase("code")) {
			System.out.print("Invalid choice. Please enter name or code: ");
			pick = input.next();
		}
		String search = null;
		String sql = null;
		if (pick.equalsIgnoreCase("name")) {
			System.out.print("Enter department name: ");
			search = FrontEnd.getString();
			sql = "SELECT DISTINCT p.Proc_number, p.Description " + "FROM DEPARTMENT d "
					+ "JOIN PROCED p ON d.Dep_code = p.Dcode " + "WHERE d.Dep_name = " + search;

		} else if (pick.equalsIgnoreCase("code")) {
			System.out.print("Enter department code: ");
			Scanner inputc = new Scanner(System.in);
			String v = inputc.next();
			
			sql = "SELECT Proc_name, Description " + "FROM PROCED " + "WHERE Dep_code = " + v;
		}
		
		ResultSet resultset = statement.executeQuery(sql);

		System.out.println(search + " offers the following procedures:\n");
		System.out.println(
				"Procedure Number | Procedure Name                     | Description                                     | Duration");
		while (resultset.next()) {
			String procNumber = resultset.getString("Proc_number");
			String procName = resultset.getString("Proc_name");
			String description = resultset.getString("Description");
			String duration = resultset.getString("Duration");
			String finalprint = String.format("%-17s| %-35s| %-48s| %-8s", procNumber, procName, description, duration);
			System.out.println(finalprint);
		}
	}

	public static void ProcDocId6(DatabaseConnector connect) throws SQLException {
		Statement statement = connect.getSQLCONN().createStatement();
		System.out.print("Doctor ID: ");
		Scanner input = new Scanner(System.in);
		String docId = input.next();

		String query = "SELECT Proc_name " + "FROM PROCED " + "JOIN INVOLVED_IN "
				+ "ON PROCED.Proc_number = INVOLVED_IN.Proc_number " + "WHERE INVOLVED_IN.Doc_id '" +  docId + "'";

		ResultSet resultset = statement.executeQuery(query);

		System.out.println("Procedures Done by Doctor with ID: " + docId + "\n");

		while (resultset.next()) {
			String procName = resultset.getString("Proc_name");
			System.out.println(procName);
		}

		System.out.println();

	}

}