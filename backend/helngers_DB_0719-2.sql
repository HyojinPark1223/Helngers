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
  `id` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
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
  `id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `user_id` INT NULL,
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
  `id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `user_id` INT NULL,
  `url` VARCHAR(300) NULL,
  PRIMARY KEY (`id`),
  INDEX `challenges_user_id_to_users_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `challenges_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`articles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`articles` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `user_id` INT NULL,
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
-- Table `Helngers`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`comments` (
  `id` INT NOT NULL,
  `user_id` INT NULL,
  `article_id` INT NULL,
  `content` TEXT NULL,
  `created_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `comments_user_id_to_users_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `comments_user_id_to_article_id_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `comments_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `comments_user_id_to_article_id`
    FOREIGN KEY (`article_id`)
    REFERENCES `Helngers`.`articles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`columns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`columns` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `user_id` INT NULL,
  `comment_id` INT NULL,
  `created_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `column_user_id_to_users_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `columns_comment_id_to_comments_id_idx` (`comment_id` ASC) VISIBLE,
  CONSTRAINT `column_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `columns_comment_id_to_comments_id`
    FOREIGN KEY (`comment_id`)
    REFERENCES `Helngers`.`comments` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`like` (
  `like_target` INT NOT NULL,
  `liker` INT NULL,
  PRIMARY KEY (`like_target`),
  INDEX `like_liker_to_users_id_idx` (`liker` ASC) VISIBLE,
  CONSTRAINT `like_like_target_to_columns_id`
    FOREIGN KEY (`like_target`)
    REFERENCES `Helngers`.`columns` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `like_liker_to_users_id`
    FOREIGN KEY (`liker`)
    REFERENCES `Helngers`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`article_files`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`article_files` (
  `id` INT NOT NULL,
  `url` VARCHAR(300) NULL,
  `article_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `article_files_article_id_to_article_id_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `article_files_article_id_to_article_id`
    FOREIGN KEY (`article_id`)
    REFERENCES `Helngers`.`articles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`column_files`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`column_files` (
  `id` INT NOT NULL,
  `url` VARCHAR(300) NULL,
  `column_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `column_files_column_id_to_column_id_idx` (`column_id` ASC) VISIBLE,
  CONSTRAINT `column_files_column_id_to_column_id`
    FOREIGN KEY (`column_id`)
    REFERENCES `Helngers`.`columns` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers`.`article_like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers`.`article_like` (
  `like_target` INT NOT NULL,
  `liker` INT NULL,
  PRIMARY KEY (`like_target`),
  INDEX `article_like_liker_to_users_id_idx` (`liker` ASC) VISIBLE,
  CONSTRAINT `article_like_like_target_to_articles_id`
    FOREIGN KEY (`like_target`)
    REFERENCES `Helngers`.`articles` (`id`)
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
  `users_id` INT NOT NULL,
  `users_id1` INT NOT NULL,
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
