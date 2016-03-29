package SoftServe.Task_1;

/**
 * Created by ayasintc on 3/29/2016.
 */
import org.joda.time.DateTime;
import static SoftServe.Task_1.AnalysisType.*;

public class TestMain {

    public static void main(String[] args) {

        Patient first = Patient.newPatientBuilder()
                .setBirthDate(new DateTime(1987, 6, 30, 10, 6))
                .setName("Andrew")
                .setLastName("Yasinskiy")
                .setAnalyzes(Analysis.newAnalysisBuilder()
                        .setType(BLOOD)
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
                .setName("petia")
                .setLastName("petkin")
                .setAnalyzes(Analysis.newAnalysisBuilder()
                        .setType(BLOOD)
                        .setDate(new DateTime(2014,3,28,15,00))
                        .setReport("Good Analyzes")
                        .build())
                .setAnalyzes(Analysis.newAnalysisBuilder()
                        .setType(ALLERGY)
                        .setDate(new DateTime(2013, 4, 28, 16, 00))
                        .setReport("Good")
                        .build())
                .build();

        Hospital hospital = new Hospital("Chernivtsi National Hospital # 1");
        hospital.addPatient(first);
        hospital.addPatient(second);
        System.out.println(hospital.getByName("petia"));













    }
}

