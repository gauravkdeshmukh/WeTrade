create or replace view v22 as
select TRAN_INV_ITEM_EMAIL,TRAN_INV_ITEM_NO from TRANS_INVOLVE_ITEM
where (TRAN_INV_ITEM_EMAIL, TRAN_INV_TRANS_ID) IN
(SELECT CUST_TRANS_EMAIL, GEN_TRANS_ID from CUST_GENERATE_TRANS where GEN_TRANS_ID in (
select TRANS_ID from TRANSACTION where TYPE = 'SI'));

create or replace view v22 as
select MAX(Items_Sold) as Max_Sold_Plat from
(SELECT PLATINUM_EMAIL, Items_Sold FROM PLATINUM,
(SELECT CUST_TRANS_EMAIL, count(*) as Items_Sold from CUST_GENERATE_TRANS where GEN_TRANS_ID in (
select TRANS_ID from TRANSACTION where TYPE = 'SI')
group by CUST_TRANS_EMAIL)
where PLATINUM_EMAIL = CUST_TRANS_EMAIL);

create or replace view v22a as
SELECT GOLD_EMAIL, Items_Sold FROM GOLD,
(SELECT CUST_TRANS_EMAIL, count(*) as Items_Sold from CUST_GENERATE_TRANS where GEN_TRANS_ID in (
select TRANS_ID from TRANSACTION where TYPE = 'SI')
group by CUST_TRANS_EMAIL)
where GOLD_EMAIL = CUST_TRANS_EMAIL;

select * from CLASSIFIED_CUSTOMER;

update CLASSIFIED_CUSTOMER
set DISCOUNT = DISCOUNT * 1.05
where CLASS_EMAIL in (select GOLD_EMAIL from v22a,v22 where v22a.Items_Sold > v22.MAX_SOLD_PLAT);

select * from CLASSIFIED_CUSTOMER;
