package SoftServe.Task_1.IO.Validatos;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SelfFormatValidator {

    private static final String NAME_PATTERN = "[A-Z,a-z]+";
    private static final String INPUT_PATTERN = "((\\w*)\\s(\\w*)\\s\\[(\\w*]:\\s))(\\{.*})";

    private DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");











    public boolean validDateTimeFormat(String date) {
        try{
            DateTime dateTime = DateTime.parse(date, format);
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid date format!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean isValidInputValue(String string, String regexp){
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(string);
        return m.matches();
    }


    public static boolean validName(String name) {
        if(isValidInputValue(name, NAME_PATTERN)) {
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {

        String strt = "Andrew Yasinskiy (04/04/1987 14:00):{HORMONES (03/02/2015 14:10) Good Analyzes, ALLERGY (03/02/2015 14:15) Good, }";
        String strtf = "andrew Yasinskiy ";
        String strtfd = "04/04/1987";



        String dd = "((\\w*)\\s(\\w*)\\s\\[(\\w*]:\\s))(\\{.*})";

        String gg = "((\\w*)\\s(\\w*)\\s)";


        String ggf = "(\\((\\d*\\/){2,3}\\))";
        String ggfe = "(\\d*\\/)+";




        if(isValidInputValue(strtfd, ggfe)) {
            System.out.println("true");

        }else{
            System.out.println(false);
        }










    }
}
