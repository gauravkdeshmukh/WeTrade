create or replace view v23 as
(select CUST_EMAIL_REVCUST, count(*) as REV_COUNT from PLATINUM_REVIEW_CUSTOMER where critique='POOR' group by(CUST_EMAIL_REVCUST));

select * from customer;

delete from customer where CUST_EMAIL in (select CUST_EMAIL_REVCUST from v23 where REV_COUNT >2);

select * from customer;

rollback;