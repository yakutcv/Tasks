package SoftServe.Task_1.IO;

import SoftServe.Task_1.Entity.Analysis;
import SoftServe.Task_1.Entity.AnalysisType;
import SoftServe.Task_1.Entity.Patient;
import SoftServe.Task_1.Interfaces.IO;
import SoftServe.Task_1.Logic.Hospital;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.*;

public class SelfFormatIO implements IO {

    private static DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");

    @Override
    public void writeHospital(Hospital hospital, String file) throws IOException {
        FileWriter writer = new FileWriter("src\\SoftServe\\Task_1\\data\\" + file);
        try {

            writer.write(covertToString(hospital).toString());
            writer.flush();
            writer.close();
            System.out.println("Txt file created!");
        } catch (IOException e) {
            System.out.println("Failed to record file!" + e);
        }

    }


    @Override
    public Hospital readHospital(String file) throws JAXBException, FileNotFoundException, IOException, ClassNotFoundException {
        Hospital hospital = new Hospital();

        List<String> tmpList = new ArrayList<>();

        long id = 1;

        String st;
        try (BufferedReader br = new BufferedReader(new FileReader("src\\SoftServe\\Task_1\\data\\" + file))) {
            while ((st = br.readLine()) != null) {
                tmpList.add(st);
            }
        }catch (IOException e) {
            System.err.println("Invalid format input file!" + e);
        }

        for(String s : tmpList) {

            String tmpPatients [] = s.split("(\\):)");

            String tmpPatient [] = tmpPatients[0].split("(\\()");

            String tmpFullname [] = tmpPatient[0].split("\\s");

            String tmpAnalyzes []  = tmpPatients[1].replaceAll("\\{|,\\s\\}", "").split("\\,");

            Analysis analysis = new Analysis();

            List<Analysis> tmpListOfAnalizes = new ArrayList<>();

            for (int i = 0; i <tmpAnalyzes.length ; i++) {

                String tmp = tmpAnalyzes[i].replaceAll("^(\\s)", "");

                String tmpAnalizesFiels [] = tmp.split("(\\s\\()|(\\)\\s)");

                analysis = Analysis.newAnalysisBuilder()
                        .setId(i)
                        .setType(AnalysisType.valueOf(tmpAnalizesFiels[0]))
                        .setDate(tmpAnalizesFiels[1])
                        .setReport(tmpAnalizesFiels[2])
                        .build();

                tmpListOfAnalizes.add(analysis);
            }
           Patient newPatient = Patient.newPatientBuilder()
                   .setBirthDate(tmpPatient[1])
                   .setAnalyzes(tmpListOfAnalizes)
                   .setName(tmpFullname[0])
                   .setLastName(tmpFullname[1])
                   .setId(id)
                   .build();
            id++;
            hospital.addPatient(newPatient);
        }

        return hospital;
    }

    //method to convert output Hospital to correct String format
    private StringBuilder covertToString(Hospital value) {
        StringBuilder newHospital = new StringBuilder();
        String formate = "";
        Set<Patient> patients = value.getPatients();
        for (Patient p : patients) {
            newHospital.append(p.getName() + " " + p.getLastName() + " (" + p.getBirthDate().toString(format) + "):{");
            for (Analysis analysis : p.getList()) {
                /*if (!(p.getList().get(p.getList().size() - 1).equals(analysis))) {}*/
                    newHospital.append(analysis.getType() + " (" + analysis.getDate().toString(format) + ") " + analysis.getReport() + ", ");
            }
            newHospital.append("}");
            newHospital.append("\n");
        }
        return newHospital;
    }
}
