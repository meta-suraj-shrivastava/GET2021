/*
 retrieve average sales of each product in a month
 @param-month and year
*/
delimiter $$
create procedure avg_sale(month int,year int)
    begin
select 
    od.productId, p.name, count(od.productId)/30
from
    orders o,
    orderdetails od,
    products p
where
    o.orderId = od.orderId and od.productId = p.productId and extract(MONTH from o.orderDate) = month and extract(YEAR from o.orderDate) = year group by od.productId;
    end$$

delimiter ;
/*
call the procedure
*/
call avg_sale(3,2021);



/*
retrieve table having order detail with status for a given period
@param - start_date and end_date in 'YYYY-MM-DD' format
*/
delimiter $$
create procedure order_details(start_date date,end_date date)
begin
select p.productId,p.name,case when od.shipped = 1 then 'shipped'
when od.cancelled = 1 then 'cancelled'
when od.returned = 1 then 'returned'
else 'processed'
end as status from orders o,orderdetails od,products p where o.orderId = od.orderId and p.productId = od.productId and case
when start_date > end_date then date(o.orderDate) between start_date-DAY(start_date)+1 and end_date
else date(o.orderDate) between start_date and end_date
end;
end$$
delimiter ;



/*
call the procedure
*/
call order_details('2021-03-15','2021-03-17');
