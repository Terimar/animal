-- insert doctors
insert into `mydb`.`doctors`
(`idDoctors`, `name`, `position`)
values
(1, "John", "Chief");
INSERT INTO `mydb`.`doctors`
(`idDoctors`, `name`, `position`)
VALUES
(2, "Tom", "Surgeon");
INSERT INTO `mydb`.`doctors`
(`idDoctors`, `name`, `position`)
VALUES
(3, "Jack", "Therapist");
-- insert patients
insert into `mydb`.`patients`
(`idPatients`, `name`, `email`)
values
(1, "Andrey", "andrey@mail");
INSERT INTO `mydb`.`patients`
(`idPatients`, `name`, `email`)
VALUES
(2, "Oleg", "oleg@mail");
INSERT INTO `mydb`.`patients`
(`idPatients`, `name`, `email`)
VALUES
(3, "Maxim", "max@mail");
INSERT INTO `mydb`.`patients`
(`idPatients`, `name`, `email`)
VALUES
(4, "Dasha", "dasha@mail");
-- insert nurses
insert into `mydb`.`nurses`
(`idNurses`, `name`, `position`)
values
(1, "Emily", "Head nurse");
INSERT INTO `mydb`.`nurses`
(`idNurses`, `name`, `position`)
VALUES
(2, "Emma", "Nurse");
INSERT INTO `mydb`.`nurses`
(`idNurses`, `name`, `position`)
VALUES
(3, "Jenny", "Nurse");

-- update doctors
update `mydb`.`doctors` set
`name` = "Tim"
where `idDoctors` = 2;
UPDATE `mydb`.`doctors` SET
`position` = "Head"
WHERE `idDoctors` = 2;
UPDATE `mydb`.`doctors` SET
`position` = "Surgeon"
WHERE `idDoctors` = 2;
-- update nurses
update `mydb`.`nurses` set
`position` = "Head nurse"
where `idNurses` = 3;
UPDATE `mydb`.`nurses` SET
`position` = "Nurse"
WHERE `idNurses` = 1;
-- update patients
update `mydb`.`patients` set
`name` = "Olga"
where `idPatients` = 2;
UPDATE `mydb`.`patients` SET
`email` = "Olga@mail"
WHERE `idPatients` = 2;
UPDATE `mydb`.`patients` SET
`name` = "Oleg", `email` = "ol@mail"
WHERE `idPatients` = 2;
UPDATE `mydb`.`patients` SET
`name` = "Max"
WHERE `idPatients` = 3;
UPDATE `mydb`.`patients` SET
`name` = "Mary", `email` = "mary@mail"
WHERE `idPatients` = 4;

-- delete
delete from doctors
where idDoctors = 2;
DELETE FROM doctors
where idDoctors = 1;
DELETE FROM doctors
where idDoctors = 3;
DELETE FROM patients
where idPatients = 1;
DELETE FROM patients
where idPatients = 2;
DELETE FROM patients
where idPatients = 3;
DELETE FROM patients
where idPatients = 4;
DELETE FROM nurses
where idNurses = 1;
DELETE FROM nurses
where idNurses = 2;
DELETE FROM nurses
where idNurses = 3;

-- alter table
alter table patients add(age int);
alter table patients add(surname char);
alter table doctors add(age int);
alter table nurses add(age int);
alter table patients modify surname varchar(45);

-- with joins
select doctors.idDoctors, doctors.name, departments.name
from doctors
inner join departments on doctors.idDoctors=departments.chief_physician;

update patients set age=20 where idPatients=1;
update patients set age=22 where idPatients=2;
select name, avg(age) from patients group by age;