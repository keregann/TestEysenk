package com.keregann;

import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QuestionaireDao {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Eysenk_DB";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "aria5100";

    //method for inserting the questionaireObject in db
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
                    "VALUES ('" + questionaire.getSubject() + "', '" + questionaire.getResult() + "')";
            //" + questionaire.getId() + ", '
            stmt.executeUpdate(sql);

            String sq2 = "INSERT INTO questionaire_answers (answers) " +
                         "VALUES ( ARRAY " + Arrays.toString(QuestionaireService.answerValuesArray(questionaire)) + ")";

            stmt.executeUpdate(sq2);
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
    }//end method

    //method for extracting the questionaire object by subject name from DB
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

    }//end method

    //method for extracting eysenk questionaire items (romanian variant A) from DB
    public static Map<Integer, Item>  getEysenckQuiestionaireItems_A(){
        Map<Integer, Item> eysenckQuizItems = new HashMap<Integer, Item>();
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

            String sql = "SELECT * FROM eysenckItems_A ORDER BY id";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set

            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String question = rs.getString("question");
                int consideredValue = rs.getInt("consideredValue");

                eysenckQuizItems.put(id, new Item(id, question, consideredValue));
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
        return eysenckQuizItems;

    }//end method

}


