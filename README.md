# TourRadar_UI_Automation

UI Automation of web using page object model in selenium

How to run.There are two options

1. Execute the following command - docker run --rm -it -p 4444:4444 -p 5901:5900 -p 7900:7900 --shm-size 2g seleniarm/standalone-chromium:latest (This step is required when the execution mode is set to remote in Tour_Radar_UI/Config/config.properties)
2. Run locally through terminal using maven commands -> copy directory of the project in the termial -> use ”mvn clean” and “mvn test” OR 
Run through Testng.xml-> Go to this file in the project and select run as TestNG suite

Remote execution can be seen by running on local http://localhost:7900/ with password=secret

Testcase details

1) UI_TC1_Filters:  User selects multiple filters - departure month, destination countries and tour length ; and validation that the filters are applied correctly
2) UI_TC2_Sorting:  User selects multiple filters, applies sorting results based on tour length and validation if the sorting is working. User applies another sort and validates new sorting.
3) UI_TC3_CTA_Download: User clicks download button on one of tours, submits email and checks confirmation message 


Here is the configuration I have used to run-: apache-maven-3.8.6 Java version: 11.0.15.1, jdk-11.0.15.1 OS name: "mac os x", version: "12.2", arch: "x86_64", family: “mac" Browser: chrome ( configuration available for other browsers with a few updates)
