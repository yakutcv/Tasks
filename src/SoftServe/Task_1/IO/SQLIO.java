package SoftServe.Task_1.IO;

import SoftServe.Task_1.Interfaces.IO;
import SoftServe.Task_1.Logic.Hospital;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by ayasintc on 4/4/2016.
 */
public class SQLIO implements IO {
    @Override
    public void writeHospital(Hospital hospital, String file) throws JAXBException, FileNotFoundException, IOException {

    }

    @Override
    public Hospital readHospital(String file) throws JAXBException, FileNotFoundException, IOException, ClassNotFoundException {
        return null;
    }
}
