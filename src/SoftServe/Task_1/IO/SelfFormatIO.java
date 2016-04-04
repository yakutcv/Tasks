package SoftServe.Task_1.IO;

import SoftServe.Task_1.Entity.Analysis;
import SoftServe.Task_1.Entity.Patient;
import SoftServe.Task_1.IO.Exceptions.SelfFormatException;
import SoftServe.Task_1.Interfaces.IO;
import SoftServe.Task_1.Logic.Hospital;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static SoftServe.Task_1.IO.Exceptions.ExceptionList.*;
import static SoftServe.Task_1.IO.Validators.SelfFormatValidator.validPatient;

public class SelfFormatIO implements IO {

    private static DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");
    private static DateTimeFormatter format1 = DateTimeFormat.forPattern("dd/MM/yyyy");

    private static final String INPUT_PATTERN = "([A-Z]{1}[a-z]{1,})\\s([A-Z]{1}[a-z]{1,})\\s\\((.*)\\)\\:\\{(.*)\\}";

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

    private List<String> splitPatients (String string) throws SelfFormatException {
        List<String> temp = new ArrayList<>();
        try{
            Pattern p = Pattern.compile(INPUT_PATTERN);
            Matcher m = p.matcher(string);
            m.matches();
            temp.add(m.group(1));
            temp.add(m.group(2));
            temp.add(m.group(3));
            try{
                temp.add(m.group(4));
            }catch (Exception e) {

            }
            //System.out.println(m.group(4));
        }catch (Exception e) {
            throw new SelfFormatException(DEFAULT);
        }

        //m.group(4); //validate collection analyzes
        return temp;
    }


    @Override
    public Hospital readHospital(String file) throws JAXBException, FileNotFoundException, IOException, ClassNotFoundException, SelfFormatException {

        Hospital hospital = new Hospital();
        List<String> tmpList = new ArrayList<>();
        long id = 1;
        String st;
        try (BufferedReader br = new BufferedReader(new FileReader("src\\SoftServe\\Task_1\\data\\" + file))) {
            while ((st = br.readLine()) != null) {
                validPatient(splitPatients(st));
                tmpList.add(st);
            }
        } catch (IOException e) {
            System.err.println("Invalid format input file!" + e);
        }



        return hospital;
    }









    //method to convert output Hospital to correct String format
    private StringBuilder covertToString(Hospital value) {
        StringBuilder newHospital = new StringBuilder();
        String formate = "";
        Set<Patient> patients = value.getPatients();
        for (Patient p : patients) {
            newHospital.append(p.getName() + " " + p.getLastName() + " (" + p.getBirthDate().toString(format1) + "):{");
            for (Analysis analysis : p.getList()) {
                /*if (!(p.getList().get(p.getList().size() - 1).equals(analysis))) {}*/
                    newHospital.append(" " + analysis.getType() + " (" + analysis.getDate().toString(format) + ") " + analysis.getReport() + ",");
            }
            newHospital.append("}");
            newHospital.append("\n");
        }
        return newHospital;
    }

}


/*
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

        return hospital;*/
