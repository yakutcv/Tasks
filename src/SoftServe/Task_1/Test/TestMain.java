package SoftServe.Task_1.Test;

/**
 * Created by ayasintc on 3/29/2016.
 */

import SoftServe.Task_1.Entity.Analysis;
import SoftServe.Task_1.Entity.Patient;
import SoftServe.Task_1.IO.Exceptions.SelfFormatException;
import SoftServe.Task_1.IO.SQL.AnalyzesDAO;
import SoftServe.Task_1.IO.SQL.PatientDAO;
import SoftServe.Task_1.IO.SQL.SQLConnector;
import SoftServe.Task_1.IO.SelfFormatIO;
import SoftServe.Task_1.Logic.Hospital;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.bind.JAXBException;
import java.io.IOException;

import static SoftServe.Task_1.Entity.AnalysisType.*;

public class TestMain {

    public static void main(String[] args) throws Exception {

        Patient first = Patient.newPatientBuilder()
                .setBirthDate("04/04/1987")
                .setName("Andrew")
                .setLastName("Yasinskiy")
                .setId(1)
                .setAnalysis(Analysis.newAnalysisBuilder()
                        .setId(1)
                        .setType(HORMONES)
                        .setDate("03/02/2015 14:50")
                        .setReport("I don't know what is is...")
                        .build())
                .setAnalysis(Analysis.newAnalysisBuilder()
                        .setId(2)
                        .setType(ALLERGY)
                        .setDate("03/02/2015 14:15")
                        .setReport("Good")
                        .build())
                .build();


        Patient second = Patient.newPatientBuilder()
                .setBirthDate("04/04/1954")
                .setName("Petia")
                .setLastName("Petrushkin")
                .setId(2)
                .setAnalysis(Analysis.newAnalysisBuilder()
                        .setId(1)
                        .setType(BLOOD)
                        .setDate("03/01/2014 14:15")
                        .setReport("Yeap")
                        .build())
                .setAnalysis(Analysis.newAnalysisBuilder()
                        .setId(2)
                        .setType(ALLERGY)
                        .setDate("03/01/2016 14:15")
                        .setReport("Mu-ha-ha")
                        .build())
                .build();


        Patient third = Patient.newPatientBuilder()
                .setBirthDate("04/04/1998")
                .setName("Jora")
                .setLastName("Jorkin")
                .setId(4)
                .setAnalysis(Analysis.newAnalysisBuilder()
                        .setId(1)
                        .setType(ALLERGY)
                        .setDate("02/01/2016 14:40")
                        .setReport("Good Analysis.Very good!")
                        .build())
                .setAnalysis(Analysis.newAnalysisBuilder()
                        .setId(2)
                        .setType(BLOOD)
                        .setDate("02/01/2016 14:44")
                        .setReport("Simple good")
                        .build())
                .build();

        Hospital hospital = new Hospital();
        hospital.addPatient(first);
        hospital.addPatient(second);
        hospital.addPatient(third);

        Analysis a = Analysis.newAnalysisBuilder()
                .setId(1)
                .setType(ALLERGY)
                .setDate("02/01/2016 14:40")
                .setReport("Good Analysis.Very good!")
                .build();
        System.out.println(a.getDateInString());



        //System.out.println(third.getBirthDateInString());

        /*JSONIO js = new JSONIO();
        js.writeHospital(hospital, "myJson");
        js.readHospital("myJson");
        js.readHospital("myJson");*//*


        //XMLIO xmlIO = new XMLIO();
        //xmlIO.writeHospital(hospital, "hospital.xml");

        //Hospital hospitalSecond =  xmlIO.readHospital("hospital.xml");
        //System.out.println(hospitalSecond.getByAnalisisType(BLOOD));*/

        //SelfFormatIO self = new SelfFormatIO();
        //self.writeHospital(hospital,"myTxt.txt");

        //Hospital hosp2 = self.readHospital("myTxt.txt");
        //System.out.println(hosp2);
        PatientDAO ptDAO = new PatientDAO();
        //ptDAO.removePatientTable();
        //ptDAO.removePatientTable();
        //ptDAO.createPatientTable();
        //ptDAO.addPatient(first);
        //ptDAO.addListPatients(hosp2.getPatients());
        Hospital hospital1 = new Hospital();
        //hospital1.setPatients(ptDAO.readAllPatients());
        //ptDAO.updatePatient(third);
        //ptDAO.createPatientTable();
        //ptDAO.createPatientTable();
        //ptDAO.addPatient(third);
        //ptDAO.removePatientByName("Andrew");

        AnalyzesDAO ADAO = new AnalyzesDAO();
        ADAO.createAnalyzesTable();

        //ADAO.deletePatientTable();





        //Hospital hospital14 = self.readHospital("myTxt.txt");
        //System.out.println(hospital14);


        //System.out.println(self.readHospital("myTxt.txt"));


















    }
}

