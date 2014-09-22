create or replace view v7 as
select TRAN_INV_ITEM_EMAIL,TRAN_INV_ITEM_NO from TRANS_INVOLVE_ITEM
where (TRAN_INV_ITEM_EMAIL, TRAN_INV_TRANS_ID) IN
(SELECT CUST_TRANS_EMAIL, GEN_TRANS_ID from CUST_GENERATE_TRANS where GEN_TRANS_ID in (
select TRANS_ID from TRANSACTION where TYPE = 'SI'));

create or replace view v7a as
SELECT CUST_TRANS_EMAIL, count(*) as Items_Sold from CUST_GENERATE_TRANS where GEN_TRANS_ID in (
select TRANS_ID from TRANSACTION where TYPE = 'SI')
group by CUST_TRANS_EMAIL;

create or replace view v7b as
select ITEM_EMAIL, SUM(tot_cost) as TOTAL_COST from
(select ITEM_EMAIL, ITEM_NO, SUM(PRICE) as tot_cost from ITEM WHERE (ITEM_EMAIL, ITEM_NO) IN (select * from v7)
group by ITEM_EMAIL, ITEM_NO)
group by ITEM_EMAIL;

create or replace view v7c as
SELECT TRAN_INV_ITEM_EMAIL, AVG(avg_rat) as Avg_Rating from
(SELECT TRAN_INV_ITEM_EMAIL,TRAN_INV_ITEM_NO, AVG(RATING) as avg_rat from PLATINUM, v7, CLASSCUST_REVIEW_ITEM
where PLATINUM_EMAIL = CLASS_EMAIL_REVITEM and ITEM_EMAIL_REVITEM = TRAN_INV_ITEM_EMAIL and ITEM_NO_REVITEM = TRAN_INV_ITEM_NO
group by TRAN_INV_ITEM_EMAIL,TRAN_INV_ITEM_NO)
group by TRAN_INV_ITEM_EMAIL;

create or replace view v7d as
SELECT CUST_EMAIL, 0 as Avg_Rating from CUSTOMER
where CUST_EMAIL not in (select TRAN_INV_ITEM_EMAIL from v7c)
UNION
SELECT * from v7c;

create or replace view v7e as
SELECT CUST_EMAIL, 0 as Total_Cost from CUSTOMER
where CUST_EMAIL not in (select ITEM_EMAIL from v7b)
UNION
SELECT * from v7b;

create or replace view v7f as
SELECT CUST_EMAIL, 0 as Items_Sold from CUSTOMER
where CUST_EMAIL not in (select CUST_TRANS_EMAIL from v7a)
UNION
SELECT * from v7a;

create or replace view v7g as
select concat(concat(FIRST_NAME,MIDDLE_INITIALS),LAST_NAME) as FULL_NAME, Items_Sold, TOTAL_COST, Avg_Rating
from  CUSTOMER, v7d, v7e, v7f
where CUSTOMER.CUST_EMAIL = v7d.CUST_EMAIL and v7d.CUST_EMAIL = v7e.CUST_EMAIL and v7e.CUST_EMAIL = v7f.CUST_EMAIL
order by Items_Sold desc;

select FULL_NAME, Items, Costs, Avg_Rating from
((select FULL_NAME, ('' || Items_Sold) as Items, ('' || TOTAL_COST) as Costs, Avg_Rating, 0 as priority from v7g)
UNION
(select null, ('Total items = ' || sum(Items_Sold)) as Items, ('Total cost = ' || sum(TOTAL_COST))as Costs, null, 1 as priority
from v7g))
order by priority, Items desc;
