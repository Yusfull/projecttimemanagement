package org.project.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class AutoImport {

    public void doLoad() {
        String filePath;
        filePath = "U:/Work/CSV/testData.csv";//assigning file
        System.out.println(filePath.length());
        System.out.println(filePath.getBytes());
        DBase db = new DBase();
        Connection conn = db.connect("jdbc:mysql://localhost:3306/timedatadb", "root", "");
        System.out.println("connected!!");
        try {
            db.importData(conn, filePath); //error
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        AutoImport autoImport = new AutoImport();
        autoImport.doLoad();
    }
}

class DBase {
    public DBase() {
    }
    public Connection connect(String db_connect_str,
            String db_userid, String db_password) {
        Connection conn;
        try {
            Class.forName(
                    "com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection(db_connect_str,
                    db_userid, db_password);

        } catch (Exception e) {
            e.printStackTrace();
            conn = null;
        }
        return conn;
    }
    public void importData(Connection conn, String filename) {
        System.out.println("br.." + filename.length());
        Statement stmt;
        String query;
        String quryString;
        try {
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            System.out.println("about to read query!!");
            query = "LOAD DATA LOCAL INFILE '" + "U:/Work/CSV/testData.csv " 
                    + "'REPLACE INTO TABLE TIME_SPENT  FIELDS TERMINATED BY ';' "
                    + "(PERSON_TASK_ASSIGNMENT_ID, DATE_TIME_FROM, DATE_TIME_TO);";

            System.out.println("1 loaded!!");
            stmt.executeUpdate(query);
            System.out.println("loaded!!");
        } catch (Exception e) {
            e.printStackTrace();
            stmt = null;
        }
    }
};
