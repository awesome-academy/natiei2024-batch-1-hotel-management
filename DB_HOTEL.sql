-- Create database and use it
CREATE DATABASE IF NOT EXISTS HOTEL_DB;
USE HOTEL_DB;

-- Create tables
CREATE TABLE IF NOT EXISTS ROOM_TYPES (
    RoomTypeID VARCHAR(20) PRIMARY KEY,
    RoomTypeName VARCHAR(20),
    Price INT
);

CREATE TABLE IF NOT EXISTS ROOMS (
    RoomID VARCHAR(20) PRIMARY KEY,
    RoomName VARCHAR(20) UNIQUE,
    RoomTypeID VARCHAR(20),
    Note NVARCHAR(100),
    Status INT,
    FOREIGN KEY (RoomTypeID) REFERENCES ROOM_TYPES(RoomTypeID)
);

CREATE TABLE IF NOT EXISTS CUSTOMER_TYPES (
    CustomerTypeID VARCHAR(20) PRIMARY KEY,
    CustomerTypeName NVARCHAR(20),
    SurchargeRate FLOAT
);

CREATE TABLE IF NOT EXISTS RECEIPTS (
    RentalReceiptID VARCHAR(20) PRIMARY KEY,
    RoomID VARCHAR(20),
    CheckInDate DATETIME,
    CheckOutDate DATETIME,
    DailyRate FLOAT,
    PaymentStatus INT,
    FOREIGN KEY (RoomID) REFERENCES ROOMS(RoomID)
);

CREATE TABLE IF NOT EXISTS RENTAL_RECEIPT_DETAILS (
    CustomerID VARCHAR(20) PRIMARY KEY,
    RentalReceiptID VARCHAR(20),
    CustomerName NVARCHAR(30),
    Address NVARCHAR(50),
    IDNumber VARCHAR(20),
    CustomerTypeID VARCHAR(20),
    FOREIGN KEY (CustomerTypeID) REFERENCES CUSTOMER_TYPES(CustomerTypeID),
    FOREIGN KEY (RentalReceiptID) REFERENCES RECEIPTS(RentalReceiptID)
);

CREATE TABLE IF NOT EXISTS INVOICES (
    InvoiceID VARCHAR(20) PRIMARY KEY,
    CustomerName NVARCHAR(30),
    IssueDate DATETIME,
    PaymentDate DATETIME,
    TotalAmount FLOAT,
    PaymentStatus INT
);

CREATE TABLE IF NOT EXISTS INVOICE_DETAILS (
    InvoiceDetailID VARCHAR(20) PRIMARY KEY,
    InvoiceID VARCHAR(20),
    RentalReceiptID VARCHAR(20),
    RentalDays INT,
    Amount FLOAT,
    FOREIGN KEY (InvoiceID) REFERENCES INVOICES(InvoiceID),
    FOREIGN KEY (RentalReceiptID) REFERENCES RECEIPTS(RentalReceiptID)
);

CREATE TABLE IF NOT EXISTS SURCHARGE_RATES (
    ExtraGuestCount INT PRIMARY KEY,
    SurchargeRate FLOAT
);

CREATE TABLE IF NOT EXISTS REVENUES (
    Month INT,
    Year INT,
    RoomTypeID VARCHAR(20),
    RevenueAmount FLOAT,
    Rate FLOAT,
    PRIMARY KEY (Month, Year, RoomTypeID),
    FOREIGN KEY (RoomTypeID) REFERENCES ROOM_TYPES(RoomTypeID)
);

CREATE TABLE IF NOT EXISTS SETTINGS (
    SettingName VARCHAR(255) PRIMARY KEY,
    Value FLOAT
);

CREATE TABLE IF NOT EXISTS PERMISSIONS (
    PermissionID VARCHAR(20) PRIMARY KEY,
    PermissionName NVARCHAR(255),
    RoomManagement INT,
    RentalReceiptManagement INT,
    RoomLookup INT,
    InvoiceManagement INT,
    RevenueReport INT,
    UserManagement INT,
    RegulationManagement INT
);

CREATE TABLE IF NOT EXISTS USERS (
    Username VARCHAR(50) PRIMARY KEY,
    Password VARCHAR(50),
    FullName NVARCHAR(50),
    PermissionID VARCHAR(20),
    FOREIGN KEY (PermissionID) REFERENCES PERMISSIONS(PermissionID)
);

-- Insert sample data into tables
INSERT INTO SETTINGS (SettingName, Value) VALUES ('MaxGuestsPerRoom', 3);

INSERT INTO ROOM_TYPES (RoomTypeID, RoomTypeName, Price) VALUES ('RT1', 'A', 150000);
INSERT INTO ROOM_TYPES (RoomTypeID, RoomTypeName, Price) VALUES ('RT2', 'B', 170000);
INSERT INTO ROOM_TYPES (RoomTypeID, RoomTypeName, Price) VALUES ('RT3', 'C', 200000);

INSERT INTO CUSTOMER_TYPES (CustomerTypeID, CustomerTypeName, SurchargeRate) VALUES ('CT1', 'Domestic', 1.0);
INSERT INTO CUSTOMER_TYPES (CustomerTypeID, CustomerTypeName, SurchargeRate) VALUES ('CT2', 'International', 1.5);

INSERT INTO SURCHARGE_RATES (ExtraGuestCount, SurchargeRate) VALUES (1, 1);
INSERT INTO SURCHARGE_RATES (ExtraGuestCount, SurchargeRate) VALUES (2, 1);
INSERT INTO SURCHARGE_RATES (ExtraGuestCount, SurchargeRate) VALUES (3, 1.25);

INSERT INTO PERMISSIONS (PermissionID, PermissionName, RoomManagement, RentalReceiptManagement, RoomLookup, InvoiceManagement, RevenueReport, UserManagement, RegulationManagement) VALUES 
('PERMISSION1', 'Super Admin', 1, 1, 1, 1, 1, 1, 1),
('PERMISSION2', 'Director', 0, 0, 0, 1, 1, 0, 1),
('PERMISSION3', 'Manager', 1, 1, 1, 1, 1, 0, 1),
('PERMISSION4', 'Staff', 1, 1, 1, 1, 0, 0, 0);

INSERT INTO USERS (Username, Password, FullName, PermissionID) VALUES 
('superadmin@gmail.com', 'admin', 'Super Admin', 'PERMISSION1'),
('tinhvila@gmail.com', 'admin', 'Dang Tinh', 'PERMISSION2'),
('tinhpd@gmail.com', 'admin', 'Tinhvila', 'PERMISSION3'),
('pdtinh@gmail.com', 'admin', 'Tinh Pham', 'PERMISSION4');

-- Data validation queries
SELECT * FROM REVENUES;
UPDATE INVOICES SET PaymentStatus = 0 WHERE InvoiceID = 'INV2';
UPDATE REVENUES SET Rate = 1 WHERE RoomTypeID = 'RT1';
SELECT * FROM INVOICES;

INSERT INTO REVENUES (Month, Year, RoomTypeID, RevenueAmount, Rate) VALUES
(4, 2024, 'RT1', 0, 0),
(4, 2024, 'RT2', 0, 0),
(4, 2024, 'RT3', 0, 0),
(5, 2024, 'RT1', 0, 0),
(5, 2024, 'RT2', 0, 0),
(5, 2024, 'RT3', 0, 0),
(6, 2024, 'RT1', 0, 0),
(6, 2024, 'RT2', 0, 0),
(6, 2024, 'RT3', 0, 0),
(7, 2024, 'RT1', 0, 0),
(7, 2024, 'RT2', 0, 0),
(7, 2024, 'RT3', 0, 0),
(8, 2024, 'RT1', 0, 0),
(8, 2024, 'RT2', 0, 0),
(8, 2024, 'RT3', 0, 0);

-- Data validation queries
SELECT * FROM USERS;
SELECT * FROM PERMISSIONS;

SELECT * FROM PERMISSIONS WHERE PermissionID = 'PERMISSION1';

INSERT INTO USERS (Username, Password, FullName, PermissionID) VALUES 
('staff@gmail.com', 'admin', 'Staff', 'PERMISSION4');

SELECT * FROM ROOMS;

SELECT * FROM ROOM_TYPES;

INSERT INTO ROOMS (RoomID, RoomName, RoomTypeID, Note, Status) VALUES
('R001', 'Room A', 'RT1', 'Note for Room A', 0),
('R002', 'Room B', 'RT2', 'Note for Room B', 1),
('R003', 'Room C', 'RT1', 'Note for Room C', 0),
('R004', 'Room D', 'RT3', 'Note for Room D', 1),
('R005', 'Room E', 'RT2', 'Note for Room E', 0);
