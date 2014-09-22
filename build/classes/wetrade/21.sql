create or replace view v21 as
(select ITEM_NO_REVITEM, ITEM_EMAIL_REVITEM, AVG(RATING) AS Avg_Rating from CLASSCUST_REVIEW_ITEM
GROUP BY ITEM_NO_REVITEM, ITEM_EMAIL_REVITEM);

create or replace view v21a as
select ITEM_NO_REVITEM, ITEM_EMAIL_REVITEM from v21 where Avg_Rating in (select MIN(Avg_Rating) from v21);

select * from ITEM;

update ITEM
set PRICE = PRICE * 0.5
where (ITEM_NO,ITEM_EMAIL) IN (select * from v21a);

select * from ITEM;

rollback;