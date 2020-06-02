-- auto Generated on 2020-05-30
DROP TABLE IF EXISTS student_entity;
CREATE TABLE student(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	student_id VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'studentId',
	`name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
	gender VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'gender',
	register_date DATE DEFAULT NULL COMMENT 'registerDate',
	op_time TIMESTAMP DEFAULT NULL COMMENT 'op_time',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'student';
