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
            
            
            //String sql="select * from regions";
            String sql = "select count(employees.EMPLOYEE_ID), avg (EMPLOYEES.salary), jobs.JOB_TITLE from employees join jobs on jobs.JOB_ID = employees.JOB_ID group by jobs.JOB_TITLE ";
            System.out.println(sql);
            
            
            stm=con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            //int id;
            //String name;
          /*  String country_id;
            String country_name;
            String region_name;*/
            
            int e_id;
            int salary;
            String job_tittle;
                   
            
            
            while(rs.next()){
                /*id =rs.getInt("region_id");
                name=rs.getString(2);
                System.out.println(id + " - " + name);*/
                /*
                country_id =rs.getString("country_id");
                country_name = rs.getString("country_name");
                region_name = rs.getString("region_name");
                System.out.println(country_id + " - " + country_name + " - " + region_name);*/
                
                
                e_id = rs.getInt(2);
                salary= rs.getInt(2);
                job_tittle = rs.getString("job_title");
                System.out.println(e_id + " - " + salary + " - " + job_tittle);
                
              
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
