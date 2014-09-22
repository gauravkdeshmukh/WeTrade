create or replace view t1 as
select distinct * from
(select country as SellingCountry from CUSTOMER
where CUST_EMAIL IN
(select CUST_TRANS_EMAIL from CUST_GENERATE_TRANS
where GEN_TRANS_ID IN
(select TRANS_ID from TRANSACTION 
where TYPE = 'SI')
))v1,
(select country as PurchaseCountry from CUSTOMER
where CUST_EMAIL IN
(select CUST_TRANS_EMAIL from CUST_GENERATE_TRANS
where GEN_TRANS_ID IN
(select TRANS_ID from TRANSACTION 
where TYPE = 'PI')
))v2
where v1.SellingCountry <> v2.PurchaseCountry;

create or replace view t2 as
select country, count(distinct(item_found)) as NUMBER_OF_ITEMS_SOLD from item,
  (select country, CUST_EMAIL as country_cust_email, item_found  from CUSTOMER,
      (select TRAN_INV_ITEM_EMAIL ,TRAN_INV_ITEM_NO as item_found from TRANS_INVOLVE_ITEM
        where TRAN_INV_TRANS_ID IN
                (select TRANS_ID from TRANSACTION 
                 where TYPE = 'SI')
      )
   where CUST_EMAIL = TRAN_INV_ITEM_EMAIL)
group by country;

select t2.COUNTRY,t2.NUMBER_OF_ITEMS_SOLD from 
t1 join t2 on t1.SELLINGCOUNTRY = t2.COUNTRY;
