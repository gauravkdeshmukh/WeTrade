create or replace view v8 as
select TRAN_INV_ITEM_EMAIL, TRAN_INV_ITEM_NO from TRANS_INVOLVE_ITEM
where (TRAN_INV_ITEM_EMAIL, TRAN_INV_TRANS_ID) IN
(SELECT CUST_TRANS_EMAIL, GEN_TRANS_ID from CUST_GENERATE_TRANS where GEN_TRANS_ID in (
select TRANS_ID from TRANSACTION where TYPE = 'IT'));

create or replace view v8a as
select TRADE_ACCEPT_CUST_EMAIL, TRADE_ACCEPT_ITEM_NO from CUSTOMER_TRADE_ITEM
WHERE (TRADE_ITEM_EMAIL, TRADE_ITEM_NO) IN (
select TRAN_INV_ITEM_EMAIL, TRAN_INV_ITEM_NO from TRANS_INVOLVE_ITEM
where (TRAN_INV_ITEM_EMAIL, TRAN_INV_TRANS_ID) IN
(SELECT CUST_TRANS_EMAIL, GEN_TRANS_ID from CUST_GENERATE_TRANS where GEN_TRANS_ID in (
select TRANS_ID from TRANSACTION where TYPE = 'IT')));

create or replace view v8b as
SELECT CUST_TRANS_EMAIL, count(*) as No_of_Trade from CUST_GENERATE_TRANS where GEN_TRANS_ID in (
select TRANS_ID from TRANSACTION where TYPE = 'AT') OR GEN_TRANS_ID in (
select TRANS_ID from TRANSACTION where TYPE = 'IT')
group by CUST_TRANS_EMAIL;

create or replace view v8c as
select TRAN_INV_ITEM_EMAIL, COUNT(*) as tot_item1 from v8
group by TRAN_INV_ITEM_EMAIL;

create or replace view v8d as
select TRADE_ACCEPT_CUST_EMAIL, COUNT(*) as tot_item2 from v8a
group by TRADE_ACCEPT_CUST_EMAIL;

create or replace view v8e as
SELECT CUST_EMAIL, 0 as No_of_Trade from CUSTOMER
where CUST_EMAIL not in (select CUST_TRANS_EMAIL from v8b)
UNION
SELECT * from v8b;

create or replace view v8f as
SELECT CUST_EMAIL, 0 as No_of_Items1 from CUSTOMER
where CUST_EMAIL not in (select TRAN_INV_ITEM_EMAIL from v8c)
UNION
SELECT * from v8c;

create or replace view v8g as
SELECT CUST_EMAIL, 0 as No_of_Items2 from CUSTOMER
where CUST_EMAIL not in (select TRADE_ACCEPT_CUST_EMAIL from v8d)
UNION
SELECT * from v8d;

create or replace view v8h as
select v8f.CUST_EMAIL, (v8f.No_of_Items1 + v8g.No_of_Items2) as No_of_Items from
v8f, v8g
where v8f.CUST_EMAIL = v8g.CUST_EMAIL;

create or replace view v8i as
select concat(concat(FIRST_NAME,MIDDLE_INITIALS),LAST_NAME) as FULL_NAME, No_of_Trade, No_of_Items
from  CUSTOMER, v8e, v8h
where CUSTOMER.CUST_EMAIL = v8e.CUST_EMAIL and v8e.CUST_EMAIL = v8h.CUST_EMAIL 
order by No_of_Trade desc;

select FULL_NAME, Trades, Items from
((select FULL_NAME, ('' || No_of_Trade) as Trades, ('' || No_of_Items) as Items, 0 as priority from v8i)
UNION
(select null, ('Total trades = ' || sum(No_of_Trade)) as Trades, ('Total items = ' || sum(No_of_Items))as Items, 1 as priority
from v8i))
order by priority, Trades desc;