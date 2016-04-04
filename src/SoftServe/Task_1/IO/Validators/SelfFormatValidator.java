package SoftServe.Task_1.IO.Validators;

import SoftServe.Task_1.IO.Exceptions.SelfFormatException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static SoftServe.Task_1.IO.Exceptions.ExceptionList.*;

public class SelfFormatValidator {

    private static final String NAME_PATTERN = "[A-Z,a-z]+";
    private static final String INPUT_PATTERN = "(([A-Z,a-z]{1,})\\s([A-Z,a-z]{1,})\\s\\(.*\\))\\:\\{(\\w*\\s\\(.*\\)\\s(\\w*\\s*){1,}\\,|\\,){1,}\\s*\\}";

    private static DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");
    private static DateTimeFormatter format2 = DateTimeFormat.forPattern("dd/MM/yyyy");

    public static boolean validPatient(List<String> string) throws SelfFormatException {
        List<String> tmpList = string;

        if(!validName(tmpList.get(0))) {
            throw new SelfFormatException(INVALID_NAME);
            }
        if(!validName(tmpList.get(1))) {
            throw new SelfFormatException(INVALID_LAST_NAME);
            }
        if(!validBirthDate(tmpList.get(2))) {
            throw new SelfFormatException(INVALID_BIRTH_DATE);
        }

        //System.out.println(tmpList.get(3));

        String ff[] = tmpList.get(3).split(",");
        System.out.println(ff.length);



        return true;
    }

    public static boolean validBirthDate(String date) {
        try{
            DateTime dateTime = DateTime.parse(date, format2);
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid date format!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean validInputValue(String string, String regexp){
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(string);
        return m.matches();
    }

    public static boolean validName(String name) {
        if(validInputValue(name, NAME_PATTERN)) {
            return true;
        }else {
            return false;
        }

    }














    public static void main(String[] args) {

        String strt = "Andrew Yasinskiy (04/04/1987 14:00):{HORMONES (03/02/2015 14:10) Good Analyzes, ALLERGY (03/02/2015 14:15) Good, }";

        String string = "Petia Petrushkin (04/04/1954):{BLOOD (03/01/2014 14:15) Yeap, ALLERGY (03/01/2016 14:15) Mu-ha-ha, }";
        String string2 = "Petia";


        String pat5 = "(([A-Z,a-z]{1,})\\s([A-Z,a-z]{1,})\\s\\(.*\\))\\:\\{(\\w*\\s\\(.*\\)\\s(\\w*\\s*){1,}\\,|\\s){1,}\\s*\\}";

        String pat6 = "([A-Z]{1}[a-z]{1,})\\s([A-Z]{1}[a-z]{1,})\\s\\((.*)\\)\\:\\{(.*)\\}";
        String pat7 = "([A-Z]{1}[a-z]{1,})\\s([A-Z]{1}[a-z]{1,})";



        //Vasia Pupkin (04/04p/1998):{}

        Pattern p = Pattern.compile(NAME_PATTERN);
        Matcher m = p.matcher(string2);



        System.out.println(m.matches());
        System.out.println(m.groupCount());



        String ggf = "(\\((\\d*\\/){2,3}\\))";
        String ggfe = "(\\d*\\/)+";




    }
}
