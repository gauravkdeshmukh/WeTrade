Insert into CUST_BID_ITEM (BID_ITEM_EMAIL,BID_ITEM_NO,AMOUNT,BID_DATE_TIME,BID_CUST_EMAIL) values ('NellaFiorentino@armyspy.com',3,1400,to_timestamp('12-APR-14 07.59.24.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'NoahMiah@dayrep.com');
Insert into TRANSACTION (TRANS_ID,TRANS_DATE_TIME,TYPE,AMOUNT) values (24,to_timestamp('12-APR-14 07.59.24.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'BI',1400);
Insert into CUST_GENERATE_TRANS (CUST_TRANS_EMAIL,GEN_TRANS_ID) values ('NoahMiah@dayrep.com',24);
Insert into TRANS_INVOLVE_ITEM (TRAN_INV_TRANS_ID,TRAN_INV_ITEM_NO,TRAN_INV_ITEM_EMAIL) values (24,3,'NellaFiorentino@armyspy.com');

select BID_CUST_EMAIL, WinningBid, BID_DATE_TIME from CUST_BID_ITEM natural join
(select MAX(AMOUNT) WinningBid , BID_ITEM_EMAIL,BID_ITEM_NO FROM
(select distinct BID_ITEM_EMAIL,BID_ITEM_NO,AMOUNT from CUST_BID_ITEM
where AMOUNT in
(select MAX(AMOUNT) MAXAMT from
(Select AMOUNT, TRANS_ID from TRANSACTION where TYPE = 'BI')
group by TRANS_ID)
group by BID_ITEM_EMAIL,BID_ITEM_NO,AMOUNT
having AMOUNT = MAX(AMOUNT))
group by BID_ITEM_EMAIL,BID_ITEM_NO);

create or replace view v01a as
select * from 
(select MAX(AMOUNT) WinningBid,BID_ITEM_EMAIL,BID_ITEM_NO,BID_CUST_EMAIL FROM CUST_BID_ITEM natural join
(select distinct BID_ITEM_EMAIL,BID_ITEM_NO,AMOUNT from CUST_BID_ITEM
where AMOUNT in
(select MAX(AMOUNT) MAXAMT from
(Select AMOUNT, TRANS_ID from TRANSACTION where TYPE = 'BI')
group by TRANS_ID))
group by BID_ITEM_EMAIL,BID_ITEM_NO,BID_CUST_EMAIL);

create or replace view v01c as
select * from v01a
where WinningBid in
(select Max(WinningBid) from v01a);

Insert into TRANSACTION (TRANS_ID,TRANS_DATE_TIME,TYPE,AMOUNT) values (TRANSACTION_SEQ.NEXTVAL,to_timestamp(SYSDATE),'PI', (select WINNINGBID from v01c));
Insert into CUST_GENERATE_TRANS (CUST_TRANS_EMAIL,GEN_TRANS_ID) values ((select BID_CUST_EMAIL from v01c),(select max(TRANS_ID) from TRANSACTION where type = 'PI' and AMOUNT = (select WINNINGBID from v01c)));
Insert into TRANS_INVOLVE_ITEM (TRAN_INV_TRANS_ID,TRAN_INV_ITEM_NO,TRAN_INV_ITEM_EMAIL) values ((select max(TRANS_ID) from TRANSACTION where type = 'PI' and AMOUNT = (select WINNINGBID from v01c)),(select BID_ITEM_NO from v01a where v01a.WINNINGBID in (select WINNINGBID from v01c)),(select BID_ITEM_EMAIL from v01a where v01a.WINNINGBID in (select WINNINGBID from v01c)));

rollback;