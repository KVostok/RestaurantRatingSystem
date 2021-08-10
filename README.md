# Restaurant Rating System

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/70bd5f79e068465da9562a21d6f7eae5)](https://app.codacy.com/gh/KVostok/RestaurantRatingSystem?utm_source=github.com&utm_medium=referral&utm_content=KVostok/RestaurantRatingSystem&utm_campaign=Badge_Grade_Settings)
[![Build Status](https://travis-ci.com/KVostok/RestaurantRatingSystem.svg?branch=master)](https://travis-ci.com/KVostok/RestaurantRatingSystem)

_A voting system REST API using Hibernate/Spring/SpringMVC_.

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
<a href="https://kvostok.github.io/my-pet-projects/">Список моих пет-проектов на Github page</a>
