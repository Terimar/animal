use
hospital;

insert into Suppliers (name, country)
values ("Belmedtechnic", "Belarus"),
       ("Belmedpreparaty", "Belarus"),
       ("DealMed", "Russia"),
       ("Tagler", "Russia"),
       ("Sigma", "Germany"),
       ("Vermeiren", "Belgium"),
       ("Glavpharm", "Russia"),
       ("Atalantique repartition", "France");

insert into Equipments (name, price)
values ("dropper", 20.4),
       ("deffibrilator", 100.8),
       ("ultrasonic dissector", 300.7),
       ("feeding tube", 3.0),
       ("operation table", 30.6);

insert into Medications (name, form, dosage, price)
values ("Ibypophen", "pills", 5.0, 4.2),
       ("Cetorolac", "pills", 3.4, 2.6),
       ("Ambroksol", "pills", 2.1, 1.2),
       ("Furasol", "powder", 5, 0.9),
       ("Levomekol", "ointment", 7, 2.3);

insert into Equipment_suppliers (equipment_id, supplier_id)
values (4, 1),
       (1, 5),
       (2, 4),
       (3, 3),
       (5, 6),
       (1, 1),
       (2, 8);

insert into Medication_suppliers (medication_id, supplier_id)
values (1, 2),
       (2, 4),
       (3, 6),
       (4, 7),
       (4, 4),
       (5, 7),
       (3, 5);

insert into Addresses (city, street, building_number)
values ("Minsk", "Uralskaya", "5/1"),
       ("Minsk", "Filatava", "9"),
       ("Vitebsk", "Frunze", "71");

insert into Specializations (name, salary)
values ("anesthetist", 1000.0),
       ("cardiologist", 1500.2),
       ("oncologist", 1600.3),
       ("surgeon", 1100.5),
       ("traumatologist", 990.7),
       ("neuropathologist", 800.0),
       ("dentist", 2000.7),
       ("therapist", 850.3);

insert into Employees (first_name, last_name, specialization_id, position)
values ("Ivan", "Ivanov", 2, "DOCTOR"),
       ("Petr", "Petrov", 3, "DOCTOR"),
       ("Maria", "Loseva", 5, "DOCTOR"),
       ("Vladimir", "Vladimirov", 1, "DEPARTMENT_HEAD"),
       ("Petr", "Ivanov", 2, "DEPARTMENT_HEAD"),
       ("Zinaida", "Morozova", 3, "DEPARTMENT_HEAD"),
       ("Irina", "Novik", 4, "DEPARTMENT_HEAD"),
       ("Ivan", "Vasiliev", 5, "DEPARTMENT_HEAD"),
       ("Dmitriy", "Oskin", 6, "DEPARTMENT_HEAD"),
       ("Elena", "Shavruk", 7, "DEPARTMENT_HEAD"),
       ("Vasiliy", "Novikov", 8, "DEPARTMENT_HEAD"),
       ("Viktor", "Mironenko", 8, "DEPARTMENT_HEAD"),
       ("Andrey", "Sedyn", 4, "DEPARTMENT_HEAD"),
       ("Nastasya", "Novik", 5, "DEPARTMENT_HEAD"),
       ("Alexandr", "Bylova", 2, "DEPARTMENT_HEAD"),
       ("Olga", "Piluga", 1, "DEPARTMENT_HEAD"),
       ("Ellina", "Dashuk", 1, "DEPARTMENT_HEAD"),
       ("Galina", "Podgornaya", 2, "DEPARTMENT_HEAD"),
       ("Nikolay", "Punchik", 4, "DEPARTMENT_HEAD"),
       ("Vasiliy", "Korchik", 5, "DEPARTMENT_HEAD");

insert into Hospitals (title, chief_doctor_id, address_id, phone_number)
values ("City clinical hospital №6", 1, 1, 12345),
       ("City clinical hospital №5", 2, 2, 67891),
       ("Ambulance hospital", 3, 3, 13579);

insert into Departments (title, department_head_id, hospital_id)
values ("therapeutic", 11, 1),
       ("cardiological", 5, 1),
       ("oncological", 6, 1),
       ("neurological", 9, 1),
       ("anesthetic and intensive care", 4, 1),
       ("surgical", 7, 1),
       ("traumatological", 8, 1),
       ("dental", 10, 1),
       ("therapeutic", 12, 2),
       ("surgical", 13, 2),
       ("traumatological", 14, 2),
       ("cardiological", 15, 2),
       ("anesthetic and intensive care", 16, 2),
       ("anesthetic and intensive care", 17, 3),
       ("cardiological", 18, 3),
       ("surgical", 19, 3),
       ("traumatological", 20, 3);

insert into Employees (first_name, last_name, specialization_id, department_id, qualification)
values ("Alexandr", "Konyukh", 8, 1, 2),
       ("Alexandr", "Vorobyev", 2, 2, 1),
       ("Valeriy", "Litvinets", 5, 11, 2),
       ("Yakub", "Kolas", 7, 12, 2),
       ("Yanka", "Kupala", 2, 15, 2),
       ("Dmitriy", "Marushka", 4, 16, 2);

insert into Wards (number, floor, department_id)
values (100, 1, 7),
       (230, 2, 15),
       (310, 3, 3),
       (470, 4, 11),
       (529, 5, 16),
       (114, 1, 9);

insert into Disease_histories (date)
values ('2019-7-04'),
       ('2008-6-06'),
       ('2018-3-07'),
       ('2020-1-09');

insert into Diagnosis (disease_history_id, title, description)
values (1, 'asthma', 'terrible headache'),
       (2, 'flu', 'terrible headache'),
       (3, 'pneumonia', 'terrible headache'),
       (4, 'pneumonia', 'terrible headache');

insert into Patients (first_name, last_name, age, ward_id, disease_history_id)
values ("Diana", "Melnikova", 48, 3, 1),
       ("Valeria", "Sidyako", 22, 2, 2),
       ("Vladislav", "Kolesnik", 56, 1, 3),
       ("Kristina", "Kolesnik", 43, 1, 4);

insert into Department_equipments (department_id, equipment_id, quantity)
values (4, 5, 32),
       (15, 3, 100),
       (10, 1, 490),
       (9, 2, 10),
       (7, 4, 51),
       (13, 2, 76),
       (1, 5, 90);

insert into Department_medications (department_id, medication_id, quantity)
values (5, 1, 76),
       (16, 2, 54),
       (7, 3, 71),
       (8, 5, 300),
       (12, 4, 179),
       (13, 4, 270),
       (16, 1, 560);

insert into Rooms (number)
values (123),
       (234),
       (345),
       (456);

insert into Appointments (employee_id, patient_id, room_id, date)
values (1, 2, 3, '2022-5-04'),
       (2, 1, 4, '2022-5-05'),
       (3, 4, 2, '2022-5-06'),
       (4, 3, 1, '2022-5-07');