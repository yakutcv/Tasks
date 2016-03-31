package SoftServe.Task_1.Entity;

/**
 * Created by ayasintc on 3/29/2016.
 */
import org.joda.time.DateTime;
import org.joda.time.Years;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Patient", propOrder = {
        "name",
        "lastName",
        "birthDate",
        "listAnalyzes"
})

public class Patient {

    private String name = "Default name";
    private String lastName = "Default lastName";
    private DateTime birthDate = new DateTime(2014,3,28,15,00);
    private List<Analysis> listAnalyzes = new ArrayList<>();

    public Patient() {
    }

    @XmlElement
    public DateTime getBirthDate() {
        return birthDate;
    }

    @XmlElementWrapper(name = "List_Analyzes")
    @XmlElement(name = "Analysis")
    public List<Analysis> getList() {
        return listAnalyzes;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public String getName() {
        return name;
    }


    public int getAge(){
        DateTime date = new DateTime();
        return Years.yearsBetween(birthDate, date).getYears();
    }

    //method to format incoming name
    private String formatName (String value) {
        String tmp = value.toLowerCase();
        String formatName;
        return formatName = tmp.substring(0,1).toUpperCase() + tmp.substring(1, tmp.length());
    }

    //get Full Name
    public String getFullName () {
        return formatName(getName()) + " " + formatName(getLastName());
    }

    //builder
    public static PatientBuilder newPatientBuilder () {
        return new Patient().new PatientBuilder();
    }

    public class PatientBuilder {

        private PatientBuilder() {
        }

        public PatientBuilder setBirthDate(DateTime birthDate) {
            Patient.this.birthDate = birthDate;
            return this;
        }

        public PatientBuilder setLastName(String lastName) {
            Patient.this.lastName = lastName;
            return this;
        }

        public PatientBuilder setName(String name) {
            Patient.this.name = name;
            return this;
        }

        public PatientBuilder setAnalyzes(Analysis analyzes) {
            Patient.this.listAnalyzes.add(analyzes);
            return this;
        }

        public Patient build() {
            return Patient.this;
        }
    }


  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (!birthDate.equals(patient.birthDate)) return false;
        if (!lastName.equals(patient.lastName)) return false;
        if (!name.equals(patient.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }*/

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Analysis value: listAnalyzes) {
            builder.append(value);
        }
        String analyzes = builder.toString();
        return "Patient - "+ getFullName() +
                ", age - " + getAge() + " years." + "\n" +
                "The total number of Analyzes: " + getList().size() + "\n" +
                "All Analyzes:" + "\n" +
                analyzes;
    }



}