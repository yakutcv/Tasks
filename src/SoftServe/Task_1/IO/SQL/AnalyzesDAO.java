package SoftServe.Task_1.IO.SQL;

import SoftServe.Task_1.Entity.Analysis;
import SoftServe.Task_1.Entity.Patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

/**
 * Created by ayasintc on 4/5/2016.
 */
public class AnalyzesDAO {
    SQLConnector connector = new SQLConnector();
    private static Statement statement ;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private String TABLE_NAME = "Analyzes";
    private String CREATE_ANALYZES_TABLE = "CREATE TABLE " + TABLE_NAME + " (id int NOT NULL AUTO_INCREMENT, Analysis_type text, Date text, Report text, Patient_id int, PRIMARY KEY (id), foreign key (Patient_id) REFERENCES patients(id));";
    private String DELETE_ANALYZES_TABLE = "DROP TABLE " + TABLE_NAME;
    private String CREATE_ANALYZES = "INSERT INTO " +  TABLE_NAME +" (Analysis_type, Date, Report, Patient_id) VALUES (?, ?, ?, ?)";
    private String UPDATE_ANALYZES = "UPDATE "+ TABLE_NAME+ " SET Analysis_type=?, Date=?, Report=? WHERE id = ?";
    private String DELETE_ANALYSIS_BY_ID = "DELETE FROM "+ TABLE_NAME + " WHERE id =?";

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

    public boolean deleteAnalysisTable() {
        try{
            connector.connect();
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(DELETE_ANALYZES_TABLE);
            System.out.println("Table Analyzes delete!");
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

    public boolean addAnalysis(Analysis analysis, Patient patient){
        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(CREATE_ANALYZES);
            preparedStatement.setString(1,analysis.getType().toString());
            preparedStatement.setString(2,analysis.getDateInString());
            preparedStatement.setString(3,analysis.getReport());
            preparedStatement.setLong(4, patient.getId());
            preparedStatement.executeUpdate();
            System.out.println("Analysis " + analysis + "has been added into table " + TABLE_NAME);
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't add " + analysis +" into table " + TABLE_NAME);
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

    public boolean updateAnalysis (Analysis analysis){
        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(UPDATE_ANALYZES);
            preparedStatement.setString(1,analysis.getType().toString());
            preparedStatement.setString(2,analysis.getDateInString());
            preparedStatement.setString(3,analysis.getReport());
            preparedStatement.setLong(4, analysis.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't update analysis " + analysis);
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

    public boolean deleteAnalysisById(int id) {

        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(DELETE_ANALYSIS_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
            System.out.println("Analysis with id " + id + " was deleted!");
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't find analysis with : " + id);
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

    public boolean addListAnalysis(List<Analysis> analysisList, Patient patient) {
        try{
            connector.connect();
            preparedStatement = connector.getConnection().prepareStatement(CREATE_ANALYZES);
            for(Analysis a : analysisList) {
                preparedStatement.setString(1, a.getType().toString());
                preparedStatement.setString(2, a.getDateInString());
                preparedStatement.setString(3, a.getReport());
                preparedStatement.setLong(4, patient.getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("List Analyzes was add to patient " + patient);
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't add List Analyzes to " + patient);
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









}
