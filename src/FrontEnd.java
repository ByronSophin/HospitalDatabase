import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;

public class FrontEnd 
{
	 private static DatabaseConnector databaseconnector;
	 private static CreateTables createEntity;
	public static void main(String [] args)
	{
		Boolean quiting = false;
		Properties sql_prop = new Properties();
		
		 Connection connection = null;
	     String dbURL = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	     String dbUser = "G14";
	     String dbPassword = "G14Spring2023";
	
	     databaseconnector = new DatabaseConnector(dbURL, dbUser,dbPassword);
	     
	     databaseconnector.StartConnection();
	     connection = databaseconnector.getSQLCONN();
	     Scanner input = new Scanner(System.in);
	     
	     while(!quiting) {
	    	 System.out.println(GetMainMenu());
	    	 while(input.hasNext()) {
	    		 if (input.hasNextInt()) {
	    			 	switch(input.nextInt())
	    			 	{
	    			 	case 1:
	    			 		CreateEntityMenu(input);
	    			 		break;
	    			 	case 2:
	    			 		CreateProcedureMenu(input);
	    			 		break;
	    			 	case 3:
	    			 		CreatePrescriptionMenu(input);
	    			 		break;
	    			 	case 4:
	    			 		try {
								Output.printPatientData(connection);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    			 		break;
	    			 	case 5:
	    			 		
	    			 		break;
	    			 	case 6:
	    			 		break;
	    			 	case 7:
	    			 		quiting = true;
	    			 		break;
	    			 	default: 
	    			 		System.out.println("Invalid option");
	    			 		break;
	    			 	}
	    			 	break;
	    		 }
	    		 else {
	    			 input.next();
	    			 System.out.println("Enter a valid number");
	    		 }
	    	 }
	     }
	}
     
	public static void CreateEntityMenu(Scanner input)
	{
		boolean back = false;
		CreateTables tableCreator = new CreateTables(databaseconnector);
		while(!back)
		{
			System.out.println(GetEntityMenu());
			while(input.hasNext()) {
	   		 if (input.hasNextInt()) {
	   			 	switch(input.nextInt())
	   			 	{
	   			 	case 1:
	   			 		tableCreator.CreatePatient();
	   			 		break;
	   			 	case 2:
	   			 		tableCreator.CreateDepartment();
	   			 		break;
	   			 	case 3:
	   			 		tableCreator.CreateProcedure();
	   			 		break;
	   			 	case 4:
	   			 		tableCreator.CreateDoctor();
	   			 		break;
	   			 	case 5:
	   			 		tableCreator.CreateMedication();
	   			 		break;
	   			 	case 6:
	   			 		tableCreator.CreateInteractRecord();
	   			 		break;
	   			 	case 7:
	   			 		back = true;
	   			 		break;
	   			 	default: 
	   			 		System.out.println("Invalid option");
	   			 		break;
	   			 	}
	   			 	break;
	   		 }
	   		 else {
	   			 input.next();
	   			 System.out.println("Enter a valid number");
	   		 }
	   	 }
	    	
		}
	}
	
	public static void CreateProcedureMenu(Scanner input)
	{
		boolean back = false;
		CreateTables tableCreator = new CreateTables(databaseconnector);
		while(!back)
		{
			System.out.println("Create record of: \n"
					+ "1. Procedures Completed on Patient\n"
					+ "2. Back to menu");
			
			while(input.hasNext()) {
				
	   		 if (input.hasNextInt()) {
	   			 	switch(input.nextInt())
	   			 	{
	   			 	case 1:
	   			 		tableCreator.CreateUndergoes();
	   			 		break;
	   			 	case 2:
	   			 		back = true;
	   			 		break;
	   			 	default: 
	   			 		System.out.println("Invalid option");
	   			 		break;
	   			 	}
	   			 	break;
	   		 }
	   		 else {
	   			 input.next();
	   			 System.out.println("Enter a valid number");
	   		 }
	   	 }
	    	
		}
	}
	
	public static void CreatePrescriptionMenu(Scanner input)
	{
		boolean back = false;
		CreateTables tableCreator = new CreateTables(databaseconnector);
		while(!back)
		{
			System.out.println("Create record of: \n"
					+ "1. Medication Prescribed to Patient\n"
					+ "2. Back to menu");
			
			while(input.hasNext()) {
				
	   		 if (input.hasNextInt()) {
	   			 	switch(input.nextInt())
	   			 	{
	   			 	case 1:
	   			 		tableCreator.CreateIsPrescribed();
	   			 		break;
	   			 	case 2:
	   			 		back = true;
	   			 		break;
	   			 	default: 
	   			 		System.out.println("Invalid option");
	   			 		break;
	   			 	}
	   			 	break;
	   		 }
	   		 else {
	   			 input.next();
	   			 System.out.println("Enter a valid number");
	   		 }
	   	 }
	    	
		}
	}
	
	//test code
	public static String GetMainMenu()
	{
		return "Main menu \n" + 
			   "1. Add New Record For Patient, Department, Procedure, Doctor, Medication, or Interaction\n" + 
			   "2. Add Procedure Information To Patient Record\n"+
			   "3. Add Medication Prescribed to Patient\n"+ 
			   "4. Retrieve Patient Health Record\n "+ 
			   "5. Retrieve Department Procedures Offered\n"+ 
			   "6. List Procedures Performed by a Doctor\n" + 
			   "7. Quit";
	}
	public static String GetEntityMenu() {
		return "Create record of: \n" + 
	"1. Patient\n" + "2.Department\n" + 
	"3.Procedure\n"+"4. Doctor\n" + 
	"5. Medication\n"+ "6. Interation\n" + "7.Back";
	}

	public static String getString() {
        try {
            StringBuffer buffer = new StringBuffer();
            int c = System.in.read();
            while (c != '\n' && c != -1) {
                buffer.append((char) c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return null;
        }
    }

    public static int getInt()

    {    try {
        String s = getString();
        return Integer.parseInt(s);
    }
        catch(Exception e) {
            return -1;
        }
    }

    public static char getChar()

    {
        String s = getString();
        try {
        return s.charAt(0);
        }
        catch (Exception e) {
            return 0;
        }
    }

}
