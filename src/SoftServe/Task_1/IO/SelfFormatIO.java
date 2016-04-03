package SoftServe.Task_1.IO;

import SoftServe.Task_1.Interfaces.IO;
import SoftServe.Task_1.Logic.Hospital;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SelfFormatIO implements IO {

    @Override
    public void writeHospital(Hospital hospital, String file) throws IOException {

        FileWriter writer = new FileWriter("src\\SoftServe\\Task_1\\data\\" + file);
        FileOutputStream fos = new FileOutputStream("output.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(hospital);
        oos.flush();
        oos.close();

        try{
            writer.append(hospital.toString());
            writer.flush();
            writer.close();
            System.out.println("Txt file created!");
        }catch (IOException e) {
            System.out.println("Failed to record file!" + e);
        }



    }

    @Override
    public Hospital readHospital(String file) throws IOException {
        return null;
    }
}
