create or replace view v19a as
select CUST_EMAIL from CUSTOMER
where CUST_EMAIL in 
( select cust_trans_email 
  from CUST_GENERATE_TRANS
  where GEN_TRANS_ID in
      (SELECT Trans_id
      FROM transaction
      WHERE EXTRACT(YEAR FROM
      to_timestamp(TRANS_DATE_TIME)) < EXTRACT(YEAR FROM to_timestamp(SYSDATE))- 1  
      )
);

create or replace view v19b as
select CUST_EMAIL from CUSTOMER
where CUST_EMAIL in 
( select cust_trans_email 
  from CUST_GENERATE_TRANS
  where GEN_TRANS_ID in
      (SELECT Trans_id
      FROM transaction
      WHERE EXTRACT(YEAR FROM
      to_timestamp(TRANS_DATE_TIME)) > EXTRACT(YEAR FROM to_timestamp(SYSDATE))- 1  
      )
);

select * from CUSTOMER;

update CUSTOMER 
set password = 'xyzzy'
where CUST_EMAIL in
(select CUST_EMAIL from 
(select * from v19a) minus (select * from v19b));

select * from customer;

rollback;