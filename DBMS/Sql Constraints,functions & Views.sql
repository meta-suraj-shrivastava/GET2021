
use eCommerce;
select 
  case 
    when price between 0 and 100 then '0-100'
    when price between 101 and 500 then '101-500'
    else 'above 500'
  end as `Range in rs`,
  count(1) as `Count`
from products
group by `Range in rs`;