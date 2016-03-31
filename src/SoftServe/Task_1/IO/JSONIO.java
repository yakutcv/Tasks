package SoftServe.Task_1.IO;

import SoftServe.Task_1.Interfaces.IO;
import SoftServe.Task_1.Logic.Hospital;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class JSONIO implements IO {
    @Override
    public void writeHospital(Hospital hospital, String file) throws JAXBException, IOException {

    }

    @Override
    public Hospital readHospital(String file) throws JAXBException, IOException {
        return null;
    }
}
