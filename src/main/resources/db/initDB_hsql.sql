DROP TABLE ROLES IF EXISTS;
DROP TABLE DISHES IF EXISTS;
DROP TABLE VOTES IF EXISTS;
DROP TABLE MENU IF EXISTS;
DROP TABLE USERS IF EXISTS;
DROP TABLE ROLE IF EXISTS;
DROP TABLE DISH IF EXISTS;
DROP TABLE RESTAURANT IF EXISTS;

DROP SEQUENCE ROLES_SEQ IF EXISTS;
DROP SEQUENCE DISHES_SEQ IF EXISTS;
DROP SEQUENCE VOTES_SEQ IF EXISTS;
DROP SEQUENCE MENU_SEQ IF EXISTS;
DROP SEQUENCE USERS_SEQ IF EXISTS;
DROP SEQUENCE ROLE_SEQ IF EXISTS;
DROP SEQUENCE DISH_SEQ IF EXISTS;
DROP SEQUENCE RESTAURANT_SEQ IF EXISTS;

CREATE SEQUENCE ROLES_SEQ AS INTEGER START WITH 10000;
CREATE SEQUENCE DISHES_SEQ AS INTEGER START WITH 10000;
CREATE SEQUENCE VOTES_SEQ AS INTEGER START WITH 10000;
CREATE SEQUENCE MENU_SEQ AS INTEGER START WITH 10000;
CREATE SEQUENCE USERS_SEQ AS INTEGER START WITH 10000;
CREATE SEQUENCE ROLE_SEQ AS INTEGER START WITH 10000;
CREATE SEQUENCE DISH_SEQ AS INTEGER START WITH 10000;
CREATE SEQUENCE RESTAURANT_SEQ AS INTEGER START WITH 10000;

CREATE TABLE users
(
    id               INTEGER GENERATED BY DEFAULT AS SEQUENCE USERS_SEQ PRIMARY KEY,
    name             VARCHAR(255)            NOT NULL,
    email            VARCHAR(255)            NOT NULL,
    password         VARCHAR(255)            NOT NULL,
    registered       TIMESTAMP DEFAULT now() NOT NULL,
    enabled          BOOLEAN   DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
    ON users (email);

CREATE TABLE role
(
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE ROLE_SEQ PRIMARY KEY,
    name    VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX role_unique_name_idx
    ON role (name);

CREATE TABLE dish
(
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE DISH_SEQ PRIMARY KEY,
    name    VARCHAR(255)        NOT NULL
);
CREATE UNIQUE INDEX dish_unique_name_idx
    ON dish (name);

CREATE TABLE restaurant
(
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE RESTAURANT_SEQ PRIMARY KEY,
    name    VARCHAR(255)        NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_name_idx
    ON restaurant (name);

CREATE TABLE roles
(
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE ROLES_SEQ PRIMARY KEY,
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX roles_unique_user_role_idx
    ON roles (user_id, role_id);

CREATE TABLE menu
(
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE MENU_SEQ PRIMARY KEY,
    date    DATE    NOT NULL,
    restaurant_id INTEGER NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX menu_unique_date_restaurant_idx
    ON menu (date, restaurant_id) ;

CREATE TABLE dishes
(
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE DISHES_SEQ PRIMARY KEY,
    menu_id INTEGER NOT NULL,
    dish_id INTEGER NOT NULL,
    price   INT     DEFAULT 0   NOT NULL,
    FOREIGN KEY (menu_id) REFERENCES menu (id) ON DELETE CASCADE,
    FOREIGN KEY (dish_id) REFERENCES dish (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX dishes_unique_menu_dish_idx
    ON dishes (menu_id, dish_id);

CREATE TABLE votes
(
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE VOTES_SEQ PRIMARY KEY,
    user_id INTEGER NOT NULL,
    menu_id INTEGER NOT NULL,
    FOREIGN KEY (menu_id) REFERENCES menu (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX votes_unique_user_menu_idx
    ON votes (user_id, menu_id);

