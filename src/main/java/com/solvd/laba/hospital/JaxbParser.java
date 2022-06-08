package com.solvd.laba.hospital;

import com.solvd.laba.hospital.model.Hospital;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class JaxbParser {

    public Hospital parse(File file) {
        Hospital result = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hospital.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            result = (Hospital) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException("Unable to parse xml " + e.getMessage(), e);
        }
        return result;
    }
}
