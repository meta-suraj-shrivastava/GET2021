/*
return number of orders in a month
@param - month:int,year:int
*/
delimiter $$
CREATE FUNCTION no_of_order(month int,year int)
       RETURNS int 
BEGIN
        DECLARE total_orders integer;

select 
    count(orderId) into total_orders
from
    orders
where
    extract(MONTH from orders.orderDate) = month and extract(YEAR from orders.orderDate) = year;

        RETURN total_orders;
END$$
delimiter ;


/*
call the function
*/
select  no_of_order(3,2021) as total_orders ;




/*
return month in a year having maximum orders
@param - year:int
*/
delimiter $$
CREATE FUNCTION max_sale_month(year int)
       RETURNS int 
BEGIN
        DECLARE max_month integer;

select 
    result.month into max_month
from
    (select 
    EXTRACT(MONTH FROM orderDate) as month, count(EXTRACT(MONTH FROM orderDate)) as count
from
    orders
where
    extract(YEAR FROM orders.orderDate) = year
group by month order by count limit 1) as result;

        RETURN max_month;
END$$
delimiter ;

/*
call the function
*/
select max_sale_month(2021) as max_orders_month;
