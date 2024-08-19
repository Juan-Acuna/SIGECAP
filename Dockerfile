# -------------JDK 22.0_8----------------
 # Use the official MySQL image as a base 
FROM eclipse-temurin:22.0.1_8-jdk-alpine

 ARG APP_PORT=8080

 ENV APP_PORT$={APP_PORT}
 
 # Create folder /home/app
 RUN mkdir -p /home/app

 # Copy jar file into /home/app/ folder as app.jar
 COPY ./target/sigecap-0.0.1-SNAPSHOT.jar /home/app/app.jar
 
 # Set the working directory to /home/app
 WORKDIR /home/app

 # 
 RUN echo el host es ${DB_HOST}

 EXPOSE ${APP_PORT}

 CMD ["java","-jar","app.jar"]
 
 # -------------MYSQL-------------------
 # Use the official MySQL image as a base
 FROM mysql:latest

 # Set the working directory to /app
 WORKDIR /app

 # Copy the current directory contents into the container at /app
 ADD . /app

 # Set the default user for the MySQL image
 USER mysql

 # Set environment variables for the new user
 ENV MYSQL_USER=external_user
 ENV MYSQL_PASSWORD=password
 ENV MYSQL_DATABASE=my_database

 # Run the following commands to create the new user and grant them the necessary permissions
 RUN mysql -u root -p -e "CREATE USER '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD';"
 RUN mysql -u root -p -e "GRANT ALL PRIVILEGES ON $MYSQL_DATABASE.* TO '$MYSQL_USER'@'%';"
 RUN mysql -u root -p -e "FLUSH PRIVILEGES;"

 # Expose port 3306 to allow connections to the database
 EXPOSE 3306

 # Start the MySQL server when the container is run
 CMD ["mysqld"]