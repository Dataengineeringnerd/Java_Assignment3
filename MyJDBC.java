//package homework3JDBC;
import java.sql.*;

public class MyJDBC {
	//Connect with mydb database
   static final String DB_URL = "jdbc:mysql://localhost/mydb";
   static final String USER = "root";
   static final String PASS = "Blogger#1";

   	public static void main(String[] args) {	
    
      	try {
      		// Open a connection
            Class.forName("com.mysql.cj.jdbc.Driver");//
    		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		Statement stmt = conn.createStatement();
    
    		//Create Employee Table
            stmt.executeUpdate("DROP TABLE IF EXISTS EMPLOYEE;"); 
            stmt.executeUpdate("CREATE TABLE EMPLOYEE  (ID INTEGER, NAME VARCHAR(32), BIRTHDATE DATE, SALARY FLOAT)");
            
    
    		//insert into Employee (ID, Name, BirthDate, Salary) 
    		stmt.executeUpdate ( "INSERT INTO EMPLOYEE " + "VALUES (100, 'Suresh', '1982-12-01', 1000.50)"); 
    		stmt.executeUpdate ( "INSERT INTO EMPLOYEE " + "VALUES (200, 'Ramesh', '1982-12-02', 2000.50)"); 
    		stmt.executeUpdate ( "INSERT INTO EMPLOYEE " + "VALUES (300, 'Prakash', '1982-12-03', 3000.50)"); 
    
            // Print the result into the terminal
    	    ResultSet rs =stmt.executeQuery("SELECT ID, NAME, BIRTHDATE, SALARY FROM EMPLOYEE"); 
    		System.out.println("################### Employee ####################");
    		System.out.println("ID\t\tNAME\t\tBIRTHDATE\t\tSALARY");
    		
            // Extract data from result set
             	while (rs.next()) {
                	// Retrieve by column name
             			int id = rs.getInt("ID");
             			String name = rs.getString("NAME");
             			String Birthdate = rs.getString("BIRTHDATE");
             			float salary = rs.getFloat("SALARY");
             			System.out.println(id + "\t\t" + name + "\t\t" + Birthdate + "\t\t"+ salary);  			
             	} 	
    		System.out.println("#################################################");
    
    		// Delete from Employee where ID=200 
    		// PreparedStatement p=null;
    		//p =conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID =200");
            stmt.execute("DELETE FROM EMPLOYEE WHERE ID =200");
            
    		// Print the result into the terminal
            ResultSet rs2 =stmt.executeQuery("SELECT ID, NAME, BIRTHDATE, SALARY FROM EMPLOYEE"); 
    		System.out.println("############### Employee Table After Deleting Entry Where ID=200################");
    			while (rs2.next()) {
            	// Retrieve by column name
         			int id = rs2.getInt("ID");
         			String name = rs2.getString("NAME");
         			String Birthdate = rs2.getString("BIRTHDATE");
         			float salary = rs2.getFloat("SALARY");
         			System.out.println(id + "\t\t" + name + "\t\t" + Birthdate + "\t\t"+ salary);  			
         	} 	
    		System.out.println("#################################################");
      	}  
      	
      	// Handle Exception wherever needed
      	catch (SQLException e) {
         	e.printStackTrace();
      		} 
      	catch(ClassNotFoundException cnfe) {
      		System.out.println("Class Not Found Exception: "+ cnfe.getMessage());
      		}
		// Handle Exception wherever needed
      		
   }
}