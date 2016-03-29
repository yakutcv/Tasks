package SoftServe.Task_1;

import java.util.*;

/**
 * Created by ayasintc on 3/29/2016.
 */
public class Hospital {

    private String titles;

    public Hospital(String titles) {
        this.titles = titles;
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

    //get by date






}
