create or replace view v13 as 
select TRADE_ITEM_EMAIL, TRADE_ACCEPT_CUST_EMAIL, count(*) as Trade_Count 
from CUSTOMER_TRADE_ITEM
group by TRADE_ITEM_EMAIL, TRADE_ACCEPT_CUST_EMAIL;

create or replace view v13a as
select t1.TRADE_ITEM_EMAIL, t1.TRADE_ACCEPT_CUST_EMAIL, t1.Trade_Count from v13 t1,v13 t2
where t1.TRADE_ITEM_EMAIL = t2.TRADE_ACCEPT_CUST_EMAIL and t1.TRADE_ACCEPT_CUST_EMAIL = t2.TRADE_ITEM_EMAIL;

create or replace view v13b as 
select ROWNUM as row_num, TRADE_ITEM_EMAIL, TRADE_ACCEPT_CUST_EMAIL, Trade_Count from v13a;

create or replace view v13c as 
select  TRADE_ITEM_EMAIL, TRADE_ACCEPT_CUST_EMAIL, Trade_Count from v13b where  mod(row_num,2) = 1;

create or replace view v13d as 
select TRADE_ACCEPT_CUST_EMAIL, TRADE_ITEM_EMAIL, Trade_Count  from v13b where  mod(row_num,2) = 0;

create or replace view v13e as 
select v13c.TRADE_ACCEPT_CUST_EMAIL, v13c.TRADE_ITEM_EMAIL, v13c.Trade_Count + v13d.Trade_Count as Max_Trade from v13c,v13d
where v13c.TRADE_ACCEPT_CUST_EMAIL = v13d.TRADE_ITEM_EMAIL and v13c.TRADE_ITEM_EMAIL = v13d.TRADE_ACCEPT_CUST_EMAIL;

create or replace view v13f as
select TRADE_ACCEPT_CUST_EMAIL, TRADE_ITEM_EMAIL from v13e where Max_Trade = (select Max(Max_Trade) from v13e);

(select ROWNUM, concat(FIRST_NAME,LAST_NAME) || ' -> ' as CUSTOMER1 from CUSTOMER where CUST_EMAIL in (select TRADE_ACCEPT_CUST_EMAIL FROM v13f));
(select ROWNUM, ' -> ' || concat(FIRST_NAME,LAST_NAME) as CUSTOMER2 from CUSTOMER where CUST_EMAIL in (select TRADE_ITEM_EMAIL FROM v13f));

--create or replace view v13e as 
--select TRADE_ACCEPT_CUST_EMAIL, TRADE_ITEM_EMAIL, count(*) as Trade_Count from 
--(select TRADE_ITEM_EMAIL,TRADE_ACCEPT_CUST_EMAIL, 1 as Id from v13c 
--UNION select TRADE_ACCEPT_CUST_EMAIL, TRADE_ITEM_EMAIL, 2 as Id from v13d) group by TRADE_ACCEPT_CUST_EMAIL, TRADE_ITEM_EMAIL;


