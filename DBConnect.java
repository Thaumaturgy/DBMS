package javaapplication1;
import java.sql.*;
import java.util.Scanner;
public class DBConnect {
       private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public DBConnect() {
 try {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://10.4.42.58:3306/Sy2016_17_2ndSem", "root", "root");
     st = con.createStatement();
 } catch (Exception ex) {
     System.out.println("Error: " + ex);
     
 }
    }    
    
    public void getData(String n) {
 try {
     String query = "select * from student where name='" + n + "'";
     rs = st.executeQuery(query);
     System.out.println("Records from Database");
     while (rs.next()) {
        String name = rs.getString("name");
        String add = rs.getString("address");
        String course = rs.getString("course");
        String gender = rs.getString("gender");
        String yrlvl = rs.getString("yrlvl");

        System.out.println("Your Name: "+ name);
        System.out.println("Your Address: "+ add);
        System.out.println("Your Course: "+ course);
        System.out.println("Your Gender: "+ gender);
        System.out.println("Your Year Level: "+ yrlvl);
     }
 } catch(Exception ex) {
     System.out.println(ex);
 }
    }
    
    public void insertData(String name, String address, String course, String gender, String yrlvl) {
 try {
     String query = "insert into student values('"+ name + "','" + address + "','" + course + "','" + gender + "','" + yrlvl + "')";
     st.executeUpdate(query);
     System.out.println("Records inserted");
 } catch(Exception ex) {
     System.out.println(ex);
 }
    }    
    
    
}


class Main {

  public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        Scanner in = new Scanner (System.in);
        String name, address, course, gender, yrlvl;
        
        
        
        System.out.print("Enter stud name: ");
        name = in.nextLine();
        System.out.print("Enter stud address: ");
        address = in.nextLine();
        System.out.print("Enter stud course: ");
        course = in.nextLine();
        System.out.print("Enter stud gender: ");
        gender = in.nextLine();
        System.out.print("Enter stud yrlvl: ");
        yrlvl = in.nextLine();
        connect.insertData(name, address, course, gender, yrlvl);
        
        connect.getData(name);
        
        
        
    }
    
}
