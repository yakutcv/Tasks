package SoftServe.Task_1.Entity;

/**
 * Created by ayasintc on 3/29/2016.
 */

import SoftServe.Task_1.IO.Adapters.DateTimeForXmlAdapter;
import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Patient")
@XmlAccessorType(XmlAccessType.FIELD)
   @XmlType(name="Patient", propOrder = {
        "id",
        "name",
        "lastName",
        "birthDate",
        "listAnalyzes"
})

public class Patient implements Serializable {

    public Patient(long id) {
        this.id = id;
    }

    private DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");

    @XmlAttribute(name="id")
    private long id=0;

    @SerializedName("Name")
    @XmlElement
    private String name = "Default name";

    @SerializedName("Last name")
    @XmlElement
    private String lastName = "Default lastName";

    //@JsonAdapter(DateTimeForJSONAdapter.class)
    @SerializedName("Birthday")
    @XmlJavaTypeAdapter(DateTimeForXmlAdapter.class)
    @XmlElement
    private DateTime birthDate = new DateTime(2014,3,28,15,00);

    @SerializedName("List of Analyzes")
    @XmlElementWrapper(name="List_of_Analyzes")
    @XmlElement(name="Analysis")
    private List<Analysis> listAnalyzes = new ArrayList<>();

    public Patient() {

    }

    public DateTime getBirthDate() {
        return birthDate;
    }

//    @XmlElementWrapper(name = "Analysis")

    public List<Analysis> getList() {
        return listAnalyzes;
    }


    public String getLastName() {
        return lastName;
    }


    public String getName() {
        return name;
    }

    public String getBirthDateInString(){
        return birthDate.toString(formatter);
    }

    public int getAge(){
        DateTime date = new DateTime();
        return Years.yearsBetween(birthDate, date).getYears();
    }

    public long getId() {
        return id;
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

        public PatientBuilder setBirthDate(String birthDate) {
            Patient.this.birthDate = formatter.parseDateTime(birthDate);
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

        public PatientBuilder setId(long id) {
            Patient.this.id = id;
            return this;
        }
        public PatientBuilder setAnalysis(Analysis analyzes) {
            Patient.this.listAnalyzes.add(analyzes);
            return this;
        }

        public PatientBuilder setAnalyzes(List<Analysis> analyzes) {
            Patient.this.listAnalyzes=analyzes;
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


    //first override
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

/*    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");

        return "Patient{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate.toString(format) +
                ", listAnalyzes=" + listAnalyzes +
                '}';
    }*/
}