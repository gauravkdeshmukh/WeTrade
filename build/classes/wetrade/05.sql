create or replace view v5 as
select  CUST_TRANS_EMAIL, count(*) as No_of_Trans from CUST_GENERATE_TRANS
where CUST_TRANS_EMAIL not in (select CLASS_EMAIL from CLASSIFIED_CUSTOMER)
group by CUST_TRANS_EMAIL;

select * from GOLD;

INSERT into CLASSIFIED_CUSTOMER
(select CUST_TRANS_EMAIL, '05-MAR-14 03:36:35.000000000 AM' as CLASS_DATE_TIME, (select COUNT(TRANS_ID) from TRANSACTION where TYPE = 'SI') as DISCOUNT
from (select CUST_TRANS_EMAIL from v5 where No_of_Trans in (select MAX(No_of_Trans) from v5)));

INSERT into GOLD 
((select CLASS_EMAIL from CLASSIFIED_CUSTOMER where CLASS_EMAIL not in (select GOLD_EMAIL from GOLD) AND
CLASS_EMAIL not in (select PLATINUM_EMAIL from PLATINUM)));

select * from GOLD;

rollback;