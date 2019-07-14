package com.keregann.com.auxiliarClases;
import java.sql.*;


public class AuxiliarUpdateDB {

        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "org.postgresql.Driver";
        static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Eysenk_DB";

        //  Database credentials
        static final String USER = "postgres";
        static final String PASS = "aria5100";

        public static void main(String... args){
            int idCount = 1;
            while(idCount <=57){
               String string = AuxiliarEysenckItemsImpl_ro_A.eysenckItemList_ro_A().get(idCount).getQuestion();
               int consideredValue = AuxiliarEysenckItemsImpl_ro_A.eysenckItemList_ro_A().get(idCount).getConsideredValue();
                auxiliarUpdateQuestionsInDB(string, consideredValue, idCount);
                idCount++;
                System.out.println("IdCount : " + idCount);
            }

        }

        public static void auxiliarUpdateQuestionsInDB(String string, int consideredValue, int idCount){
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
        System.out.println("Update records into the table...");
        stmt = conn.createStatement();

        String sql = "UPDATE eysenckItems_A " +
                "SET question = '"+ string + "', consideredValue = " + consideredValue + " WHERE id = " + idCount + "";
        stmt.executeUpdate(sql);

        System.out.println("Updated records into the table...");

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
}
