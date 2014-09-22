create or replace view v17a as
select count(*) numbertimessoldtraded,TRAN_INV_ITEM_NO from 
(select distinct TRAN_INV_ITEM_NO,TRAN_INV_ITEM_EMAIL  from TRANSACTION natural join TRANS_INVOLVE_ITEM
where TYPE = 'SI' or TYPE = 'AT')
group by TRAN_INV_ITEM_NO;

create or replace view v17b as
select AMOUNT,TRAN_INV_ITEM_NO from 
(select distinct TRAN_INV_ITEM_NO,AMOUNT  from TRANSACTION natural join TRANS_INVOLVE_ITEM
where TYPE = 'SI' or TYPE = 'AT');

select distinct ITEM_NO, WEIGHT, PRICE, AMOUNT MAXAMOUNT from ITEM inner join 
(select TRAN_INV_ITEM_NO,NUMBERTIMESSOLDTRADED, AMOUNT from  
(select * from v17a
NATURAL join 
v17b))
on ITEM_NO = TRAN_INV_ITEM_NO
where NUMBERTIMESSOLDTRADED > 1;



