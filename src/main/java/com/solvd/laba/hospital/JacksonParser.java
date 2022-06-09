package com.solvd.laba.hospital;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.solvd.laba.hospital.model.Employee;
import com.solvd.laba.hospital.model.Hospital;

import java.io.File;
import java.io.IOException;

public class JacksonParser {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public Hospital parse(File file) {
        Hospital company = null;
        try {
            company = MAPPER.readValue(file, Hospital.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse json " + e.getMessage());
        }
        return company;
    }

    public static class PositionDeserializer extends StdDeserializer<Employee.Position> {

        protected PositionDeserializer() {
            super(Employee.Position.class);
        }

        @Override
        public Employee.Position deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jsonParser.getCodec().readTree(jsonParser);
            String strPosition = node.asText();

            Employee.Position result;

            switch (strPosition) {
                case "head":
                    result = Employee.Position.DEPARTMENT_HEAD;
                    break;
                case "doc":
                    result = Employee.Position.DOCTOR;
                    break;
                case "nur":
                    result = Employee.Position.NURSE;
                    break;
                default:
                    throw new RuntimeException("Check that position is correct");
            }
            return result;
        }
    }
}
