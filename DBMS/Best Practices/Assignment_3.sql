
/*creating index for the most used column in these three tables*/
create index productId_index on  products(productId);
create index order_index on orders(orderId,orderDate);
create index category_index on categories(categoryId,parentCatId);
