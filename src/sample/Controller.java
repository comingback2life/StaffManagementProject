package sample;

import javafx.scene.control.Alert;

import java.sql.*;

public class Controller {

    public static boolean createTable() {
        DatabaseConnecter db = new DatabaseConnecter();
        String valueNotFound;
        try {
            Connection con = null;
            Statement statement = null;
            Class.forName("com.mysql.jdbc.Driver");
            //Connection Open
            System.out.println("Connecting to a database..");
            con = DriverManager.getConnection(db.myDatabase, db.username, db.password);
            statement = con.createStatement();
            String sqlStatement = "select * from Staff";
            ResultSet rs = statement.executeQuery(sqlStatement);
            int id = rs.getInt("StaffId");
            while (rs.next()) {
                System.out.println(id);
            }
            if (!rs.isBeforeFirst()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean insertValuestoTable(String lName,String fName,String MI,String address,String city,String state,int phoneNumber){
        //Insert
        DatabaseConnecter db = new DatabaseConnecter();
        try {
            Connection con = null;
            Statement statement = null;
            Class.forName("com.mysql.jdbc.Driver");
            //Connection Open
            System.out.println("Connecting to a database..");
            con = DriverManager.getConnection(db.myDatabase, db.username, db.password);
            statement = con.createStatement();
            String sqlStatement = "insert into Staff (StaffLName, StaffFName,StaffMI,StaffAddress,City,State,Telephone) VALUES(lName,fName,MI,address,city,state,phone)";
            ResultSet rs = statement.executeQuery(sqlStatement);
        }catch (SQLException se){
            Alert alert = new Alert("");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

