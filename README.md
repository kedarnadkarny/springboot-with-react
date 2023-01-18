# springboot-with-react

## Initial Setup
### open PowerShell
```
navigate to src\main
npx create-react-app frontend
go to project root
.\mvnw package
java -jar .\target\spring-boot-with-react-0.0.1-SNAPSHOT.jar
```

Go to http://localhost:8080/

## Development Setup
- Open the project in IntelliJ and run the project
- Open the frontend folder in your favorite code editor
- Navigate to the frontend folder path in command line
- npm start
- Go to http://localhost:3000/
- You can make the UI changes and write API requests in React and test the changes without the need for restarting the backend server
- For backend changes just make the change without the need to restart the frontend
- Once development is complete and needs packaging go to the root path and run
```
.\mvnw package
java -jar .\target\spring-boot-with-react-0.0.1-SNAPSHOT.jar
```
Go to http://localhost:8080/