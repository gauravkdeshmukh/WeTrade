-- customers who purchased items after winning bid
create or replace view v10a as
select distinct CUST_TRANS_EMAIL as email from CUST_GENERATE_TRANS
inner join TRANSACTION
on GEN_TRANS_ID IN
(select TRANS_ID from Transaction
where type = 'PI');

-- customers who are classified
create or replace view v10b as
select CUST_EMAIL, 'REGULAR' as STATUS from CUSTOMER
  where CUST_EMAIL NOT IN (select CLASS_EMAIL from CLASSIFIED_CUSTOMER)
  UNION
  select CLASS_EMAIL, 'GOLD' as STATUS  from CLASSIFIED_CUSTOMER, GOLD
  where CLASS_EMAIL = GOLD_EMAIL
  UNION
  select CLASS_EMAIL, 'PLATINUM' as STATUS  from CLASSIFIED_CUSTOMER, PLATINUM
  where CLASS_EMAIL = PLATINUM_EMAIL;
  
  -- status of customers who won bid
  create or replace view v10c as 
  select distinct v10b.CUST_EMAIL , v10b.STATUS
  from v10b
  where CUST_EMAIL in (select email from v10a);
  
  -- items that were sold to winners
  create or replace view v10d as 
  select distinct ITEM_NO,ITEM_EMAIL,PRICE from item inner join CUST_BID_ITEM on 
  BID_ITEM_EMAIL = ITEM_EMAIL
  and BID_ITEM_NO = ITEM_NO;
  
  -- amount paid by winning customers
  create or replace view v10e as
  select max(AMOUNT) maxamt ,BID_ITEM_EMAIL,BID_ITEM_NO from CUST_BID_ITEM
  where BID_CUST_EMAIL in 
  (select CUST_EMAIL from v10c)
  group by (BID_ITEM_EMAIL,BID_ITEM_NO);
  
  -- get discount 
  create or replace view v10f as
  select CUST_EMAIL, 0 as discount from v10c
  where STATUS = 'REGULAR'
  UNION
  select CLASS_EMAIL, DISCOUNT as discount from CLASSIFIED_CUSTOMER
  where CLASS_EMAIL in (select CUST_EMAIL from v10c where STATUS = 'GOLD')
  UNION
  select CLASS_EMAIL, DISCOUNT as discount from CLASSIFIED_CUSTOMER
  where CLASS_EMAIL in (select CUST_EMAIL from v10c where STATUS = 'PLATINUM');
  
  select distinct CUST_EMAIL,(MAXAMT - ((DISCOUNT*MAXAMT)/100) - PRICE) as OVERPAID  from v10d natural join v10e natural join v10f 
  where 
  ITEM_EMAIL = BID_ITEM_EMAIL
  and 
  ITEM_NO = BID_ITEM_NO;
  
  