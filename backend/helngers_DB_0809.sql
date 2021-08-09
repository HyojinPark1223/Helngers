-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Helngers_0809
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Helngers_0809
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Helngers_0809` DEFAULT CHARACTER SET utf8 ;
USE `Helngers_0809` ;

-- -----------------------------------------------------
-- Table `Helngers_0809`.`medals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`medals` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `goal` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`challenges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`challenges` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `url` VARCHAR(300) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL DEFAULT 'user',
  `count` INT NULL DEFAULT 0,
  `comment_count` INT NULL DEFAULT 0,
  `level` INT NULL DEFAULT 1,
  `introduce` TEXT NULL,
  `point` INT NULL DEFAULT 0,
  `period` INT NULL DEFAULT 0,
  `purpose` INT NULL DEFAULT 0,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`columns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`columns` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `user_id` BIGINT NULL,
  `comment_id` BIGINT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `column_user_id_to_users_id_idx` (`user_id` ASC) INVISIBLE,
  CONSTRAINT `column_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`column_like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`column_like` (
  `like_target` BIGINT NOT NULL,
  `liker` BIGINT NOT NULL,
  PRIMARY KEY (`like_target`),
  INDEX `like_liker_to_users_id_idx` (`liker` ASC) VISIBLE,
  CONSTRAINT `column_like_like_target_to_columns_id`
    FOREIGN KEY (`like_target`)
    REFERENCES `Helngers_0809`.`columns` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `column_like_liker_to_users_id`
    FOREIGN KEY (`liker`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`feeds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`feeds` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `article_categories` VARCHAR(30) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `article_user_id_to_users_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `article_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`feed_files`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`feed_files` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(300) NULL,
  `feed_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `article_files_article_id_to_article_id_idx` (`feed_id` ASC) VISIBLE,
  CONSTRAINT `feed_files_feed_id_to_feed_id`
    FOREIGN KEY (`feed_id`)
    REFERENCES `Helngers_0809`.`feeds` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`column_comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`column_comments` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `column_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `column_comments_column_id_to_columns_id_idx` (`column_id` ASC) VISIBLE,
  INDEX `column_comments_user_id_to_users_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `column_comments_column_id_to_columns_id`
    FOREIGN KEY (`column_id`)
    REFERENCES `Helngers_0809`.`columns` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `column_comments_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`column_files`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`column_files` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(300) NULL,
  `column_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `column_files_column_id_to_column_id_idx` (`column_id` ASC) VISIBLE,
  CONSTRAINT `column_files_column_id_to_column_id`
    FOREIGN KEY (`column_id`)
    REFERENCES `Helngers_0809`.`columns` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`feed_like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`feed_like` (
  `like_target` BIGINT NOT NULL,
  `liker` BIGINT NOT NULL,
  PRIMARY KEY (`like_target`),
  INDEX `article_like_liker_to_users_id_idx` (`liker` ASC) VISIBLE,
  CONSTRAINT `article_like_like_target_to_articles_id`
    FOREIGN KEY (`like_target`)
    REFERENCES `Helngers_0809`.`feeds` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `article_like_liker_to_users_id`
    FOREIGN KEY (`liker`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`followings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`followings` (
  `users_id` BIGINT NOT NULL,
  `users_id1` BIGINT NOT NULL,
  PRIMARY KEY (`users_id`, `users_id1`),
  INDEX `fk_users_has_users_users2_idx` (`users_id1` ASC) VISIBLE,
  INDEX `fk_users_has_users_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `following`
    FOREIGN KEY (`users_id`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `follower`
    FOREIGN KEY (`users_id1`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`challenges_has_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`challenges_has_users` (
  `challenges_id` BIGINT NOT NULL,
  `users_id` BIGINT NOT NULL,
  `isAchieve` TINYINT NOT NULL DEFAULT 0,
  `achievedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`challenges_id`, `users_id`),
  INDEX `fk_challenges_has_users_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_challenges_has_users_challenges1_idx` (`challenges_id` ASC) VISIBLE,
  CONSTRAINT `fk_challenges_has_users_challenges1`
    FOREIGN KEY (`challenges_id`)
    REFERENCES `Helngers_0809`.`challenges` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_challenges_has_users_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`feed_comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`feed_comments` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `feed_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `feed_comments_feed_id_to_feeds_id_idx` (`feed_id` ASC) VISIBLE,
  INDEX `feed_comments_user_id_to_users_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `feed_comments_feed_id_to_feeds_id`
    FOREIGN KEY (`feed_id`)
    REFERENCES `Helngers_0809`.`feeds` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `feed_comments_user_id_to_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Helngers_0809`.`medals_has_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Helngers_0809`.`medals_has_users` (
  `medals_id` BIGINT NOT NULL,
  `users_id` BIGINT NOT NULL,
  `present` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`medals_id`, `users_id`),
  INDEX `fk_medals_has_users_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_medals_has_users_medals1_idx` (`medals_id` ASC) VISIBLE,
  CONSTRAINT `fk_medals_has_users_medals1`
    FOREIGN KEY (`medals_id`)
    REFERENCES `Helngers_0809`.`medals` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medals_has_users_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `Helngers_0809`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET AUTOCOMMIT=TRUE;
