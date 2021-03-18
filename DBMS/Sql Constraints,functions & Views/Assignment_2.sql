
use eCommerce;
/*
return the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
*/
select 
    p.productId, p.name, result.category_count
from
    products p
        inner join (select productId,count(categoryId) as category_count from
    productCategory group by productId) as result on p.productId = result.productId and result.category_count > 1;


/*
Count of products as per below price range
return the Count of products as per below price range:
Range in Rs.  Count
0 - 100
101 - 500
Above 500
*/
select 
  case 
    when price between 0 and 100 then '0-100'
    when price between 101 and 500 then '101-500'
    else 'above 500'
  end as `Range in rs`,
  count(1) as `Count`
from products
group by `Range in rs`;



/*
return the Categories along with number of products under each category
*/
select 
    c.categoryName, result.No_of_products
from
    categories c
        inner join
    (select 
        pc.categoryId, count(p.productId) as No_of_products
    from
        productCategory pc
    inner join products p ON pc.productId = p.productId group by pc.categoryId) as result ON c.categoryId = result.categoryId;