/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalassistant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author eduardo
 */
public class MedicalAssistant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MedicalAssistant obj_DB_Connection=new MedicalAssistant();
	Connection connection=null;
	connection=obj_DB_Connection.get_connection();
	System.out.println(connection);
    }
    
     public Connection get_connection(){
	Connection connection=null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/med_assistant","hackforgood2022","12345678");
                /*Statement stmt = connection.createStatement();
                String sql = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 
                stmt.executeUpdate(sql);
*/
        }catch (Exception e) {
		System.out.println(e);
	}
	return connection;
     }
    
}
