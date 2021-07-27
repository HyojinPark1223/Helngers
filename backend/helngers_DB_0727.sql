-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Helngers
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Helngers
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Helngers` DEFAULT CHARACTER SET utf8 ;
USE `Helngers` ;

-- -----------------------------------------------------
-- Table `Helngers`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`users` (
  `id` BIGINT NOT NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(20) NULL,
  `username` VARCHAR(45) NULL,
  `nickname` VARCHAR(45) NULL,
  `categories` VARCHAR(45) NULL,
  `count` INT NULL,
  `comment_count` INT NULL,
  `level` INT NULL,
  `introduce` TEXT NULL,
  `point` INT NULL,
  `dead` INT NULL,
  `squat` INT NULL,
  `bench` INT NULL,
  `created_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`medals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`medals` (
  `id` BIGINT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `present` INT NULL,
  `goal` INT NULL,
  `user_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `medals_user_id_to_users_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `medals_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`challenges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`challenges` (
  `id` BIGINT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `url` VARCHAR(300) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`columns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`columns` (
  `id` BIGINT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `user_id` BIGINT NULL,
  `comment_id` BIGINT NULL,
  `created_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `column_user_id_to_users_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `column_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`column_like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`column_like` (
  `like_target` BIGINT NOT NULL,
  `liker` BIGINT NULL,
  PRIMARY KEY (`like_target`),
  INDEX `like_liker_to_users_id_idx` (`liker` ASC) VISIBLE,
  CONSTRAINT `column_like_like_target_to_columns_id`
    FOREIGN KEY (`like_target`)
    REFERENCES `Helngers`.`columns` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `column_like_liker_to_users_id`
    FOREIGN KEY (`liker`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`feeds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`feeds` (
  `id` BIGINT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `user_id` BIGINT NULL,
  `article_categories` VARCHAR(30) NULL,
  `created_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `article_user_id_to_users_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `article_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`feed_files`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`feed_files` (
  `id` BIGINT NOT NULL,
  `url` VARCHAR(300) NULL,
  `feed_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `article_files_article_id_to_article_id_idx` (`feed_id` ASC) VISIBLE,
  CONSTRAINT `feed_files_feed_id_to_feed_id`
    FOREIGN KEY (`feed_id`)
    REFERENCES `Helngers`.`feeds` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`column_comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`column_comments` (
  `id` BIGINT NOT NULL,
  `content` TEXT NULL,
  `column_id` BIGINT NULL,
  `created_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `column_comments_column_id_to_columns_id_idx` (`column_id` ASC) VISIBLE,
  CONSTRAINT `column_comments_column_id_to_columns_id`
    FOREIGN KEY (`column_id`)
    REFERENCES `Helngers`.`columns` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`column_files`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`column_files` (
  `id` BIGINT NOT NULL,
  `url` VARCHAR(300) NULL,
  `column_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `column_files_column_id_to_column_id_idx` (`column_id` ASC) VISIBLE,
  CONSTRAINT `column_files_column_id_to_column_id`
    FOREIGN KEY (`column_id`)
    REFERENCES `Helngers`.`columns` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`feed_like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`feed_like` (
  `like_target` BIGINT NOT NULL,
  `liker` BIGINT NULL,
  PRIMARY KEY (`like_target`),
  INDEX `article_like_liker_to_users_id_idx` (`liker` ASC) VISIBLE,
  CONSTRAINT `article_like_like_target_to_articles_id`
    FOREIGN KEY (`like_target`)
    REFERENCES `Helngers`.`feeds` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `article_like_liker_to_users_id`
    FOREIGN KEY (`liker`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`followings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`followings` (
  `users_id` BIGINT NOT NULL,
  `users_id1` BIGINT NOT NULL,
  PRIMARY KEY (`users_id`, `users_id1`),
  INDEX `fk_users_has_users_users2_idx` (`users_id1` ASC) VISIBLE,
  INDEX `fk_users_has_users_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `following`
    FOREIGN KEY (`users_id`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `follower`
    FOREIGN KEY (`users_id1`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`challenges_has_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`challenges_has_users` (
  `challenges_id` BIGINT NOT NULL,
  `users_id` BIGINT NOT NULL,
  `isAchieve` TINYINT NULL,
  `achievedDate` TIMESTAMP NULL,
  PRIMARY KEY (`challenges_id`, `users_id`),
  INDEX `fk_challenges_has_users_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_challenges_has_users_challenges1_idx` (`challenges_id` ASC) VISIBLE,
  CONSTRAINT `fk_challenges_has_users_challenges1`
    FOREIGN KEY (`challenges_id`)
    REFERENCES `Helngers`.`challenges` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_challenges_has_users_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`feed_comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`feed_comments` (
  `id` BIGINT NOT NULL,
  `content` TEXT NULL,
  `feed_id` BIGINT NULL,
  `created_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `feed_comments_feed_id_to_feeds_id_idx` (`feed_id` ASC) VISIBLE,
  CONSTRAINT `feed_comments_feed_id_to_feeds_id`
    FOREIGN KEY (`feed_id`)
    REFERENCES `Helngers`.`feeds` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
