
use eCommerce;
/*
return the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
*/
select p.productId,p.name,count(p.categoryId) as count from products p group by p.name;


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
    c.categoryName, count(c.categoryName) as NoOfProducts
from
    products p
        right join
    categories c ON c.categoryId = p.categoryId
group by c.categoryName  ;