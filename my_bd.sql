-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema test_project_bd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test_project_bd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test_project_bd` DEFAULT CHARACTER SET utf8 ;
USE `test_project_bd` ;

-- -----------------------------------------------------
-- Table `test_project_bd`.`masters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project_bd`.`masters` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `rate` INT NOT NULL,
  `services` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `test_project_bd`.`services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project_bd`.`services` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `estimat_time` BIGINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `test_project_bd`.`masters_has_services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project_bd`.`masters_has_services` (
  `masters_id` INT NOT NULL,
  `services_id` INT NOT NULL,
  PRIMARY KEY (`masters_id`, `services_id`),
  INDEX `fk_masters_has_services_services1_idx` (`services_id` ASC) VISIBLE,
  INDEX `fk_masters_has_services_masters1_idx` (`masters_id` ASC) VISIBLE,
  CONSTRAINT `fk_masters_has_services_masters1`
    FOREIGN KEY (`masters_id`)
    REFERENCES `test_project_bd`.`masters` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_masters_has_services_services1`
    FOREIGN KEY (`services_id`)
    REFERENCES `test_project_bd`.`services` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `test_project_bd`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project_bd`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `test_project_bd`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project_bd`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nameandsurname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role_role_id` INT NOT NULL,
  PRIMARY KEY (`id`, `role_role_id`),
  UNIQUE INDEX `login_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_users_role1_idx` (`role_role_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_role1`
    FOREIGN KEY (`role_role_id`)
    REFERENCES `test_project_bd`.`role` (`role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `test_project_bd`.`record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project_bd`.`record` (
  `record_id` INT NOT NULL AUTO_INCREMENT,
  `users_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `stage` TINYINT NULL DEFAULT NULL,
  `status_for_admin` TINYINT NULL DEFAULT NULL,
  `start_time` TIME NOT NULL,
  `ending_time` TIME NOT NULL,
  `service` VARCHAR(45) NOT NULL,
  `master_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`record_id`, `users_id`),
  INDEX `fk_record_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_record_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `test_project_bd`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 57
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `test_project_bd`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project_bd`.`review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `review_text` VARCHAR(200) NOT NULL,
  `date` DATETIME NOT NULL,
  `users_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `master_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_review_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `test_project_bd`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `test_project_bd`.`services_has_record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project_bd`.`services_has_record` (
  `services_id` INT NOT NULL,
  `record_record_id` INT NOT NULL,
  `record_users_id` INT NOT NULL,
  PRIMARY KEY (`services_id`, `record_record_id`, `record_users_id`),
  INDEX `fk_services_has_record_record1_idx` (`record_record_id` ASC, `record_users_id` ASC) VISIBLE,
  INDEX `fk_services_has_record_services1_idx` (`services_id` ASC) VISIBLE,
  CONSTRAINT `fk_services_has_record_record1`
    FOREIGN KEY (`record_record_id`)
    REFERENCES `test_project_bd`.`record` (`record_id`),
  CONSTRAINT `fk_services_has_record_services1`
    FOREIGN KEY (`services_id`)
    REFERENCES `test_project_bd`.`services` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
