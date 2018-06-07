SELECT branch_zip as Branch_Zip, sum(transaction_value) as Total_Value
FROM CDW_SAPP_F_CREDIT_CARD
JOIN CDW_SAPP_D_BRANCH
ON (CDW_SAPP_F_CREDIT_CARD.branch_code=CDW_SAPP_D_BRANCH.branch_code)
GROUP BY Branch_Zip
ORDER BY Total_Value DESC;
