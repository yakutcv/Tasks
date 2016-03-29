package SoftServe.Task_1;

/**
 * Created by ayasintc on 3/29/2016.
 */
import org.joda.time.DateTime;

import java.util.*;

public class Laboratory {

    private Set<Patient> lab = new HashSet<Patient> ();

    //add new patient
    public void addPatient (Patient patient) {
        lab.add(patient);
    }

    //get by age
    public List<Patient> getByAge(int age) {
        List<Patient> pat = new ArrayList<Patient>(lab);
        Iterator<Patient> i = pat.iterator();
        while (i.hasNext()) {
            if(!(i.next().getAge()==(age)))i.remove();
        }
        return pat;
    }






   /* //get by title
    public List<Analyzes> getByTitle (String title) {
        List<Analyzes> a = new ArrayList<Analyzes>(analis);
        Iterator<Analyzes> i = a.iterator();
        while(i.hasNext()){
            if(!(i.next().getType().equals(title))) i.remove();
        }

        return analyses22;
    }

    //sort by date
    public List<Analyzes> sortAnalysisByDate () {
        List<Analyzes> analyses22 = new ArrayList<Analyzes>(analis);
        Collections.sort(analyses22, new Comparator<Analyzes>() {
            @Override
            public int compare(Analyzes o1, Analyzes o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return analyses22;
    }


    //sort by title
    public List<Analyzes> sortAnalysisByTitle () {
        List<Analyzes> analyses22 = new ArrayList<Analyzes>(analis);
        Collections.sort(analyses22, new Comparator<Analyzes>() {
            @Override
            public int compare(Analyzes o1, Analyzes o2) {
                return (int) o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return analyses22;
    }
*/




}
