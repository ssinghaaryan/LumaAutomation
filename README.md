# LumaAutomation - Hybrid Automation Framework

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FFD700?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![Extent Reports](https://img.shields.io/badge/Extent%20Reports-4B8BBE?style=for-the-badge&logo=extent-reports&logoColor=white)




![image](https://github.com/ssinghaaryan/LumaAutomation/assets/86829777/01a8caf2-c160-4d89-9ee0-8085fd8779f3)




## Introduction

This project is a Hybrid Automation Framework for an e-commerce website developed using Selenium, Java, TestNG, Maven, Jenkins, Git, and Extent Reports. The framework is designed to support both data-driven and keyword-driven testing approaches, providing test automation for functionalities such as user registration, user login, product search, shopping cart operations, checkout process.

## Features

- **Modular and Scalable:** Easily extendable for additional test cases and modules.
- **Data-Driven Testing:** Supports testing with multiple sets of data using external files (Excel, CSV).
- **Keyword-Driven Testing:** Allows tests to be created using keywords specified in external files.
- **Continuous Integration:** Seamless integration with Jenkins for CI/CD pipelines.
- **Reporting:** Comprehensive test reports generated using Extent Reports.
- **Version Control:** Managed using Git for version control.


LumaAutomation
│   README.md
│   pom.xml
└───src
    └───main
    │   └───java
    │       └───com
    │           └───qa
    │               └───framework
    │                   ├───config
    │                   ├───listeners
    │                   ├───pages
    │                   ├───testdata
    │                   └───utils
    └───test
        └───java
            └───com
                └───qa
                    ├───base
                    ├───testcases 





├── README.md
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── qa
│   │               ├── config
│   │               │   └── config.properties
│   │               ├── listeners
│   │               │   └── Listeners.java
│   │               ├── pages
│   │               │   ├── AccountCreationPage.java
│   │               │   ├── AccountPage.java
│   │               │   ├── HomePage.java
│   │               │   ├── LoginPage.java
│   │               │   ├── RegisterPage.java
│   │               │   └── SearchPage.java
│   │               ├── testdata
│   │               │   ├── TestData.xlsx
│   │               │   └── testdata.properties
│   │               └── utils
│   │                   ├── ExtentReporter.java
│   │                   └── Utilities.java
│   └── test
│       ├── java
│       │   └── com
│       │       └── qa
│       │           ├── base
│       │           │   └── Base.java
│       │           └── testcases
│       │               ├── LoginTest.java
│       │               ├── RegisterTest.java
│       │               └── SearchTest.java
│       └── resource
│           └── testng.xml
    
