SELECT t.id, cc.credit_card_no, CONCAT(cc.day, cc.month, cc.year) as TIMEID, c.ssn, b.branch_code, t.transaction_type, t.transaction_value
FROM CreditCard cc JOIN Customer c ON (cc.customer=c.id)
JOIN Branch b ON (b.id=cc.branch_code)
JOIN Transactions t ON (cc.id=t.credit_card_no);
