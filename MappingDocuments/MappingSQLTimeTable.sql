SELECT CONCAT(cc.day,cc.month,cc.year) as TIMEID, cc.day, cc.month,
CASE
	WHEN QUARTER(CONCAT(cc.year, '-', cc.month, '-', cc.day)) = 1 THEN 'FIRST'
	WHEN QUARTER(CONCAT(cc.year, '-', cc.month, '-', cc.day)) = 2 THEN 'SECOND'
	WHEN QUARTER(CONCAT(cc.year, '-', cc.month, '-', cc.day)) = 3 THEN 'THIRD'
	WHEN QUARTER(CONCAT(cc.year, '-', cc.month, '-', cc.day)) = 4 THEN 'FOURTH'
END as Quarter
, cc.year
FROM CreditCard cc;