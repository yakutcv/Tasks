package SoftServe.Task_1.Test;

/**
 * Created by ayasintc on 3/29/2016.
 */

import SoftServe.Task_1.Entity.Analysis;
import SoftServe.Task_1.Entity.Patient;
import SoftServe.Task_1.IO.SelfFormatIO;
import SoftServe.Task_1.Logic.Hospital;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static SoftServe.Task_1.Entity.AnalysisType.*;

public class TestMain {

    public static void main(String[] args) throws JAXBException, IOException, ClassNotFoundException {

        Patient first = Patient.newPatientBuilder()
                .setBirthDate("04/04/1987 14:00")
                .setName("Andrew")
                .setLastName("Yasinskiy")
                .setId(1)
                .setAnalysis(Analysis.newAnalysisBuilder()
                        .setId(1)
                        .setType(HORMONES)
                        .setDate("03/02/2015 14:10")
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
                .setBirthDate("04/04/1954 14:00")
                .setName("Petia")
                .setLastName("Petrushkin")
                .setId(2)
                .setAnalysis(Analysis.newAnalysisBuilder()
                        .setId(1)
                        .setType(BLOOD)
                        .setDate("03/01/2016 14:10")
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
                .setBirthDate("04/04/1998 14:00")
                .setName("Vasia")
                .setLastName("Pupkin")
                .setId(3)
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


        SelfFormatIO self = new SelfFormatIO();
        self.writeHospital(hospital,"myTxt.txt");



        System.out.println(self.readHospital("myTxt.txt"));









      /*  JSONIO js = new JSONIO();
        js.writeHospital(hospital, "myJson");
        js.readHospital("myJson");
        js.readHospital("myJson");*/


        //XMLIO xmlIO = new XMLIO();
        //xmlIO.writeHospital(hospital, "hospital.xml");

        //Hospital hospitalSecond =  xmlIO.readHospital("hospital.xml");
       //System.out.println(hospitalSecond.getByAnalisisType(BLOOD));













    }
}

