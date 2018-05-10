DROP VIEW IF EXISTS CDW_SAPP_D_BRANCH;

CREATE VIEW `CDW_SAPP_D_BRANCH` AS SELECT b.branch_code as BRANCH_CODE, b.branch_name as BRANCH_NAME, b.branch_street as BRANCH_STREET, b.city as BRANCH_CITY,
					s.name as BRANCH_STATE, b.zip as BRANCH_ZIP, b.phone as BRANCH_PHONE, b.LAST_UPDATED
FROM Branch b JOIN State s ON (b.state=s.id);