-- auto Generated on 2020-05-30
-- DROP TABLE IF EXISTS student_exam;
CREATE TABLE student_exam(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	exam_id VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'examId',
	student_id VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'studentId',
	grade FLOAT (10,2) NOT NULL DEFAULT -1.0 COMMENT 'grade',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'student_exam';
