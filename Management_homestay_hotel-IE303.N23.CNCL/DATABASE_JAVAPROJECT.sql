CREATE DATABASE MANAGEMENTHOMESTAYHOTEL;
USE MANAGEMENTHOMESTAYHOTEL;

CREATE TABLE HOTELHOMESTAY (
	ht_id INT PRIMARY KEY AUTO_INCREMENT,
    ht_name VARCHAR(30),
    ht_address VARCHAR(50),
    room_count INT
);

CREATE TABLE ROOM (
	room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_name VARCHAR(20),
    room_type VARCHAR(40),
    room_rates DOUBLE,
    room_status BOOLEAN,
    ht_id INT,
    FOREIGN KEY (ht_id) REFERENCES HOTELHOMESTAY(ht_id)
);

CREATE TABLE CUSTOMER (
	cus_id INT PRIMARY KEY AUTO_INCREMENT,
    cus_name VARCHAR(20),
    cus_email VARCHAR(50),
    cus_phone VARCHAR(20),
    cus_address VARCHAR(50)
);

CREATE TABLE BOOKING (
	booking_id INT PRIMARY KEY AUTO_INCREMENT,
    cus_id INT,
    room_id INT,
    booking_date DATETIME,
    check_in_date DATE,
    check_out_date DATE,
    FOREIGN KEY (cus_id) REFERENCES CUSTOMER(cus_id),
    FOREIGN KEY (room_id) REFERENCES ROOM(room_id)
);

CREATE TABLE EMPLOYEE (
	emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(20),
    shift INT,
	emp_phone VARCHAR(20),
    emp_address VARCHAR(50),
    emp_acc VARCHAR(30),
    emp_pass VARCHAR(10)
);

CREATE TABLE BILL (
	bill_id INT PRIMARY KEY AUTO_INCREMENT,
	cus_id INT,
    emp_id INT,
	create_date DATETIME,
    total_amount DOUBLE,
	paid_status BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (cus_id) REFERENCES CUSTOMER(cus_id),
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEE(emp_id)
);

CREATE TABLE SERVICE (
	sv_id INT PRIMARY KEY AUTO_INCREMENT,
	sv_name VARCHAR(20),
	sv_price DOUBLE	
);

CREATE USER 'admin'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON QLKSHS.* TO 'admin'@'localhost';


ALTER TABLE BOOKING
ADD CONSTRAINT date_check CHECK (check_in_date<=check_out_date);

DELIMITER //

CREATE TRIGGER before_booking_insert
BEFORE INSERT ON BOOKING
FOR EACH ROW
BEGIN
    DECLARE roomstatus BOOL;

    SELECT room_status INTO roomstatus
    FROM ROOM
    WHERE room_id = NEW.room_id;

    IF roomstatus = true THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot book a room with status true';
    END IF;
END //

DELIMITER ;

INSERT INTO HOTELHOMESTAY (ht_id, ht_name, ht_address, room_count)
VALUES 
(111, 'Graden Hotel', 'Quan 1, TP Ho Chi Minh', 10),
(222, 'Graden HomeStay', 'TP Da Lat', 2);

INSERT INTO ROOM (room_id, room_name, room_type, room_rates, room_status, ht_id)
VALUES 
(01, 'P01', 'Single bed room', 100000, false, 111),
(02, 'P02', 'Single bed room', 100000, true, 111),
(03, 'P03', 'Twin bed room', 250000, false, 111),
(04, 'P04', 'Twin bed room ', 250000, true, 111),
(05, 'P05', 'Double bed room', 250000, false, 111),
(06, 'P06', 'Double bed room', 250000, true, 111),
(07, 'P07', 'Double bed room', 250000, true, 111),
(08, 'P08', 'Triple bed room', 300000, false, 111),
(09, 'P09', 'Triple bed room', 300000, false, 111),
(10, 'P10', 'Triple bed room', 300000, false, 111),
(21, 'A0', 'Common room', 300000, false, 222),
(22, 'A1', 'Master room', 380000, false, 222);

INSERT INTO CUSTOMER (cus_id, cus_name, cus_email, cus_phone, cus_address)
VALUES 
(120101, 'Pham Van A', 'pva@gmail.com', '0339857456', 'TP Nha Trang'),
(120102, 'Pham Thi B', 'ptb@gmail.com', '0339145368', 'TP Ninh Binh'),
(120103, 'Nguyen Van C', 'nvc@gmail.com', '0339471045', 'TP Long An'),
(120104, 'Tran Van D', 'tvd@gmail.com', '0371257456', 'TP Ho Chi Minh'),
(120105, 'Pham Nhat E', 'pne@gmail.com', '0814257456', 'TP Quang Ngai');

INSERT INTO BOOKING (booking_id, cus_id, room_id, booking_date, check_in_date, check_out_date)
VALUES 
(1001, 120101, 03, '2023-02-12 10:30:00', '2023-02-14', '2023-02-16'),
(1002, 120102, 05, '2023-02-12 10:30:00', '2023-02-14', '2023-02-16'),
(1003, 120103, 08, '2023-02-12 10:30:00', '2023-02-14', '2023-02-16'),
(1004, 120104, 09, '2023-02-12 10:30:00', '2023-02-14', '2023-02-16'),
(1005, 120105, 10, '2023-02-12 10:30:00', '2023-02-14', '2023-02-16');

INSERT INTO EMPLOYEE (emp_id, emp_name, shift, emp_phone, emp_address, emp_acc, emp_pass)
VALUES 
(10101, 'Tran Minh A', 1, 0815635541, 'Ktx khu A, TP Thu Duc', 'nhanvienca1', '123456789@Ca1'),
(10102, 'Lam Thanh B', 2, 0337420103, 'Ktx khu B, TP Thu Duc', 'nhanvienca2', '123456789@Ca2');
