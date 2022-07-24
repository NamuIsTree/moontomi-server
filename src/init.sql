CREATE TABLE IF NOT EXISTS `album` (
    `album_id` INT NOT NULL AUTO_INCREMENT,
    `artist_id` INT NOT NULL,
    `image_id` INT,
    `tracks` JSON NOT NULL,
    `release` DATETIME NOT NULL,
    PRIMARY KEY (album_id)
)
  ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `artist` (
    `artist_id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `nation` VARCHAR(30) NOT NULL,
    PRIMARY KEY (artist_id)
)
  ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `lecture` (
    `lecture_id` INT NOT NULL AUTO_INCREMENT,
    `album_id` INT NOT NULL,
    `season_id` INT NOT NULL,
    `ymd` DATETIME NOT NULL,
    PRIMARY KEY (lecture_id)
)
  ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `season` (
    `season_id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (season_id)
)
  ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `image` (
    `image_id` INT NOT NULL AUTO_INCREMENT,
    `image` BLOB NOT NULL,
    PRIMARY KEY (image_id)
)
  ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `lecture_comment` (
    `lecture_comment_id` INT NOT NULL AUTO_INCREMENT,
    `lecture_id` INT NOT NULL,
    `user_name` VARCHAR(100) NOT NULL,
    `rating` INT NOT NULL,
    `best1` INT NOT NULL,
    `best2` INT NOT NULL,
    `best3` INT NOT NULL,
    `comment` VARCHAR(2000) NOT NULL,
    PRIMARY KEY (lecture_comment_id)
)
  ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `genre` (
    `genre_id` INT NOT NULL AUTO_INCREMENT,
    `category` VARCHAR(30) NOT NULL,
    `name` VARCHAR(30) NOT NULL,
    PRIMARY KEY (genre_id)
)
  ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;
