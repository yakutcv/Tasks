package SoftServe.Task_1.Test;

/**
 * Created by ayasintc on 3/29/2016.
 */

import SoftServe.Task_1.Entity.Analysis;
import SoftServe.Task_1.Entity.Patient;
import SoftServe.Task_1.IO.XMLIO;
import SoftServe.Task_1.Logic.Hospital;
import org.joda.time.DateTime;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static SoftServe.Task_1.Entity.AnalysisType.*;

public class TestMain {

    public static void main(String[] args) throws  JAXBException,IOException {

        Patient first = Patient.newPatientBuilder()
                .setBirthDate(new DateTime(1987, 6, 30, 10, 6))
                .setName("Andrew")
                .setLastName("Yasinskiy")
                .setAnalyzes(Analysis.newAnalysisBuilder()
                        .setType(HORMONES)
                        .setDate(new DateTime(2016, 3, 28, 15, 00))
                        .setReport("Good Analyzes")
                        .build())
                .setAnalyzes(Analysis.newAnalysisBuilder()
                        .setType(ALLERGY)
                        .setDate(new DateTime(2016, 4, 28, 15, 00))
                        .setReport("Good")
                        .build())
                .build();


        Patient second = Patient.newPatientBuilder()
                .setBirthDate(new DateTime(1984, 5, 30, 10, 6))
                .setName("Petia")
                .setLastName("Petrushkin")
                .setAnalyzes(Analysis.newAnalysisBuilder()
                        .setType(BLOOD)
                        .setDate(new DateTime(2014, 3, 28, 15, 00))
                        .setReport("Good Analysis")
                        .build())
                .setAnalyzes(Analysis.newAnalysisBuilder()
                        .setType(ALLERGY)
                        .setDate(new DateTime(2013, 4, 28, 16, 00))
                        .setReport("Good")
                        .build())
                .build();


        Patient third = Patient.newPatientBuilder()
                .setBirthDate(new DateTime(1989, 5, 30, 10, 6))
                .setName("Vasia")
                .setLastName("Pupkin")
                .setAnalyzes(Analysis.newAnalysisBuilder()
                        .setType(ALLERGY)
                        .setDate(new DateTime(2015, 3, 28, 17, 00))
                        .setReport("Good Analysis")
                        .build())
                .setAnalyzes(Analysis.newAnalysisBuilder()
                        .setType(BLOOD)
                        .setDate(new DateTime(2013, 4, 28, 16, 00))
                        .setReport("Good")
                        .build())
                .build();

        Hospital hospital = new Hospital();
        hospital.addPatient(first);
        hospital.addPatient(second);
        hospital.addPatient(third);

        XMLIO xmlIO = new XMLIO();
        xmlIO.writeHospital(hospital, "hospital.xml");










    }
}

