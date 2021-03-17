/*
return Shopper’s information along with number of orders he/she placed during last 30 days.
*/

select 
    user.*, count(user.userId) as NoOfOrders
from
    user
        inner join
    orders ON user.userId = orders.userId
where
    DATEDIFF(orders.orderDate, now()) < 30
group by user.userId;


/*
return the top 10 Shoppers who generated maximum number of revenue in last 30 days.
*/
select 
    user.name
from
    user
        inner join
    (select 
        orders.userId
    from
        orders
    where
        DATEDIFF(orders.orderDate, now()) < 30
    group by orders.userID
    order by orders.orderTotal desc
    limit 10) as result ON user.userId = result.userId;
    

/* retrun top 20 Products which are ordered most in last 60 days along with numbers.
*/
select 
    p.name, r.noOfOrders
from
    products p
        inner join
    (select 
        od.productId, count(od.productId) as noOfOrders
    from
        orderdetails od,orders o
    where od.orderId = o.orderId and
        DATEDIFF(o.orderDate, now()) < 60
    group by od.productId) as r ON p.productId = r.productId
order by r.noOfOrders desc
limit 20;

/*return Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.*/
select
case
when result.month = 3 then 'march'
else 'no'
end as month, result.revenue
from (select EXTRACT(MONTH from o.orderDate) as month,sum(o.orderTotal) as revenue  from orders o  group by month) as result;


/*Mark the products as Inactive which are not ordered in last 90 days. */
select p.name,
        case 
            when DATEDIFF(result.orderDate,now()) > 90 then 'inactive' 
            else 'active' 
            end as status 
            from products p left join (
            select o.orderDate , od.productId 
            from orderdetails od, orders o 
            where o.orderId = od.orderId) as result 
            on result.productId = p.productId;


/*Given a category search keyword, display all the Products present in this category/categories. */
select 
    p.name, p.price, p.description
from
    products p,categories c
where
    p.categoryId = c.categoryId and c.parentCatId in (select 
        pc.parentCatId
    from
        parentCategories pc
    where
        pc.parentCategoryName = 'mobile');
        
/*return the top 10 Items which were cancelled most.*/    
select 
    p.name
from
    products p
        inner join
    (select 
        od.productId, count(od.productId) as count
    from
        orderdetails od
    where
        od.cancelled = 1
    group by od.productId) as r
where
    r.productId = p.productId
order by r.count desc
limit 10;

