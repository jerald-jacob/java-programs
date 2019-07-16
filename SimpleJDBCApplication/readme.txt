
Step 0: What We Need (Rather, What We Have Used in This Article)
NetBeans 8.2
JDK 8
MySQL 5
That's all…and oh! You also need a Linux platform. The idea is same for Windows as well, except for the Terminal command used for setting up your MySQL user account in part of Step 1.

Step 1: Setting Up Your MySQL User Account
Assuming that the MySQL database is installed properly, we'll create a user account to work with the database. It is always a good idea to use a different user account to play with the database rather than always using the default root user account.

Open Linux Terminal and start the database server by executing the command mysql, as follows. This will start the MySQL Server.
Email Article
Print Article
$ service mysql start or restart
Then, start the MySQL monitor to set up your user account.
$ mysql -h localhost -u root
Managing Change in Java SE: So Where Are We?  
The -h option indicates the host on which MySQL service is running. The -u option indicates a user account; root is a default user. If a root password is set (during installation), add -p (it will prompt you for a password); otherwise, leave it blank.

In the mysql> prompt, type:
USE mysql;
This will select the built-in database called mysql, which stores server information such as user accounts and their privileges.

Add a new account to the mysqlbuilt-in database with all required privileges.
create user 'jerald'@'localhost' identified by '12345678';
grant select, create, drop, references, insert, update,
   delete, execute on *.* to 'jerald'@'localhost';
This will create a user named jerald with password 12345678.

Type the command exit; to terminate MySQL monitor
Step 2: Create the Database
The MySQL database (which we'll create down the line with the CREATE command) is like a folder where all the related tables are stored. So, in most cases, when the theme of the database changes, we keep the table that adheres to the theme encompassed within a logical area called the database. For example, a library database may contain tables such asbooks, authors, publisher, borrowing, and so forth. But, before we create the database, we must log in to MySQL with the new user we have just created (if you have not created any, use the default root user).

Log in again with the new user account. Because we have used "set password" for this user, -p will prompt for it.
mysql -h localhost -u mickey -p
Create a database. Here, testdbis like a folder, a container that will contain all the tables we will create.
CREATE testdb;
USE testdb;
Now, create tables with the following SQL DDL:
create table books
(
   isbn varchar(20) primary key,
   title varchar(50),
   edition varchar(20),
   price float(10,2)
);

create table authors
(
   author_id int primary key,
   author_name varchar(50)
);

create table book_by_author
(
   isbn varchar(20),
   author_id int,
   foreign key(isbn)
      references books(isbn),
   foreign key(author_id)
      references authors(author_id)
);
Insert some dummy data. This will help in testing the application later.

insert into books values('123456','Discrete Math',
   'Second',56.78);
insert into books values('234567','Integral Calculus',
   'Second',92.73);
insert into books values('345678','Differential Calculus',
   'First',57.86);
insert into books values('456789','Graph Theory',
   'Second',33.8);
insert into books values('567890','Set Theory',
   'Fourth',34.89);
insert into books values('102938','Numerical Methods',
   'Third',98.46);

insert into authors values(1,'CS Liu');
insert into authors values(2,'N Deo');
insert into authors values(3,'Rogers');
insert into authors values(4,'Saxena');
insert into authors values(5,'Sandip');
insert into authors values(6,'Srivastava');
insert into authors values(7,'Jha');

insert into book_by_author values('123456',1);
insert into book_by_author values('123456',2);
insert into book_by_author values('123456',3);
insert into book_by_author values('234567',4);
insert into book_by_author values('234567',5);
insert into book_by_author values('345678',6);
insert into book_by_author values('456789',7);
insert into book_by_author values('567890',4);
insert into book_by_author values('102938',6);
Terminate MySQl monitor with the exit; command.
Up to this point, there has been nothing to do with Java; we are basically dealing with SQL DDL in MySQL Monitor. From the next step onwards, we'll deal with Java and NetBeans.

Step 3: Create a Java Project
Open the NetBeans IDE and create a Java Project in the following manner:

File → New Project; a window will appear. Select Java from the Categories list and Java Application from the Projects list. Click Next.
In the New Java Application window, enter the name location of the project. Optionally, check Use Dedicated Folder for Storing Librariesor un-check it. It does not matter, at least for our current project, but the purpose is clearly stated in the help section; let's not restate it here.
Assigning a project name and location

Click Finish. This will create a Java project environment in NetBeans.
The Java project environment is created


Step 4: Add the MySQL JDBC Driver
Because it is a JDBC project and we opt to connect to a MySQL database, we need MySQL JDBC Driver. It is basically a vendor-specific Type 4 driver that bridges the communication gap between our application and the database. If you want to connect to any other database, look for that database-specific JDBC driver. A JDBC Driver for almost all major databases (Oracle, PostgreSQL, and so on) is available in the relevant vendor sites.
Right-click the project name in the Projects tree view → Properties.
Select Libraries from the Categoriestree view.
Selecting Libraries from the Categories tree view

Click the Add Library button. An Add Library window will appear. If the MySQL JDBC Driver is not present in the available libraries list, click the Import…button. Then, click the MySQL JDBC Driver from the available libraries list.
Note: The MySQL JDBC Driver is already shipped with NetBeans. There is no need to install it separately. Other drivers, which may not be shipped with NetBeans, may need to be imported as a separate jar file. In such a case, use the Add JAR/Folder button to import it in the current project.
Adding a Library

If the import is successful, the imported jar file will be shown in the projects list.
The imported jar file is shown in the projects list

Now that everything is set, we can start our code in Java.
Step 5: Creating the Application
There a few thing common to Java code in implementing a JDBC application. The package that contains all the required classes and interfaces for JDBC programming is java.sql. The exceptions that may occur are handled by the object of the SQLException reference defined in the same package.

Connecting to the database
Database connection is established by creating a Connection object. The Connection is an interface and the object that implements the Connection interface manages the connection between Java and the database. A reference to the Connection object is created with the help of the overloaded static method getConnection(), defined in the DriverManager class. One of the overloaded getConnection() methods takes three parameters.

Database URL of the format jdbc:mysql://hostname:portNumber/databaseName for MySQL. This format may change when connecting to other databases.
Database user name
Database password
Executing the SQL query
Next, we need an object reference to the Statement interface to submit SQL statements to the database.

Processing the query result
The result of the query fired through the Statement object is contained by an object of the ResultSet interface.

When we put these together, it looks like this. This is the code we write inside the SimpleJDBCApplication.java source file, which basically fetches the record we have inserted in the books table we have created.

package simplejdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJDBCApplication {

   static final String DB_URL =
      "jdbc:mysql://localhost:3306/testdb";
   static final String DB_DRV =
      "com.mysql.jdbc.Driver";
   static final String DB_USER = "jerald";
   static final String DB_PASSWD = "12345678";

   public static void main(String[] args){

      Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;

      try{
         connection=DriverManager.getConnection
            (DB_URL,DB_USER,DB_PASSWD);
         statement=connection.createStatement();
         resultSet=statement.executeQuery
            ("SELECT * FROM books");
         while(resultSet.next()){
            System.out.printf("%s\t%s\t%s\t%f\n",
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getFloat(4));
         }

      }catch(SQLException ex){
      }finally{
         try {
            resultSet.close();
            statement.close();
            connection.close();
         } catch (SQLException ex) {
         }
      }
   }
}
Step 6: Execute the Application
Click Run→ Run Project, or press Ctrl+F11. This will compile and execute the project.
