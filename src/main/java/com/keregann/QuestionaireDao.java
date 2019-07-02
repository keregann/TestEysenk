package com.keregann;

import java.sql.*;

public class QuestionaireDao {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Eysenk_DB";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "aria5100";

    public static void insertQuestionaireRecord(Questionaire  questionaire){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO questionaires " +
                    "VALUES (" + questionaire.getId() + ", '" + questionaire.getSubject() + "', '" + questionaire.getResult() + "')";
//            String sql = "INSERT INTO questionaires " +
//                    "VALUES (1, 'Ana', 'null')";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main


    public static Questionaire findBySubject(String subject) {
        Questionaire questionaire = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM questionaires WHERE subject LIKE '" + subject + "'";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set

            if (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String subjectName = rs.getString("subject");
                String questionaireResult = rs.getString("result");

                questionaire = new Questionaire(subjectName, questionaireResult );
                questionaire.setId(id);
            }
            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return questionaire;

    }//end main

}

