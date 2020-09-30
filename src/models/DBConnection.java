package models;

import java.sql.*;

/**
 *
 * @author Carlos Sánchez
 */
public class DBConnection {
   static String bd = "libros";
   static String login = "root";
   static String password = "1234";
   static String url = "jdbc:mysql://localhost/"+bd;
   
   Connection conn = null;
   
   public DBConnection() {
      try{
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
            System.out.println("All in "+bd+" is OK");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      } catch(Exception e){
         System.out.println(e);
      }
   }
   
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
   
}
