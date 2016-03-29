package SoftServe.Task_1;

import java.util.*;

/**
 * Created by ayasintc on 3/29/2016.
 */
public class Hospital {

    private String title;

    public Hospital(String titles) {
        this.title = titles;
    }

    private Set<Patient> hospital = new HashSet<Patient>();

    //add new patient
    public void addPatient (Patient patient) {
        hospital.add(patient);
    }


    //get by age
    public List<Patient> getByAge(int age) {
        List<Patient> pat = new ArrayList<Patient>(hospital);
        Iterator<Patient> i = pat.iterator();
        while (i.hasNext()) {
            if(!(i.next().getAge()==(age)))i.remove();
        }
        return pat;
    }

    //get by name
    public List<Patient> getByName(String name) {
        List<Patient> pat = new ArrayList<Patient>(hospital);
        Iterator<Patient> i = pat.iterator();
        while (i.hasNext()) {
            if(!(i.next().getName().equals(name))) i.remove();
        }
        return pat;
    }

    //sort by age

    public List<Patient> sortByAge() {
        List<Patient> pat = new ArrayList<Patient>(hospital);
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
        List<Patient> pat = new ArrayList<Patient>(hospital);
        Collections.sort(pat, new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return pat;
    }



    //get by AnalysisType

    public List<Patient> getByAnalysisType (AnalysisType type) {
        List<Patient> pat = new ArrayList<Patient>(hospital);
        Iterator<Patient> i = pat.iterator();
        while (i.hasNext()) {
            List<Analysis> a = new ArrayList<>(i.next().getList());
            for(Analysis anal:a) {

               if(!(anal.getType().equals(type))) break;
            }
        }
        return pat;
    }





    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Patient value: hospital) {
            builder.append(value);
        }
        String patient = builder.toString();

        return "Hospital" + title + "\n" +
                patient;
    }

}
