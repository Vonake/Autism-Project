// import all sql imports

import java.sql.Connection; //to connect to database
import java.sql.DriverManager;
import java.sql.Statement; // to handle sql and send to server
import java.sql.ResultSet; // to handle results from server
import java.sql.SQLException; // to handle sql errors
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Database {

    //
    String JDBC_MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    String JDBC_MONGO_DRIVER = "com.mongo.jdbc.Driver";
    String JDBC_ORACLE_DRIVER = "com.oracle.jdbc.Driver";

    String USER = "root";
    String PASSWORD = "";
    String DB_URL = "jdbc:mysql://localhost/autismprog";
    String ssl_sql = "?autoReconnect=true&useSSL=false";
    //this is for windows
//    String path = "C://wamp/www/mutpics/";
    //this one is for unix.
    public static final String path = "/var/www/html/java/";

    public Database() {

    }

    //connection method
    public Connection Connect() {
        Connection con = null;
        /**
         * Database ni 50-50 . inaweza kuwa inaweza kosa. If hakuna connection,
         * or ikifail
         */
        try {
            /**
             * JDBC = Java DataBase Connection Ina specify the type of database
             * tunatumia. We are using mysql Iyo tu, If tunatumia oracle db, ama
             * mongo db
             */
            Class.forName(JDBC_MYSQL_DRIVER);//hii statement eg ni ya? tuko poa? yup
            /**
             * Driver manager inafanya connection tunaanza na db, then user,
             * then password
             */
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);// apa tuko sawa?yup
        } //Connection failed. Do this
        catch (Exception e) {
            System.err.println("Error : " + e);
            con = null;
        } //tuko sawa? yup
        return con;
    }

    //SQL method
    /**
     * This method takes sql string, execute it and return results
     *
     * @param sql
     * @return Return what you get from server
     */
    public ResultSet executeSelect(String sql) {

        //step 1: Get Connection
        Connection con = Connect();
        ResultSet rs = null;
        try {
            //step 2: Create Statement
            //bado ni 50 - 50 coz inategemea connection, okay? okay
            Statement statement = con.createStatement();
            //run command on server and save them in rs
            rs = statement.executeQuery(sql);

        } catch (Exception ex) {
            System.err.println(ex);
        }
        return rs;
    }

    /**
     * This method takes an sql string. and updates the database.
     *
     * @param sql
     * @return returns a boolean value. if true, update success else, update
     * failed
     */
    public boolean executeInsert(String sql) {
        boolean success = false;
        //step 1: Get Connection
        Connection con = Connect();
        try {
            //step 2: create statement
            Statement stmt = con.createStatement();
            //step 3 : execute sql again inserting is 50 - 5o, so we use try catch
            stmt.executeUpdate(sql);//hapa unaeza sema success = stmt.executeUpdate(sql);?? let us try tuone if itafanya
            success = true; //stmt.executeUpdate inarudisha int si boolean haiwezi du, tuko pamoja?ooh yea sawa
        } catch (Exception e) {
            //if it failed saving,
            System.out.println("Error : " + e);
            success = false;
        }

        return success;
    }
    
    /**
     * This method checks if there are results from the database. It returns true if the query has
     * results, and false if the query has no results.
     * @param sql
     * @return 
     */
    public boolean checkDuplicate(String sql){
       boolean result = false;
       ResultSet rs = executeSelect(sql);
        try {
            if (rs.next() == true) {
                result =true;
            }
        } catch (Exception ex) {
           System.out.println(ex);
           result = true;
        }
       return result;
    }

    public void populateTable(String sql, JTable table){
        //hii code sijawai elewa how it works. na copy paste from my machine.
         ResultSet rs = executeSelect(sql);
         table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public static void main(String[] args) {
        System.out.println("My Autistic DB");
//        Testing Connection
        Database d = new Database();
        
//        executeInsert itatumika kuadd suervisor,kuadd student,task,etc
//          test inserting supervisor - -hatujacall io method kwa supervisor ama? bado. naona tuko pamoja. changamka
        Connection c = d.Connect();
        boolean login = d.Login("user", "password");

        if (login == true) {
            System.out.println("Login successful!");
        } else {
            System.out.println("login failed!");
        }
        /**
         *
         * System.out.println("Connection : " + c); String sql = "SELECT
         * `Supervisor_ID`, `First_Name`, `Last_Name`, `Student_Relationship`,
         * `Email`, `UserName`, `Password` FROM `supervisor`;";
         *
         * ResultSet rs = d.executeSelect(sql); //Get items from query rs String
         * Supervisor_id = ""; String First_name = ""; String Email = "";
         *
         * //Number of items found int records = 0;
         *
         * //Results are 50-50. Incase kuna some error in sql or databse
         * imechange try { while (rs.next() == true) { records = records + 1;
         * Supervisor_id = rs.getString("Supervisor_ID"); First_name =
         * rs.getString("First_Name"); Email = rs.getString("Email"); } } catch
         * (SQLException ex) { System.out.println(ex); }
         *
         * System.out.println("Objects Fountd : " + records);
         *
         * System.out.println("Supervisor id : " + Supervisor_id);
         *
         * System.out.println("First Name :" + First_name);
         *
         * System.out.println("Email :" + Email); nimecomment ndiyo i test from
         * here
         */

    }

    public boolean Login(String Username, String Password) {
        boolean result = false;
//        step 1 : create your sql
        String sql = "SELECT `Supervisor_ID`, `First_Name`, `Last_Name`, `Email` FROM `supervisor` WHERE `UserName`='" + Username + "' AND `Password` ='" + Password + "';";

//           step 2 : Get results from the select method
        ResultSet rs = executeSelect(sql);

        //step 3 : check for data
//            if rs.next == true, get supervisor_id,Firstname,lastname,email
//        if rs.next == false, useramea and/password is wrong tuko pamoja?yup
        try {
            while (rs.next()) {
                result = true;
                //get the values but we dont need them now.
            }
        } catch (Exception e) {
            // if we have error, print it, result == false
            System.out.println(e);
        }

//           if (Username.equals("kevo") && Password.equals("vonake")) {
//            result = true;
//        } else {
//            result = false;
//        }
        //step four : return result
        return result;
    }

    boolean executeInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
