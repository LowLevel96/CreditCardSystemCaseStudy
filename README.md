# DE02-NY
**Core Java**

- Project name is CreditCardSystem.
- Open project in your IDE and be sure to change the database parameters.
  - **oo** In database package go to DatabaseConnection.java file and change database name as well as username and password if needed.
- Clean and Build project
- Run main.java file

**RDBMS/mySQL**  **Description** :

- To create tables and insert data for this project, run following sql file: /MappingDocuments/CASESTUDY.sql
- This file will create database for you named CASESTUDY

**Hadoop/hdfs/dataware housing**

- In HDFS we are using **maria\_dev** user. Therefore data transferred from relational database with Sqoop is stored in /user/maria\_dev/Credit\_Card\_System

**Hive and Partition**

- Hive imports consist of four tables (Branch, Credit Card, Time and Customer). Each table is external table that loads data files imported by sqoop.
- **CreateBranchTable.sql**
  - **oo** This file creates Branch table called CDW\_SAPP\_D\_BRANCH
  - **oo** Loads data from /user/maria\_dev/Credit\_Card\_System/Branch
- **CreateCreditCardTable.sql**
  - **oo** This is where dynamic partitioning is done.
  - **oo** Partitioning is done on **TRANSACTION\_TYPE** field.
  - **oo** There are two tables created. CDW\_SAPP\_F\_CREDIT\_CARD and TEMP\_CDW\_SAPP\_F\_CREDIT\_CARD in order to insert partitioned data from TEMP table to original one.
  - **oo** Loads partitioned data from /user/maria\_dev/Credit\_Card\_System/PartitionedCreditCard
- **CreateCustomerTable.sql**
  - **oo** This file creates Branch table called CDW\_SAPP\_D\_CUSTOMER
  - **oo** Loads data from /user/maria\_dev/Credit\_Card\_System/Customer
- **CreateTimeTable.sql**
  - **oo** This file creates Branch table called CDW\_SAPP\_D\_TIME
  - **oo** Loads data from /user/maria\_dev/Credit\_Card\_System/TimeID
- **IncrementalCreateCreditCard.sql**
  - **oo** This file insert new data in incremental way.
  - **oo** It is used in oozie with coordinators for incremental update.

**Oozie (Sqoop and Hive)**

- Before running any sqoop jobs it is important to run sqoop metastore.
- In /SqoopImport directory there is file called **sqoopjobs.sh** which is shell script that will create all Sqoop jobs.
- Transfer **sqoopjobs.sh** file to your local path
- Run following command as root user: sudo chmod 777 /user/maria\_dev/sqoopjobs.sh
- Run it: ./sqoopjobs.sh
- Transfer directory /OozieWorkflow and /HiveImports to both local and hdfs path:
  -
    -
      - Type: hadoop fs --put OozieWorkflow/ /user/maria\_dev/
      - Type: hadoop fs --put HiveImports/ /user/maria\_dev/

- --Upload java-json.jar file:
  - **oo** There will be file java-json.jar
  - **oo** Use Ambari to upload that file to /user/oozie/share/lib/ **lib\_\*\*\*\*\*\*\*** /sqoop/
  - **oo** Change lib\_\*\*\*\*\*\*\* to your directory name
- --Before running Oozie import mysql database required for this project. File to insert is in /MappingDocuments/CASESTUDY.sql

- Run this command to start Oozie to create Hive tables and import data from relational database:
  - **oo** oozie job --oozie http://localhost:11000/oozie -config /home/maria\_dev/OozieWorkflow/Initialize/job.properties -run

**Oozie (Sqoop and Hive optimized)**

- After Initialized Oozie workflow, we can run Incremental Oozie workflow for incremental update
- We are running same sqoop jobs and one additional hive query for updating data with dynamic partitioning.
- To run optimized oozie run:
  - **oo** oozie job --oozie http://localhost:11000/oozie -config /home/maria\_dev/OozieWorkflow/Incremental/job.properties -run

**Visualization**

- In /HiveVisualization directory there are two file firstQuery.q and secondQuery.q
