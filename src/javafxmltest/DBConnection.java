/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;
import java.sql.*;
/**
 *
 * @author Ananya
 */
public class DBConnection {

 public Connection connect()
 {
     Connection conn=null;
     try{
         
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/applicationuser","root","");
         System.out.println("Connected");
         
     }
     catch(Exception exc){
     exc.printStackTrace();
     }
     
    return conn;
 }
}
