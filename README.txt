📘 Spring_Caw_Ktk 프로젝트 설명
==============================

🧾 개요
-------
본 프로젝트는 Spring Boot + JSP + MySQL을 이용한 MVC 웹 애플리케이션 과제이다.

🗂 프로젝트 구조
---------------
Spring_Caw_Ktk/
├─ .mvn/
├─ mvnw, mvnw.cmd
├─ pom.xml
├─ src/
│   ├─ main/
│   │   ├─ java/
│   │   │   └─ org/example/spring_caw_ktk/
│   │   │       ├─ controller/
│   │   │       │   └─ CalendarKcalController.java
│   │   │       └─ SpringCawKtkApplication.java
│   │   ├─ resources/
│   │   │   └─ application.properties
│   │   └─ webapp/
│   │       └─ WEB-INF/
│   │           └─ views/
│   │               ├─ bootstrap/
│   │               │   └─ bootstrap.jsp
│   │               └─ calendar/
│   │                   └─ Calendar_Kcal_MainPage.jsp
└─ README.txt

🧪 실행 방법
-------------
1. **압축 해제**
   - 이 ZIP 파일을 원하는 위치에 압축해제

2. **MySQL 설정**
   - MySQL 8.0 이상이 설치되어 있어야 하며, 아래 명령어를 MySQL 콘솔에서 실행:

3. **자바 버전**
   - 자바 21 버전을 사용할것

4. **스프링 버전**
   - 스프링 2.7을 사용할것

```sql
CREATE DATABASE SpringUnivDB CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE USER 'KTKCAW'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON SpringUnivDB.* TO 'KTKCAW'@'localhost';
FLUSH PRIVILEGES;

```실행
SpringCawKtkApplication.java 파일을 실행

```주의사항 
git pull 을 먼저 할것 
