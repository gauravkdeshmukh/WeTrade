select cust_email from customer 
where zip in 
(select zip from CUSTOMER
having count(zip) =
(select max(count(zip)) from customer 
group by zip)
group by zip);

create or replace view v11a as
select count(*) as totaltrades from CUSTOMER_TRADE;

create or replace view v11b as
select count(*) as tradesinsamezip from CUSTOMER_TRADE
where INITIATE_CUST_EMAIL in
(select cust_email from customer 
where zip in 
(select zip from CUSTOMER
having count(zip) =
(select max(count(zip)) from customer 
group by zip)
group by zip))
AND
ACCEPT_CUST_EMAIL in 
(
select cust_email from customer 
where zip in 
(select zip from CUSTOMER
having count(zip) =
(select max(count(zip)) from customer 
group by zip)
group by zip)
);

select ((TRADESINSAMEZIP/TOTALTRADES)*100) percenttrade,TOTALTRADES,TRADESINSAMEZIP from v11a,v11b;



