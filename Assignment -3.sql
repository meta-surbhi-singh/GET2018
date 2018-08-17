USE STORE_FRONT;

SELECT * FROM USER;

INSERT INTO SHIPPING_ADDRESS
VALUES (777,10,'m.i.road',302021,'jaipur','rajasthan');


SELECT * FROM SHIPPING_ADDRESS;

#ASSIGNMENT-2

#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT P.TITLE, COUNT(PC.Category_ID) AS NO_OF_CATEGORY
FROM PRODUCT P
JOIN PRODUCT_CATEGORY PC
ON P.ID = PC.Category_ID 
GROUP BY PC.Product_ID;

#Display Count of products as per below price range:

SELECT * FROM PRODUCT;

SELECT COUNT(*) AS PRICE_RANGE
FROM PRODUCT
GROUP BY CASE
WHEN PRICE BETWEEN 0 AND 100 THEN 'between_0_and_100'
WHEN PRICE BETWEEN 101 AND 500 THEN 'between_101_and_500'
WHEN PRICE BETWEEN 101 AND 500 THEN 'greater_than_500'
ELSE 'expensive'
END;


SELECT COUNT(*) AS PRICE_between_0_and_100
FROM PRODUCT
WHERE PRICE BETWEEN 0 AND 100;


SELECT COUNT(*) AS PRICE_between_101_and_500
FROM PRODUCT
WHERE PRICE BETWEEN 101 AND 500;


SELECT COUNT(*) AS PRICE_greater_than_500
FROM PRODUCT
WHERE PRICE > 500;

#Display the Categories along with number of products under each category.
SELECT C.TITLE , COUNT(PC.Product_ID)  AS NO_OF_PRODUCTS
FROM CATEGORY C
JOIN PRODUCT_CATEGORY PC
ON C.ID = PC.Category_ID 
GROUP BY Category_ID;

SELECT * FROM PRODUCT_CATEGORY;


#ASSGINMENT -3 

#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT U.ShopperID, U.Name, U.Date_of_birth , COUNT(O.ID) AS No_of_orders
FROM USER U
JOIN ORDERS O
ON U.ShopperID = O.Shopper_ID
WHERE O.Orders_Date > CURDATE()-30
GROUP BY U.ShopperID;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT U.ShopperID, U.Name ,SUM(O.BILL) AS REVENUE
FROM USER U
JOIN ORDERS O
ON U.ShopperID = O.Shopper_ID
WHERE O.Orders_Date > CURDATE()-30
GROUP BY U.ShopperID 
ORDER BY REVENUE DESC
LIMIT 10;


#Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT P.ID,P.TITLE, COUNT(O.ID) AS PRESENT_IN_NO_OF_ORDERS
FROM PRODUCT P
JOIN PRODUCT_ORDERS PO
ON P.ID = PO.Product_ID
JOIN ORDERS O
ON PO.Order_ID = O.ID
WHERE O.Orders_Date > CURDATE()-60
GROUP BY P.ID
ORDER BY COUNT(O.ID) DESC
LIMIT 20;

#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT MONTH(Orders_Date) AS MONTH , SUM(BILL) AS MONTHLY_REVENUE
FROM ORDERS
WHERE MONTH(Orders_Date) > MONTH(CURDATE()) - 6 
AND YEAR(Orders_Date) = YEAR(CURDATE())
GROUP BY MONTH
ORDER BY MONTH DESC;

# Mark the products as Inactive which are not ordered in last 90 days.
ALTER TABLE PRODUCT 
ADD Product_Status ENUM ('ACTIVE' ,'INACTIVE') DEFAULT 'ACTIVE'; 
DESC PRODUCT;
SELECT * FROM PRODUCT;

UPDATE PRODUCT
SET Product_Status = 'INACTIVE'
WHERE ID
NOT IN (SELECT PO.Product_ID
        FROM PRODUCT_ORDERS PO
        JOIN ORDERS O
        ON  PO.Order_ID = O.ID
        WHERE O.Orders_Date > CURDATE() - 90);
        
SELECT * FROM Product;


#Given a category search keyword, display all the Products present in this category/categories. 
SELECT P.TITLE
FROM PRODUCT P
JOIN PRODUCT_CATEGORY PC
ON P.ID = PC.Product_ID
JOIN CATEGORY C
ON PC.Category_ID = C.ID
WHERE C.Title = 'OTHERS';

#Display top 10 Items which were cancelled most.
SELECT P.TITLE
FROM PRODUCT P
JOIN PRODUCT_ORDERS PO
ON P.ID = PO.Product_ID
WHERE PO.Status = 'CANCELLED'
GROUP BY P.ID
LIMIT 10;

SELECT * FROM PRODUCT_ORDERS;


#ASSGINMENT -4

#Create appropriate tables and relationships for the ZIPCODE and write a SQL query for that returns a Resultset containing Zip Code, City Names and States ordered by State Name and City Name.

CREATE TABLE ZIPCODE (Zipcode BIGINT ,
                      City VARCHAR(50),
                      State VARCHAR(50),
                      PRIMARY KEY (Zipcode)
                      );

SELECT * FROM ZIPCODE;

INSERT INTO ZIPCODE
VALUES (302022, 'Jaipur','Rajasthan'),
       (342122, 'Jodhpur','Rajasthan'),
       (313001, 'Udaipur','Rajasthan');

SELECT * FROM ZIPCODE;

ALTER TABLE SHIPPING_ADDRESS
DROP City;

ALTER TABLE SHIPPING_ADDRESS
DROP State;

ALTER TABLE SHIPPING_ADDRESS 
ADD FOREIGN KEY (Pincode) REFERENCES ZIPCODE(Zipcode);

SELECT * FROM SHIPPING_ADDRESS;

#ASSIGNMENT- 5

#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
CREATE VIEW ORDERED_ITEMS
AS
SELECT P.ID AS ID , P.TITLE AS PRODUCT_NAME, U.Name AS SHOPPER_NAME, O.Orders_Date AS ORDERED_ON , PO.Status AS STATUS
FROM PRODUCT P
JOIN PRODUCT_ORDERS PO
ON P.ID = PO.Product_ID
JOIN ORDERS O
ON PO.Order_ID = O.ID
JOIN USER U
ON O.Shopper_ID = U.ShopperID;

SELECT * FROM ORDERED_ITEMS;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.

SELECT ID, PRODUCT_NAME
FROM ORDERED_ITEMS
WHERE STATUS = 'SHIPPED';

#Use the above view to display the top 5 most selling products

SELECT ID, PRODUCT_NAME 
FROM ORDERED_ITEMS
GROUP BY ID
LIMIT 5;


