create or replace view v25 as
(select ITEM_EMAIL, ITEM_NO from ITEM where SYSDATE > DEADLINE and (ITEM_EMAIL, ITEM_NO) 
not in (select ITEM_EMAIL, ITEM_NO from ITEM, (select BID_ITEM_EMAIL, BID_ITEM_NO, Amount from CUST_BID_ITEM)t
where ITEM_EMAIL = BID_ITEM_EMAIL AND ITEM_NO = BID_ITEM_NO and AMOUNT < PRICE));

select * from ITEM;

delete from ITEM where (ITEM_EMAIL, ITEM_NO) in (select ITEM_EMAIL, ITEM_NO from v25);

select * from ITEM;

rollback;