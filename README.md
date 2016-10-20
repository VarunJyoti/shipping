# shipping

1. Import it in Eclipse as Maven project.

2. Shore-BL has DB script file named baseline.sql under folder resources/config 

3. Configure database.properties with you local mysql login credentials.

4. MVN-clean-install and try running StartServer.java. Once BL is up and running try accessing http://localhost:9000/shore . Welcome page will open.

5. To test service and DB connections, try accessing  http://localhost:9000/shore/users/login. It should print JSON response in browser.
