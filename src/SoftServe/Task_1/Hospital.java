package SoftServe.Task_1;

import com.sun.org.apache.bcel.internal.generic.IREM;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ayasintc on 3/29/2016.
 */
public class Hospital {

    private String title;

    public Hospital(String titles) {
        this.title = titles;
    }

    private Set<Patient> patients = new HashSet<Patient>();

    //add new patient
    public void addPatient (Patient patient) {
        patients.add(patient);
    }

    //get by age
    public List<Patient> getByAge(int age) {
        List<Patient> pat = new ArrayList<Patient>(patients);
        Iterator<Patient> i = pat.iterator();
        while (i.hasNext()) {
            if(!(i.next().getAge()==(age)))i.remove();
        }
        return pat;
    }

    //get by name
    public List<Patient> getByName(String name) {
        List<Patient> pat = new ArrayList<Patient>(patients);
        Iterator<Patient> i = pat.iterator();
        while (i.hasNext()) {
            if(!(i.next().getName().equals(name))) i.remove();
        }
        return pat;
    }

    //sort by age

    public List<Patient> sortByAge() {
        List<Patient> pat = new ArrayList<Patient>(patients);
        Collections.sort(pat, new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        return pat;
    }

    //sort by lasName
    public List<Patient> sortByLastName() {
        List<Patient> pat = new ArrayList<Patient>(patients);
        Collections.sort(pat, new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return pat;
    }

   /* //get by AnalysisType stage 1
    public List<Patient> getByAnalysisType (final AnalysisType type) {
        List<Patient> pat = new ArrayList<Patient>(patients);
        return pat.stream().filter(item ->
               ! item.getList().stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList()).isEmpty())
                .collect(Collectors.toList());
    }*/


   /* //get by AnalysisType stage 2
    public List<Patient> getByAnalisisType(AnalysisType type){
        List<Patient> pat = new ArrayList<>();
        Iterator<Patient> i = patients.iterator();
        while(i.hasNext()) {
            Patient p=i.next();
            List<Analysis> analyzes = p.getList();
            Iterator<Analysis> b = analyzes.iterator();
            while(b.hasNext()) {
                if(b.next().getType().equals(type)) {
                    pat.add(p);
                    break;
                }
            }
        }
        return pat;
    }
*/
    //get by AnalysisType stage 3
    public List<Patient> getByAnalisisType(AnalysisType type){
        List<Patient> pat = new ArrayList<>();
        for (Patient p : patients){
            List<Analysis> a = p.getList();
            for (Analysis b: a) {
                if(b.getType().equals(type)) {
                    pat.add(p);
                }
            }
        }
        return pat;
    }


    //not done Analyzes
    public void notDoneAnalyzes (AnalysisType type) {
        boolean flag = false;
        for(Patient p : patients){
            List<Analysis> a = p.getList();
            for (Analysis b : a) {
                if(b.getType().)
            }
        }

        System.out.println();
    }

       /* while (i.hasNext()) {
            List<Analysis> a = new ArrayList<>(i.next().getList());
            for(Analysis anal:a) {
               if(!(anal.getType().equals(type))) i.remove();
            }
        }
        return pat;
    }*/




    //sort by




    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Patient value: patients) {
            builder.append(value);
        }
        String patient = builder.toString();

        return "patients" + title + "\n" +
                patient;
    }

}
