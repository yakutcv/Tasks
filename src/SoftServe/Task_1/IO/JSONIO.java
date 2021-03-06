package SoftServe.Task_1.IO;

import SoftServe.Task_1.IO.Adapters.DateTimeForJSONAdapter;
import SoftServe.Task_1.Interfaces.IO;
import SoftServe.Task_1.Logic.Hospital;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;

import java.io.*;

public class JSONIO implements IO {

    DateTimeForJSONAdapter formatter = new DateTimeForJSONAdapter();

    @Override
    public void writeHospital(Hospital hospital, String file) throws  IOException {
        Gson gson = new GsonBuilder().registerTypeAdapter(DateTime.class, new DateTimeForJSONAdapter()).setPrettyPrinting().create();
        String json = gson.toJson(hospital);
        try{
            FileWriter writer = new FileWriter("src\\SoftServe\\Task_1\\data\\" + file);
            writer.write(json);
            writer.close();
            System.out.println("Json file created!");
        }catch (IOException e) {
            System.out.println("Failed to record file!" + e);
        }
    }

    @Override
    public Hospital readHospital(String file) throws FileNotFoundException {
        Gson gson = new GsonBuilder().registerTypeAdapter(DateTime.class, new DateTimeForJSONAdapter()).create();
        Hospital hospital = new Hospital();
        try{
            BufferedReader br = new BufferedReader(new FileReader("src\\SoftServe\\Task_1\\data\\" + file));
            hospital = gson.fromJson(br, Hospital.class);
            System.out.println(hospital);
        }catch (FileNotFoundException e) {
            System.out.println("File not found!" + e);

        }catch (IOException e ) {
            e.printStackTrace();
        }

        return hospital;
    }
}
