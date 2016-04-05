package SoftServe.Task_1.IO.SQL;

import SoftServe.Task_1.Entity.Patient;

import java.sql.*;
import java.util.regex.Pattern;

/**
 * Created by ayasintc on 4/5/2016.
 */
public class PatientDAO {

    SQLConnector connector = new SQLConnector();
    private static Statement statement ;
    private static PreparedStatement preparedStatement;

    private String CREATE_PATIENT_TABLE = "CREATE TABLE Patients (id serial, Name text, Last_name text, Birth_date text)";
    private String DELETE_PATIENT_TABLE = "DROP TABLE Patients";
    private String CREATE_PATIENT = "INSERT INTO Patients (Name text, Last_name text, Birth_date text) VALUES (?, ?, ?)";


    public void createPatientTable() {
        try{
            connector.connect();
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(CREATE_PATIENT_TABLE);
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't create table Patient!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }finally {
            connector.close();
        }
    }

    public void removePatientTable() {
        try{
            connector.connect();
            statement = connector.getConnection().createStatement();
            statement.executeQuery(DELETE_PATIENT_TABLE);
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Table Patient don't found!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }finally {
            connector.close();
        }
    }

    public void addPatient(Patient patient){

        preparedStatement = connector.getConnection().prepareStatement(CREATE_PATIENT);

    }
}
