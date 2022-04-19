# Restaurant Rating System
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/70bd5f79e068465da9562a21d6f7eae5)](https://app.codacy.com/gh/KVostok/RestaurantRatingSystem?utm_source=github.com&utm_medium=referral&utm_content=KVostok/RestaurantRatingSystem&utm_campaign=Badge_Grade_Settings)
[![Build Status](https://travis-ci.com/KVostok/RestaurantRatingSystem.svg?branch=master)](https://travis-ci.com/KVostok/RestaurantRatingSystem)

---
### _A voting system REST API using Hibernate/Spring/SpringMVC_
[_Demo_](https://restvoting-kvostok.koyeb.app) on [_Koyeb.com_](https://www.koyeb.com/)
_(Koyeb - The fastest way to deploy applications globally)_<br>
* [_REST Api Documentation_](https://restvoting-kvostok.koyeb.app/swagger-ui.html)<br>

Credentials:
|Username|Password|
|---|---|
| `user1@yandex.ru` | `password` |
| `admin@gmail.com` | `admin` |

---
### _Terms of reference_
Voting system for deciding where to have lunch.

 * 2 types of users: admin and regular users
 * Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
 * Menu changes each day (admins do the updates)
 * Users can vote on which restaurant they want to have lunch at
 * Only one vote counted per user
 * If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed.

Each restaurant provides new menu each day.

---
### _Steps to launch app_
Build:<br>
`mvn -B -DskipTests=true clean package`<br>

Using by Docker:<br>
(By default dockerfile uses image from docker hub. To custom from local image uncomment first 8 lines in dockerfile and comment 13th line.)
* `docker build . -t restvoting`<br>
* `docker run -p 8080:8080 -t restvoting`<br>
* _Open in browser: [localhost:8080](http://localhost:8080)_<br>

---
### _REST Api Documentation:_<br>
[_Api docs_](http://localhost:8080/v2/api-docs)<br>
[_Swagger-ui_](http://localhost:8080/swagger-ui.html)<br>

---
[Список моих пет-проектов на Github page](https://kvostok.github.io/my-pet-projects/)
