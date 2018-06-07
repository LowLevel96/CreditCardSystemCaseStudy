#!/bin/bash

sqoop job --meta-connect jdbc:hsqldb:hsql://sandbox.hortonworks.com:16000/sqoop \
--create importBranchTable -- import \
--connect jdbc:mysql://localhost/CASESTUDY \
--driver com.mysql.jdbc.Driver \
--query "SELECT b.branch_code as BRANCH_CODE, b.branch_name as BRANCH_NAME, b.branch_street as BRANCH_STREET, b.city as BRANCH_CITY,
                                        s.name as BRANCH_STATE, b.zip as BRANCH_ZIP, b.phone as BRANCH_PHONE, b.LAST_UPDATED
FROM Branch b JOIN State s ON (b.state=s.id)
WHERE \$CONDITIONS" \
--split-by Branch.branch_code \
--target-dir /user/maria_dev/Credit_Card_System/Branch \
--append \
--incremental lastmodified \
--check-column LAST_UPDATED \
--last-value "2018-05-09 11:35:25" \
-m 1 &> /dev/null;
 

if [ $? -eq 0 ]
then
  echo "Successfully created Sqoop Branch Table Job"
else
  echo "Failed to create Sqoop Branch Table Job" >&2
fi

sqoop job --meta-connect jdbc:hsqldb:hsql://sandbox.hortonworks.com:16000/sqoop \
--create importCreditCardTable -- import \
--connect jdbc:mysql://localhost/CASESTUDY \
--driver com.mysql.jdbc.Driver \
--query "SELECT ID, credit_card_no, TIMEID, SSN, branch_code, transaction_type, transaction_value
FROM (SELECT t.id, cc.credit_card_no, CONCAT(cc.day, cc.month, cc.year) as TIMEID, c.ssn, b.branch_code, t.transaction_type, t.transaction_value
FROM CreditCard cc JOIN Customer c ON (cc.customer=c.id)
JOIN Branch b ON (b.id=cc.branch_code)
JOIN Transactions t ON (cc.id=t.credit_card_no)
) as name
WHERE \$CONDITIONS" \
--split-by Transactions.id \
--target-dir /user/maria_dev/Credit_Card_System/CreditCard \
--incremental append \
--check-column ID \
--last-value 0 \
-m 1 &> /dev/null;
if [ $? -eq 0 ]
then
  echo "Successfully created Sqoop Credit Card Table Job"
else
  echo "Failed to create Sqoop Credit Card Table Job" >&2
fi

sqoop job --meta-connect jdbc:hsqldb:hsql://sandbox.hortonworks.com:16000/sqoop \
--create importCustomerTable -- import \
--connect jdbc:mysql://localhost/CASESTUDY \
--driver com.mysql.jdbc.Driver \
--query "SELECT c.ssn as CUST_SSN, c.first_name as CUST_F_NAME, c.middle_name as CUST_M_NAME, c.last_name as CUST_L_NAME,
										cc.credit_card_no as CUST_CC_NO, CONCAT(CONCAT(c.apt_no, ' '), c.street_name) as CUST_STREET,
                                            c.city as CUST_CITY, s.name as CUST_STATE, Countries.name as CUST_COUNTRY, c.zip as CUST_ZIP, c.phone as CUST_PHONE,
                                            c.email as CUST_EMAIL, c.LAST_UPDATED
FROM Customer c 
LEFT JOIN CreditCard cc ON (c.id=cc.customer)
LEFT JOIN State s ON (c.state=s.id)
LEFT JOIN Countries ON (s.country_id=Countries.id)
WHERE \$CONDITIONS" \
--split-by Customer.ssn \
--target-dir /user/maria_dev/Credit_Card_System/Customer \
--append \
--incremental lastmodified \
--check-column LAST_UPDATED \
--last-value "2018-05-09 11:36:25" \
-m 1 &> /dev/null;
if [ $? -eq 0 ]
then
  echo "Successfully created Sqoop Customer Table Job"
else
  echo "Failed to create Sqoop Customer Table Job" >&2
fi

sqoop job --meta-connect jdbc:hsqldb:hsql://sandbox.hortonworks.com:16000/sqoop \
--create importTimeTable -- import \
--connect jdbc:mysql://localhost/CASESTUDY \
--driver com.mysql.jdbc.Driver \
--query "SELECT TIMEID, DAY, MONTH, QUARTER, YEAR, ID
FROM (SELECT CONCAT(CreditCard.year,CreditCard.month,CreditCard.day) as TIMEID, CreditCard.day, CreditCard.month,
CASE
        WHEN QUARTER(CONCAT(CreditCard.year, '-', CreditCard.month, '-', CreditCard.day)) = 1 THEN 'FIRST'
        WHEN QUARTER(CONCAT(CreditCard.year, '-', CreditCard.month, '-', CreditCard.day)) = 2 THEN 'SECOND'
        WHEN QUARTER(CONCAT(CreditCard.year, '-', CreditCard.month, '-', CreditCard.day)) = 3 THEN 'THIRD'
        WHEN QUARTER(CONCAT(CreditCard.year, '-', CreditCard.month, '-', CreditCard.day)) = 4 THEN 'FOURTH'
END as Quarter
, CreditCard.year, t.id
FROM CreditCard JOIN Transactions t ON (CreditCard.id=t.credit_card_no)
) as TimeTable
WHERE \$CONDITIONS" \
--target-dir /user/maria_dev/Credit_Card_System/TimeID \
--incremental append \
--check-column ID \
--last-value 0 \
-m 1 &> /dev/null;
if [ $? -eq 0 ]
then
  echo "Successfully created Sqoop Time Table Job"
else
  echo "Failed to create Sqoop Time Table Job" >&2
fi

