/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1895268
 */
public class DataBase1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Connection con;
        Statement stm;
        
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "hr", "inf5180");
            
            
            String sql="select * from regions";
            System.out.println(sql);
            
            
            stm=con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            int id;
            String name;
            while(rs.next()){
                id =rs.getInt("region_id");
                name=rs.getString(2);
                System.out.println(id + " - " + name);
              
          }
            rs.close();
            stm.close();
            con.close();
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
