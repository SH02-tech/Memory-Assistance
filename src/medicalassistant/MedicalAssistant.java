/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalassistant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author eduardo
 */
public class MedicalAssistant {

    /**
     * @param args the command line arguments
     */
    
    public Connection get_connection(){
       Connection connection=null;
       String URL = "jdbc:mysql://db4free.net:3306/med_assistant";
       String USER = "hackforgood2022";
       String PASS = "12345678";
       try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               connection=DriverManager.getConnection(URL,USER,PASS);
       }catch (Exception e) {
               System.out.println(e);
       }
       return connection;
    }
    
    public void deletePrescription(Prescripcion pres) {
        Connection conn = get_connection();
        try(Statement stmt = conn.createStatement();) {
            String sql = "DELETE FROM medicines WHERE id = " + pres.getMedicamento().getId();
            stmt.executeUpdate(sql);
            sql = "DELETE FROM prescriptions WHERE id = " + pres.getId();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Prescripcion> listPrescriptions() {
        ArrayList<Prescripcion> ret = new ArrayList<Prescripcion>();
        Connection conn = get_connection();
        Medicamento med = new Medicamento();
        Prescripcion pres = new Prescripcion();
        try(Statement stmt = conn.createStatement();) {
            String sql = "SELECT id, med_id, start_time, frequency, dosage FROM prescriptions";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                try (Statement stmt1 = conn.createStatement();) {
                    String sql1 = "SELECT id, name, units, description FROM medicines WHERE id = " + rs.getInt("med_id");
                    ResultSet rs1 = stmt1.executeQuery(sql1);
                    if (rs1.next()) {
                        med = new Medicamento(rs1.getInt("id"), rs1.getString("name"),
                                rs1.getString("description"), rs1.getInt("units"));
                        
                        /*
                        System.out.print("Id: " + rs1.getInt("id"));
                        System.out.print("Name: " + rs1.getString("name"));
                        System.out.print("Units: " + rs1.getInt("units"));
                        System.out.println("Desc: " + rs1.getString("description"));
                        */
                    }                  
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                pres = new Prescripcion(rs.getInt("id"), med, rs.getString("start_time"),
                rs.getInt("frequency"), rs.getInt("dosage"));
                ret.add(pres);
                /*
                System.out.print("Id: " + rs.getInt("id"));
                System.out.print(", Med_id: " + rs.getInt("med_id"));
                System.out.print(", Hora inicio: " + rs.getString("start_time"));
                System.out.print(", Freq: " + rs.getInt("frequency"));
                System.out.println(", Dosis: " + rs.getInt("dosage"));
                */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    public void insertPrescription(Prescripcion presc) {
        Connection conn = get_connection();
        Medicamento med = presc.getMedicamento();
        try(Statement stmt = conn.createStatement();) {
            
            String sql = "INSERT INTO medicines (name, units, description) "
                    + "VALUES ('" + med.getNombre() + "','" + med.getUnidades() + "','" +
                    med.getDescripcion() + "')";
            //stmt.executeUpdate(sql);
            PreparedStatement ps=
                    conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            Integer id = -2;
            if(rs.next()){
                id=rs.getInt(1);
            }
            sql = "INSERT INTO prescriptions (med_id, start_time, frequency, dosage) " +
                    "VALUES ('" + id + "','" + presc.getHoraInicio() + "','" + 
                    presc.getFrecuencia() + "','" + presc.getDosis() + "')";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        MedicalAssistant medicalAssistant=new MedicalAssistant();
	Connection connection=null;
	connection=medicalAssistant.get_connection();
	System.out.println(connection);
        Medicamento med = new Medicamento(10, "test", "xd", 100);
        Prescripcion pres = new Prescripcion(2, med, "16:00", 3, 8);
        //medicalAssistant.insertPrescription(pres);
        medicalAssistant.deletePrescription(pres);
        ArrayList<Prescripcion> lista = medicalAssistant.listPrescriptions();
        for (int i = 0; i < lista.size(); ++i) {
            System.out.println(lista.get(i).toString());
        }
    }
    
}
