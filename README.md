# Selenium Automation Testing Project: WorldClock
 
## Project Overview
This Selenium automation testing project focuses on automating tasks related to the Be.Cognizant portal. 
The primary objectives include capturing user information, navigating through the portal, verifying the presence of specific elements, and comparing date,time and day of different cities. 
The project uses various dependencies and libraries to facilitate automation.

## Project Structure
 
### 1. Maven Repository
 
- *Maven Version*: 3.12.1
 
### 2. Dependencies
 
- *Apache POI*
  - Version: 5.2.3/5.2.5 (latest version)
  - Purpose: Used for reading and writing Excel files, facilitating data-driven testing.
 
- *TestNG*
  - Version: 7.4.0
  - Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
 
- *Extent Report*
  - Version: 5.1.1
  - Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
 
- *Selenium*
  - Version: 4.15.0
  - Purpose: Enables interaction with web elements, navigation, and form submission in the browser.
 
- *Loggers*
  - Version: 2.22.0
  - Purpose: Provides logging capabilities for better debugging and traceability.
 
## Automation Test Flow
 
1. *Open Be.Cognizant Page*
   - Navigate to the Be.Cognizant portal.
 
2. *Capture User Info*
   - Click on the profile.
   - Capture user information.
   - Print and take screenshots.
 
3. *Navigate to OneCognizant*
   - Click on view all apps under hot apps section.
 
4. *Verify and Navigate to Apps store*
   - Verify the presence of all the alphabets.
   - Select and click on any random alphabet.
   - Select name of all the apps present.
 
5. *Capture all the apps and Screenshots*
   - Scroll down.
   - Print all given apps.
   - Take screenshots of the page with all the apps.
 
6. *Navigate Back to Be.Cognizant Page*
   - Navigate back.
   - Verify return to Be.Cognizant page.
 
7. *Capture WorldClock*
   - Scroll down.
   - Capture the WorldClock.
 
8. *Verify date, time and day of different cities*
   - Verify and display the details.
 
9. *Google Search for actual timings of cities*
   - Open Google.
   - Search for "London time and NewYork times"
 
10. *Capture Google Search times*
    - Capture the times from Google.
 
11. *Compare the timings*
    - Compare the timings from the portal with the one from Google.
 
## How to Run the Tests
 
1. *Open Eclipse IDE:*
   - Launch Eclipse IDE on your machine.
 
2. *Import Project:*
   - Select File -> Import from the menu.
   - Choose Existing Maven Projects and click Next.
   - Browse to the directory where you cloned the repository and select the project.
 
3. *Update Maven Project:*
   - Right-click on the project in the Project Explorer.
   - Choose Maven -> Update Project.
   - Click OK to update dependencies.
 
4. *Set Up Configuration:*
   - Open the src/test/resources/config.properties file.
   - Update any configuration parameters like browser type, URLs, etc., as needed.
 
5. *Run Test Suite:*
   - Locate the test suite file (e.g., src/test/java/TestSuite.java).
   - Right-click on the file and choose Run As -> TestNG Suite.
 
6. *View Reports:*
   - After execution, open the test-output folder.
   - Find the Extent Report HTML file (index.html) for detailed test reports.
 
## Author Information
 
- *Ayushi Gupta*
- *Ramendu Ghosal*
- *Satyam Anand*
- *Kavya BS*
 
## Disclaimer
 
This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.
