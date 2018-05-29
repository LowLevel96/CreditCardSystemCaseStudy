SELECT CAST(DATE_FORMAT(CONCAT(CreditCard.year, '-', CreditCard.month, '-', CreditCard.day), "%Y%m%d") AS UNSIGNED) as TIMEID, CreditCard.day, CreditCard.month,
CASE
        WHEN QUARTER(CONCAT(CreditCard.year, '-', CreditCard.month, '-', CreditCard.day)) = 1 THEN 'FIRST'
        WHEN QUARTER(CONCAT(CreditCard.year, '-', CreditCard.month, '-', CreditCard.day)) = 2 THEN 'SECOND'
        WHEN QUARTER(CONCAT(CreditCard.year, '-', CreditCard.month, '-', CreditCard.day)) = 3 THEN 'THIRD'
        WHEN QUARTER(CONCAT(CreditCard.year, '-', CreditCard.month, '-', CreditCard.day)) = 4 THEN 'FOURTH'
END as Quarter
, CreditCard.year
FROM CreditCard;
