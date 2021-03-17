use ecommerce;


/*
Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
with latest ordered items should be displayed first for last 60 days.
*/
CREATE VIEW order_info as 
select 
    p.productId,
    p.name as product_name,
    p.price,
    u.name as user_name,
    u.email,
    o.orderDate,
    case
        when od.shipped = 1 then 'shipped'
        else 'processed'
    end as order_status
from
    products p,
    user u,
    orders o,
    orderdetails od
where
    o.orderId = od.orderId and od.productId = p.productId and o.userId = u.userId and DATEDIFF(o.orderDate,now())<60 
    order by o.orderDate desc;
    
 
/*
Displaying the whole view
*/ 
select 
    *
from
    order_info ;


/*
return the Products(Items) which are in ‘shipped’ state.
*/
select 
    *
from
    order_info oi
where
    oi.order_status = 'shipped';



/*
return top 4 most selling products.
*/
select 
    oi.product_name, count(oi.product_name) as count
from
    order_info oi
group by oi.product_name
order by count desc
limit 4;