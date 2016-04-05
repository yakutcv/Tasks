package SoftServe.Task_1.IO.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ayasintc on 4/5/2016.
 */
public class AnalyzesDAO {
    SQLConnector connector = new SQLConnector();
    private static Statement statement ;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private String TABLE_NAME = "Analyzes";
    private String CREATE_ANALYZES_TABLE = "CREATE TABLE " + TABLE_NAME + " (id int NOT NULL, Analysis_type text, Date text, Report text, Patient_id int, PRIMARY KEY (id), foreign key (Patient_id) REFERENCES patients(id));";
    private String CREATE_ANALYZES_TABLE2 = "CREATE TABLE " + TABLE_NAME + " (id serial, Analysis_type text, Date text, Report text)";
    private String DELETE_ANALYZES_TABLE = "DROP TABLE " + TABLE_NAME;
    private String CREATE_ANALYZES = "INSERT INTO " +  TABLE_NAME +" (Analysis_type, Date, Report, Patient_id) VALUES (?, ?, ?, ?)";


    public boolean createAnalyzesTable() {
        try{
            connector.connect();
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(CREATE_ANALYZES_TABLE);
            System.out.println("Analyzes table was created!");
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't create table Analyzes!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }finally {
            try {
                statement.close();
                connector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

  /*  public boolean updateTable() {
        try{
            connector.connect();
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(ALTER_ANALYZES_TABLE);
            System.out.println("Analyzes table was changed!");
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't change table Analyzes!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }finally {
            try {
                statement.close();
                connector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
*/

    public boolean deletePatientTable() {
        try{
            connector.connect();
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(DELETE_ANALYZES_TABLE);
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Table Analyzes don't found!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }finally {
            try {
                statement.close();
                connector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }





}
