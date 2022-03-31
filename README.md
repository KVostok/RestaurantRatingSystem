# Restaurant Rating System
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/70bd5f79e068465da9562a21d6f7eae5)](https://app.codacy.com/gh/KVostok/RestaurantRatingSystem?utm_source=github.com&utm_medium=referral&utm_content=KVostok/RestaurantRatingSystem&utm_campaign=Badge_Grade_Settings)
[![Build Status](https://travis-ci.com/KVostok/RestaurantRatingSystem.svg?branch=master)](https://travis-ci.com/KVostok/RestaurantRatingSystem)

---
### _A voting system REST API using Hibernate/Spring/SpringMVC_
<a href="https://restvoting-kvostok.koyeb.app">_Demo_</a> on <a href="https://www.koyeb.com/">_Koyeb.com_</a>
_(Koyeb - The fastest way to deploy applications globally)_</br>
(Authorize with: _user1@yandex.ru / password_ for user role or _admin@gmail.com / admin_ for admin role)</br>
* <a href="https://restvoting-kvostok.koyeb.app/swagger-ui.html">_REST Api Documentation_</a></br>

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
### _Steps to run app_
Using by Docker:<br>
* _docker build . -t restvoting_<br>
* _docker run -p 8080:8080 -t restvoting_<br>
* _Open in browser: <a href="http://localhost:8080">localhost:8080</a>_</br>

---
### _REST Api Documentation:_</br>
<a href="http://localhost:8080/v2/api-docs">_Api docs_</a></br>
<a href="http://localhost:8080/swagger-ui.html">_Swagger-ui_</a></br>

---
<a href="https://kvostok.github.io/my-pet-projects/">Список моих пет-проектов на Github page</a>
