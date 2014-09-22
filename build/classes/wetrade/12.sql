create or replace view v12a as 
select CUST_EMAIL_REVCUST, count(*) numberratings FROM
(select CUST_EMAIL_REVCUST, CRITIQUE from PLATINUM_REVIEW_CUSTOMER
where CRITIQUE = 'POOR' or  CRITIQUE = 'FAIR')
group by CUST_EMAIL_REVCUST;

select ITEM_NO, WEIGHT, PRICE, (FIRST_NAME || MIDDLE_INITIALS || LAST_NAME) CustomerName  from customer inner join
(select * from item 
where ITEM_EMAIL in
(select CUST_EMAIL_REVCUST as customer from V12A
where NUMBERRATINGS IN
(select Numberratings From v12a
 where numberratings >= 2)))
 on ITEM_EMAIL = customer.CUST_EMAIL
 order by LAST_NAME,FIRST_NAME,MIDDLE_INITIALS;


