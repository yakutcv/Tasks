package SoftServe.Task_1.IO.SQL;

import SoftServe.Task_1.Entity.Patient;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by ayasintc on 4/5/2016.
 */
public class PatientDAO {

    SQLConnector connector = new SQLConnector();
    private static Statement statement ;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;


    private String CREATE_PATIENT_TABLE = "CREATE TABLE Patients (id int NOT NULL, Name text, Last_name text, Birth_date text, PRIMARY KEY (id))";
    private String DELETE_PATIENT_TABLE = "DROP TABLE Patients";
    private String CREATE_PATIENT = "INSERT INTO Patients (Name, Last_name, Birth_date) VALUES (?, ?, ?)";

    public boolean createPatientTable() {
        try{
            connector.connect();
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(CREATE_PATIENT_TABLE);
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't create table Patient!");
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

    public boolean removePatientTable() {
        try{
            connector.connect();
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(DELETE_PATIENT_TABLE);
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Table Patient don't found!");
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

    public boolean addPatient(Patient patient){
        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(CREATE_PATIENT);
            preparedStatement.setString(1,patient.getName());
            preparedStatement.setString(2,patient.getLastName());
            preparedStatement.setString(3,patient.getBirthDateInString());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't add Patient into table!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean removePatientByName(String name) {
        String DELETE_PATIENT = "DELETE FROM Patients WHERE Name =?";
        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(DELETE_PATIENT);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Patient with name " + name + " was deleted!");
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't find name: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean addListPatients(Set<Patient> patients) {
        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(CREATE_PATIENT);
            for(Patient p : patients) {
                preparedStatement.setString(1, p.getName());
                preparedStatement.setString(2, p.getLastName());
                preparedStatement.setString(3, p.getBirthDateInString());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("List patient was add!");
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't add List Patients into table Patients");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean updatePatient (Patient patient){
        String UPDATE_PATIENT = "UPDATE Patients SET Name =?, Last_name=?, Birth_date=? WHERE id =?";
        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(UPDATE_PATIENT);
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3,patient.getBirthDateInString());
            preparedStatement.setLong(4, patient.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't update patient " + patient);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    public Patient readPatientByName(String name) {
        String READ_PATIENT_BY_NAME= "SELECT * FROM Patients WHERE Name =?";
        Patient patient = null;
        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(READ_PATIENT_BY_NAME);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                patient = Patient.newPatientBuilder()
                        .setId(resultSet.getInt(1))
                        .setName(resultSet.getString(2))
                        .setLastName(resultSet.getString(3))
                        .setBirthDate(resultSet.getString(4))
                        .build();
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't find patient with name: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return patient;
    }

    public Set<Patient> readAllPatients() {
        String READ_ALL_PATIENTS = "SELECT * FROM Patients";
        Set<Patient> patients = new HashSet<>();
        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(READ_ALL_PATIENTS);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                patients.add(new Patient().newPatientBuilder()
                        .setId(resultSet.getInt(1))
                        .setName(resultSet.getString(2))
                        .setLastName(resultSet.getString(3))
                        .setBirthDate(resultSet.getString(4))
                        .build());

            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't read patients from table Patietnts");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return patients;
    }
}
