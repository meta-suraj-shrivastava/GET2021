/*
return latest 50 orders
*/

select 
    orderID, orderDate, orderTotal
from
    orders order by orderDate desc limit 50;

/*
return 10 most expensive orders
*/
select 
    *
from
    orders
order by orderTotal desc
limit 10;


/*
return all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
*/
select 
    o.orderID, o.orderDate
from
    orders o,
    orderdetails od
where
    o.orderId = od.orderID and DATEDIFF(o.orderDate, now()) > 10 and od.shipped = 0  ;



/*
return list of shoppers which haven't ordered anything since last month
*/
select 
    user.userID, user.name
from
    orders left join user
on user.userID = orders.userID and DATEDIFF(orders.orderDate, now()) > 30;


/*
Display list of shopper along with orders placed by them in last 15 days.
*/

select 
    u.userID, u.name, o.orderID,p.name
from
    user u,
    orders o,
    orderdetails od, products p
where
    u.userID = o.userID and od.orderID = o.orderID and p.productID = od.productID and DATEDIFF(o.orderDate, now()) <= 15; 


/*
Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))

*/
select 
    p.name
from
    products p,
    orderdetails od
where
    od.productID = p.productID and od.shipped = true and od.orderID = 6;
    
/*
Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
*/
select 
    p.name, o.orderDate
from
    products p,
    orders o,
    orderdetails od
where
    od.productID = p.productID and o.orderID = od.orderID and p.price between 20 and 50;   