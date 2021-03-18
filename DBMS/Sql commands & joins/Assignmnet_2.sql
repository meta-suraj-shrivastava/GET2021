
/*
inserting values in user table 
*/
insert into user(name,contactNo,email,DOB,admin) values("suraj shrivastava",9772217746,"srj@gmail.com","1999-05-22",false);
insert into user(name,contactNo,email,DOB,admin) values("khushi shrivastava",797723757,"khus@gmail.com","2001-08-05",false);
insert into user(name,contactNo,email,DOB,admin) values("kiran shrivastava",7337289333,"kiran@gmail.com","1960-05-16",false);
insert into user(name,contactNo,email,DOB,admin) values("ashok shrivastava",7878776665,"ash@gmail.com","1970-03-04",false);
insert into user(name,contactNo,email,DOB,admin) values("Ananya bisht",4356767456,"anb@gmail.com","1999-02-07",false);
insert into user(name,contactNo,email,DOB,admin) values("rishabh khadelwal",4556576390,"rishi@gmail.com","1998-10-07",false);
insert into user(name,contactNo,email,DOB,admin) values("saloni jain",9787654678,"saloni@gmail.com","1999-07-30",false);
insert into user(name,contactNo,email,DOB,admin) values("swati pancholi",9876654542,"swati@gmail.com","1999-12-11",false);



/*
inserting values in categories and childcategories table 
*/
insert into categories(categoryName) values("mobile");
insert into categories(categoryName,parentCatId) values("smartphone",1);
insert into categories(categoryName,parentCatId) values("keypad",1);
insert into categories(categoryName) values("grocery");
insert into categories(categoryName,parentCatId) values("vegetables & fruits",4);
insert into categories(categoryName,parentCatId) values("pules",4);
insert into categories(categoryName,parentCatId) values("soaps",4);
insert into categories(categoryName,parentCatId) values("spices",4);
insert into categories(categoryName) values("gadgets");
insert into categories(categoryName,parentCatId) values("smartwatches & bands",9);
insert into categories(categoryName,parentCatId) values("speakers",9);
insert into categories(categoryName,parentCatId) values("headphones",9);
insert into categories(categoryName,parentCatId) values("tablets",9);
insert into categories(categoryName) values("cosmetics");

/*
inserting values in products table 
*/
insert into products(name,price,description,quantity) values("I-Phone 12",90000,"designed by apple in california",12);
insert into products(name,price,description,quantity) values("One plus 9",49000,"get your oxygen now",2);
insert into products(name,price,description,quantity) values("Nokia 310",2500,"No to smartphones",120);
insert into products(name,price,description,quantity) values("Loki",23,"health",560);
insert into products(name,price,description,quantity) values("Potato",15,"health",250);
insert into products(name,price,description,quantity) values("mango",45,"health",560);
insert into products(name,price,description,quantity) values("watermelon",30,"health",50);
insert into products(name,price,description,quantity) values("Mi Band",2400,"monitor health",560);
insert into products(name,price,description,quantity) values("JBL",98000,"feel the music",160);
insert into products(name,price,description,quantity) values("Sony 12XT",2400,"live the music",12);
insert into products(name,price,description,quantity) values("Samsung Tab 12",18000,"make your work easy",139);
insert into products(name,price,description,quantity) values("Lipstick",1200,"be confident",50);
insert into products(name,price,description,quantity) values("Eye Liner",1800,"see the world with your beautiful eyes",60);
insert into products(name,price,description,quantity) values("Kajal",200,"be classic like black",590);
insert into products(name,price,description,quantity) values("powder",260,"smell go away",590);

/*Inserting product categories*/
insert into productCategory values(1,1);
insert into productCategory values(1,2);
insert into productCategory values(2,1);
insert into productCategory values(2,2);
insert into productCategory values(3,1);
insert into productCategory values(3,3);
insert into productCategory values(4,4);
insert into productCategory values(4,5);
insert into productCategory values(5,4);
insert into productCategory values(5,5);
insert into productCategory values(6,4);
insert into productCategory values(6,5);
insert into productCategory values(7,4);
insert into productCategory values(7,5);
insert into productCategory values(8,9);
insert into productCategory values(8,10);
insert into productCategory values(9,9);
insert into productCategory values(9,11);
insert into productCategory values(10,9);
insert into productCategory values(10,12);
insert into productCategory values(11,9);
insert into productCategory values(11,13);
insert into productCategory values(12,14);
insert into productCategory values(13,14);
insert into productCategory values(14,14);
insert into productCategory values(15,14);



/*
inserting values in orders table 
*/
select * from categories;
insert into orders(userID,orderTotal) values(1,78000);
insert into orders(userID,orderTotal) values(1,2000);
insert into orders(userID,orderTotal) values(1,30000);
insert into orders(userID,orderTotal) values(4,12000);
insert into orders(userID,orderTotal) values(5,1700);
insert into orders(userID,orderTotal) values(5,60000);

insert into orders(userID,orderTotal) values(4,6000);
insert into orders(userID,orderTotal) values(2,1000);
insert into orders(userID,orderTotal) values(2,15000);
insert into orders(userID,orderTotal) values(3,4000);
insert into orders(userID,orderTotal) values(3,200);
insert into orders(userID,orderTotal) values(6,7000);


/*
inserting values in orderdetails table 
*/
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(1,true,false,false,2);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(1,false,false,false,11);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(2,true,false,false,13);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(2,false,false,false,14);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(3,true,false,false,10);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(3,false,false,false,11);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(3,false,false,false,12);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(4,true,false,false,5);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(5,false,false,false,7);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(6,true,false,false,12);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(6,true,false,false,4);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(6,false,false,false,6);

insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(7,false,false,false,2);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(8,false,false,false,4);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(9,false,false,false,1);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(10,false,false,false,2);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(11,false,false,false,4);
insert into orderdetails(orderID,shipped,cancelled,returned,productID) values(12,false,false,false,8);


/*
return product details and their categories which are in stock and sorted by their adding time.
*/
select 
    p.productId, p.name, c.categoryName, p.price
from
    products p,
    categories c
where
    p.categoryID = c.categoryID and p.quantity > 0
order by p.addedOn desc;


/*
return the list of the products who don't have any image
*/
select 
    *
from
    products p
where
    p.productID not in (select 
        productID
    from
        images); 
        
 
/*
return the all the categories and group them and sorted them up with parent category 
*/
 
select 
    child.categoryId, child.categoryName as child_category,parent.categoryName as parent_category
from
    categories parent inner join categories child
    on
    parent.categoryId = child.parentCatId
order by parent_category asc;

/*
return the list of categories who don't have any child categories
*/

select 
    c.categoryName
from
    categories c where c.categoryId not in
    (select 
        parentCatId as categoryId
    from
        categories where parentCatId is not null) and c.parentCatId is null;

/*
return the list of the products who lies in the mobile category
*/
select 
    p.name, p.price, p.description
from
    products p,categories c
where
    p.categoryId = c.categoryId and c.parentCatId in (select 
        categoryId
    from
        categories
    where
        categories.categoryName = 'mobile');


/*
return the list of the products whose quantity is less the 50
*/
select 
    name, quantity
from
    products
where
    products.quantity < 50;

