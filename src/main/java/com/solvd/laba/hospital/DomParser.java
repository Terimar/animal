package com.solvd.laba.hospital;

import com.solvd.laba.hospital.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DomParser {

    private Hospital hospital;

    public Hospital parse(File file) {
        Hospital result = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            result = parse(document);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Hospital parse(Document document) {
        if (document.hasChildNodes()) {
            parse(document.getChildNodes());
        }
        return hospital;
    }

    private void parse(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i ++) {
            Node node = nodes.item(i);
            if (node.hasChildNodes()) {
                String nodePath = getParentNodePath(node);
                String value = node.getTextContent();
                switch (nodePath) {
                    case "hospital":
                        hospital = new Hospital();
                        hospital.setTitle(node.getAttributes().getNamedItem("title").getNodeValue());
                        break;
                    case "hospital.chiefDoctor":
                        hospital.setChiefDoctor(new Employee());
                        break;
                    case "hospital.chiefDoctor.position":
                        hospital.getChiefDoctor().setPosition(Employee.Position.valueOf(value));
                        break;
                    case "hospital.chiefDoctor.qualification":
                        hospital.getChiefDoctor().setQualification(Integer.valueOf(value));
                        break;
                    case "hospital.chiefDoctor.specialization":
                        hospital.getChiefDoctor().setSpecialization(new Specialization());
                        break;
                    case "hospital.chiefDoctor.specialization.name":
                        hospital.getChiefDoctor().getSpecialization().setName(value);
                        break;
                    case "hospital.chiefDoctor.specialization.salary":
                        hospital.getChiefDoctor().getSpecialization().setSalary(new BigDecimal(value));
                        break;
                    case "hospital.chiefDoctor.appointments":
                        hospital.getChiefDoctor().setAppointments(new ArrayList<>());
                        break;
                    case "hospital.chiefDoctor.appointments.appointment":
                        hospital.getChiefDoctor().getAppointments().add(new Appointment());
                        break;
                    case "hospital.chiefDoctor.appointments.appointment.date":
                        hospital.getChiefDoctor().getAppointments().get(hospital.getChiefDoctor().getAppointments().size() - 1).setDate(parseDate(value));
                        break;
                    case "hospital.departments":
                        hospital.setDepartments(new ArrayList<>());
                        break;
                    case "hospital.departments.department":
                        Department department = new Department();
                        department.setTitle(node.getAttributes().getNamedItem("title").getNodeValue());
                        hospital.getDepartments().add(department);
                        break;
                    case "hospital.departments.department.employees":
                        hospital.getDepartments().get(hospital.getDepartments().size() - 1).setEmployees(new ArrayList<>());
                        break;
                    case "hospital.departments.department.employees.employee":
                        Employee employee = new Employee();
                        employee.setId(Long.valueOf(node.getAttributes().getNamedItem("id").getNodeValue()));
                        Department dep = hospital.getDepartments().get(hospital.getDepartments().size() - 1);
                        dep.getEmployees().add(employee);
                        break;
                    case "hospital.departments.department.employees.employee.firstName":
                        Department dep1 = hospital.getDepartments().get(hospital.getDepartments().size() - 1);
                        dep1.getEmployees().get(dep1.getEmployees().size() - 1).setFirstName(value);
                        break;
                    case "hospital.departments.department.employees.employee.lastName":
                        Department dep2 = hospital.getDepartments().get(hospital.getDepartments().size() - 1);
                        dep2.getEmployees().get(dep2.getEmployees().size() - 1).setLastName(value);
                        break;
                    case "hospital.address":
                        hospital.setAddress(new Address());
                        break;
                    case "hospital.address.city":
                        hospital.getAddress().setCity(value);
                        break;
                    case "hospital.address.street":
                        hospital.getAddress().setStreet(value);
                        break;
                    case "hospital.address.buildingNumber":
                        hospital.getAddress().setBuildingNumber(value);
                        break;
                    default:
                        break;
                }

                parse(node.getChildNodes());
            }
        }
    }

    private String getParentNodePath(Node node) {
        String path = node.getNodeName();
        Node parentNode = node.getParentNode();
        while (parentNode.getNodeType() != Node.DOCUMENT_NODE) {
            path = parentNode.getNodeName() + "." + path;
            parentNode = parentNode.getParentNode();
        }
        return path;
    }

    private Date parseDate(String value) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse date " + e.getMessage());
        }
    }
}
