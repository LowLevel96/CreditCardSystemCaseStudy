SELECT transaction_type, quarter, sum(transaction_value)
FROM CDW_SAPP_F_CREDIT_CARD
JOIN CDW_SAPP_D_TIME
ON (CDW_SAPP_F_CREDIT_CARD.timeid=CDW_SAPP_D_TIME.timeid)
GROUP BY transaction_type, quarter;
