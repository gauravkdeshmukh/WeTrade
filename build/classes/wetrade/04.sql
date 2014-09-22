create or replace view v4 as
select  CUST_TRANS_EMAIL, count(*) as No_of_Trans from CUST_GENERATE_TRANS
where CUST_TRANS_EMAIL not in (select CLASS_EMAIL from CLASSIFIED_CUSTOMER)
group by CUST_TRANS_EMAIL;

select FIRST_NAME, LAST_NAME, MIDDLE_INITIALS, CUST_EMAIL from CUSTOMER where CUST_EMAIL in
(select CUST_TRANS_EMAIL from v4 where No_of_Trans in (select MAX(No_of_Trans) from v4));