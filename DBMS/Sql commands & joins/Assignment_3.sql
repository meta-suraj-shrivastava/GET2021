select orderID,orderDate,orderTotal from orders where orderID <= 50;


select * from orders order by orderTotal desc limit 10;