-- updates
update Diagnosis
set description = 'not terrible headache'
where id = 1;

update Suppliers
set country = 'Belarus'
where name = 'DealMed';

update Employees
set first_name = 'Vasilii'
where first_name = 'Vasiliy';

update Employees
set qualification = 3
where position = 'head of department';

update Employees
set qualification = 4
where position = 'chief doctor';

update Employees
set qualification = 5
where first_name = 'Alexandr';

update Specializations
set salary = 980
where name = 'neuropathologist';

update Department_equipments
set quantity = 560
where equipment_id = (select id from Equipments where name = 'deffibrilator');

update Hospitals
set phone_number = 12354
where title = 'City clinical hospital №6';

update Appointments
set date = '2022-5-08'
where patient_id = (select id from Patients where first_name = 'Kristina');

-- deleting
delete
from Medications
where price < 2;

delete
from Department_medications
where medication_id = (select id from Medications where name = "Cetorolac");

delete
from Employees
where specialization_id = (select id from Specializations where name = "surgeon")
  and qualification = 2;

delete
from Rooms
where number = 123;

delete
from Rooms
where id = 1;

delete
from Employees
where qualification <= 3;

delete
from Diagnosis
where title like 'pneumo%';

delete
from Employees
where name = 'Alexandr';

delete
from Hospitals
where phone_number = 12354
  and title = 'City clinical hospital №6';

delete
from Appointments
where date = '2022-5-08';

-- alter tables
alter table Employees
    add column new_column VARCHAR(45) NOT NULL;

alter table Employees drop column new_column;

alter table Rooms rename COLUMN number to number1;

alter table Rooms rename COLUMN number1 to number;

alter table Rooms alter column number set default 1;

-- selects
select h.title as hospital, e.first_name, e.last_name, a.city, a.street, a.building_number, h.phone_number
from Hospitals h
         inner join Employees e on h.chief_doctor_id = e.id
         inner join Addresses a on h.address_id = a.id;


select d.title as department, e.first_name, e.last_name
from Departments d
         inner join Employees e on d.department_head_id = e.id
where d.hospital_id = 1;
select d.title as department, e.first_name, e.last_name
from Departments d
         inner join Employees e on d.department_head_id = e.id
where d.hospital_id = 2;
select d.title as department, e.first_name, e.last_name
from Departments d
         inner join Employees e on d.department_head_id = e.id
where d.hospital_id = 3;

select e.name as equipment, s.name as supplier, s.country, e.price
from Equipment_Suppliers es
         inner join Equipments e
                    on es.equipment_id = e.id
         inner join Suppliers s on es.supplier_id = s.id;
select m.name as medication, m.form, m.dosage, s.name as supplier, s.country, m.price
from Medication_Suppliers ms
         inner join Medications m
                    on ms.medication_id = m.id
         inner join Suppliers s on ms.supplier_id = s.id;

select d.title as department, count(e.id) as equipment_quantity
from Department_equipments de
         inner join Departments d
                    on de.department_id = d.id
         inner join Equipments e on de.equipment_id = e.id
group by d.title;
select d.title as department, count(m.id) as medication_quantity
from Department_medications dm
         inner join Departments d
                    on dm.department_id = d.id
         inner join Medications m on dm.medication_id = m.id
group by d.title;

select h.title as hospital, count(d.id) as department_quantity
from Departments d
         inner join Hospitals h
                    on d.hospital_id = h.id
group by h.title;


select first_name, last_name, s.name, s.salary
from Employees e
         inner join Specializations s
                    on e.specialization_id = s.id
where s.salary > 1000
order by s.salary desc;

select d.title as department, avg(s.salary) as average_salary
from Departments d
         inner join Employees e on d.id = e.department_id
         inner join Specializations s on e.specialization_id = s.id
where d.hospital_id = (select id from Hospitals where title = "City clinical hospital №6")
group by d.title;

select d.title as department, count(p.id) as patients_quantity
from Departments d
         inner join Wards w
                    on d.id = w.department_id
         inner join Patients p on w.id = p.ward_id
group by d.title;

select w.number as ward, w.floor, p.first_name, p.last_name
from Wards w
         left join Patients p
                   on w.id = p.ward_id
order by w.number;

select first_name, last_name
from Patients
where disease_history_id is not null
order by first_name;

select *
from Employees
where specialization_id = (select id from Specializations where name = "surgeon")
  and qualification = 2;

select first_name, last_name, age
from Patients
where age = (select max(age) from Patients);

select name
from Equipments
union
select name
from Medications;

select first_name, last_name
from Employees e
union
select first_name, last_name
from Patients
order by first_name;