select BID_CUST_EMAIL, concat(concat(FIRST_NAME,MIDDLE_INITIALS),LAST_NAME) as FULL_NAME, COUNTRY, BID_DATE_TIME, AMOUNT from CUSTOMER,
(select BID_CUST_EMAIL, AMOUNT, BID_DATE_TIME from CUST_BID_ITEM where (BID_ITEM_NO, BID_ITEM_EMAIL) in
(select ITEM_NO, ITEM_EMAIL from ITEM where price in (select max(price) from ITEM))
)
where CUST_EMAIL = BID_CUST_EMAIL
order by AMOUNT desc;