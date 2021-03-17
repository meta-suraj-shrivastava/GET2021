select 
    user.*, count(user.userId) as NoOfOrders
from
    user
        inner join
    orders ON user.userId = orders.userId
where
    DATEDIFF(orders.orderDate, now()) < 30
group by user.userId;

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


