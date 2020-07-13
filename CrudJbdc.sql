create table Students(
	student_id int IDENTITY(1,1) PRIMARY KEY,
	student_name varchar(255) NOT NULL,
	gener varchar(1) NOT NULL,
	situacao_id int NOT NULL,
	student_login varchar(30) NOT NULL
);

ALTER TABLE Students
	ADD CONSTRAINT fk_Situacoes FOREIGN KEY (situacao_id) REFERENCES Situations (situacao_id);

create table Situations(
	situacao_id int IDENTITY(1,1) PRIMARY KEY,
	situacao varchar(25) NOT NULL,
	student_login varchar(30) NOT NULL
);

create table Courses(
	course_id int IDENTITY(1,1) PRIMARY KEY,
	course_name varchar (50)NOT NULL,
	student_login varchar(30) NOT NULL
);

create table Classes(
	class_id int IDENTITY(1,1) PRIMARY KEY,
	student_id int NOT NULL,
	course_id int NOT NULL,
	student_login varchar(25) NOT NULL
);

ALTER TABLE Classes
	ADD CONSTRAINT fk_Students FOREIGN KEY (student_id) REFERENCES Students (student_id);

ALTER TABLE Classes
	ADD CONSTRAINT fk_Course FOREIGN KEY (course_id) REFERENCES Courses (course_id);


INSERT INTO Students (student_name, gener, situacao_id, student_login) VALUES ('Pedro', 'M', 1, 'Maicon');
INSERT INTO Students (student_name, gener, situacao_id, student_login) VALUES ('Maicon', 'M', 2, 'Pedro');

INSERT INTO Courses (course_name, student_login) VALUES ('Portugues', 'Carlosjohn');
INSERT INTO Courses (course_name, student_login) VALUES ('Matematica', 'Pedro');

INSERT INTO Situations(situacao, student_login) VALUES ('Aprovado', 'Carlosjohn');
INSERT INTO Situations (situacao, student_login) VALUES ('Reprovado', 'Pedro');

INSERT INTO Classes(student_id, course_id, student_login) VALUES ('Aprovado', 'Carlosjohn');
INSERT INTO Classes (student_id, course_id, student_login) VALUES ('Reprovado', 'Pedro');




