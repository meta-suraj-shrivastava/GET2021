insert into user(name,contactNo,email,DOB,admin) values("suraj shrivastava",9772217746,"srj@gmail.com","1999-05-22",false);

insert into user(name,contactNo,email,DOB,admin) values("khushi shrivastava",797723757,"khus@gmail.com","2001-08-05",false);

insert into user(name,contactNo,email,DOB,admin) values("kiran shrivastava",7337289333,"kiran@gmail.com","1960-05-16",false);

insert into user(name,contactNo,email,DOB,admin) values("ashok shrivastava",7878776665,"ash@gmail.com","1970-03-04",false);

insert into user(name,contactNo,email,DOB,admin) values("Ananya bisht",4356767456,"anb@gmail.com","1999-02-07",false);

insert into user(name,contactNo,email,DOB,admin) values("rishabh khadelwal",4556576390,"rishi@gmail.com","1998-10-07",false);

insert into user(name,contactNo,email,DOB,admin) values("saloni jain",9787654678,"saloni@gmail.com","1999-07-30",false);

insert into user(name,contactNo,email,DOB,admin) values("swati pancholi",9876654542,"swati@gmail.com","1999-12-11",false);

insert into categories(categoryName,parent) values("mobile",true);
insert into childcategories values(1,"smartphone");
insert into childcategories values(1,"keypad");
insert into categories(categoryName,parent) values("grocery",true);
insert into childcategories values(2,"vegetables & fruits");
insert into childcategories values(2,"pules");
insert into childcategories values(2,"soaps");
insert into childcategories values(2,"spices");
insert into categories(categoryName,parent) values("gadgets",true);
insert into childcategories values(3,"smartwatches & bands");
insert into childcategories values(3,"speakers");
insert into childcategories values(3,"headphones");
insert into childcategories values(3,"tablets");
insert into categories(categoryName,parent) values("cosmetics",false);


insert into products(name,price,description,quantity,categoryID) values("I-Phone 12",90000,"designed by apple in california",12,1);
insert into products(name,price,description,quantity,categoryID) values("One plus 9",49000,"get your oxygen now",2,1);
insert into products(name,price,description,quantity,categoryID) values("Nokia 310",2500,"No to smartphones",120,1);
insert into products(name,price,description,quantity,categoryID) values("Loki",23,"health",560,2);
insert into products(name,price,description,quantity,categoryID) values("Potato",15,"health",250,2);
insert into products(name,price,description,quantity,categoryID) values("mango",45,"health",560,2);
insert into products(name,price,description,quantity,categoryID) values("watermelon",30,"health",50,2);
insert into products(name,price,description,quantity,categoryID) values("Mi Band",2400,"monitor health",560,3);
insert into products(name,price,description,quantity,categoryID) values("JBL",98000,"feel the music",160,3);
insert into products(name,price,description,quantity,categoryID) values("Sony 12XT",2400,"live the music",12,3);
insert into products(name,price,description,quantity,categoryID) values("Samsung Tab 12",18000,"make your work easy",139,3);
insert into products(name,price,description,quantity,categoryID) values("Lipstick",1200,"be confident",50,4);
insert into products(name,price,description,quantity,categoryID) values("Eye Liner",1800,"see the world with your beautiful eyes",60,4);
insert into products(name,price,description,quantity,categoryID) values("Kajal",200,"be classic like black",590,4);
insert into products(name,price,description,quantity,categoryID) values("powder",260,"smell go away",590,4);


insert into orders(userID,orderTotal) values(1,78000);
insert into orders(userID,orderTotal) values(1,2000);
insert into orders(userID,orderTotal) values(1,30000);
insert into orders(userID,orderTotal) values(4,12000);
insert into orders(userID,orderTotal) values(5,1700);
insert into orders(userID,orderTotal) values(5,60000);

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


select 
    p.productId, p.name, c.categoryName, p.price
from
    products p,
    categories c
where
    p.categoryID = c.categoryID and p.quantity > 0
order by p.addedOn desc;

select 
    *
from
    products p
where
    p.productID not in (select 
        productID
    from
        images); 

