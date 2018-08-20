USE STORE_FRONT;
#Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION NO_OF_ORDERS(month_no INTEGER, year_no INTEGER) RETURNS INTEGER
NOT DETERMINISTIC
BEGIN
DECLARE NUM INTEGER;
SELECT COUNT(ID) INTO NUM FROM ORDERS
WHERE MONTH(Orders_Date) = month_no
AND YEAR(Orders_Date) = year_no;
RETURN (NUM);
END$$

SELECT NO_OF_ORDERS(8,2018);

#Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$
CREATE FUNCTION MAX_ORDERS(year_no INTEGER) RETURNS INTEGER
NOT DETERMINISTIC
BEGIN
DECLARE month_no INTEGER;
DECLARE NUM INTEGER;
SELECT MONTH(Orders_Date) INTO month_no FROM ORDERS
WHERE YEAR(Orders_Date) = year_no
AND COUNT(ID) = MAX(SELECT COUNT(ID) INTO NUM FROM ORDERS
GROUP BY MONTH(Orders_Date);)
GROUP BY MONTH(Orders_Date);
RETURN (month_no);
END$$

DROP FUNCTION MAX_ORDERS;



#Create a Stored procedure to retrieve average sales of each product in a month. 
#Month and year will be input parameter to function.
DELIMITER $$
CREATE PROCEDURE AVERAGE_SALE(month_no INTEGER, year_no INTEGER)

SELECT P.ID, AVG(P.PRICE * PO.Quantity_ordered)
FROM PRODUCT P
JOIN PRODUCT_ORDERS PO
ON P.ID = PO.Product_ID
JOIN ORDERS O
ON PO.Product_ID = O.ID
WHERE MONTH(O.Orders_Date) = month_no
AND YEAR(O.Orders_Date) = year_no
GROUP BY P.ID;

CALL AVERAGE_SALE(02,2016);

SELECT * FROM ORDERS;

DROP PROCEDURE AVERAGE_SALE;
#Create a stored procedure to retrieve table having order detail with status for a given period. 
#Start date and end date will be input parameter. 
#Put validation on input dates like start date is less than end date.
#If start date is greater than end date take first date of month as start date.
DELIMITER $$
CREATE PROCEDURE STORE_FRONT.ORDER_DETAIL(start_date DATE, end_date DATE)
BEGIN
IF start_date > end_date
THEN
SELECT ADDDATE(start_date, INTERVAL DAY(start_date) DAY) INTO start_date;
END IF;
SELECT ID, Shopper_ID, Orders_Date , Status 
FROM ORDERS
WHERE Orders_Date BETWEEN start_date AND end_date;
END$$

CALL ORDER_DETAIL('2018-02-12', '2018-11-19');

DROP PROCEDURE ORDER_DETAIL;