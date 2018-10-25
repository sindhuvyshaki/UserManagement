SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `UserManagement` ;
CREATE SCHEMA IF NOT EXISTS `UserManagement` ;
USE `UserManagement` ;

-- -----------------------------------------------------
-- Table `UserManagement`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UserManagement`.`user` ;

CREATE TABLE IF NOT EXISTS `UserManagement`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Table to store users.';

SET SQL_MODE = '';
GRANT USAGE ON *.* TO AutomatedUser;
 DROP USER AutomatedUser;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'AutomatedUser' IDENTIFIED BY 'AutomatedUser';

GRANT SELECT ON TABLE `UserManagement`.* TO 'AutomatedUser';
GRANT SELECT, INSERT, TRIGGER ON TABLE `UserManagement`.* TO 'AutomatedUser';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `UserManagement`.* TO 'AutomatedUser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
