-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Genereishop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Genereishop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Genereishop` DEFAULT CHARACTER SET utf8 ;
USE `Genereishop` ;

-- -----------------------------------------------------
-- Table `Genereishop`.`Adress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Genereishop`.`Adress` (
  `adressId` INT NOT NULL AUTO_INCREMENT,
  `adressState` VARCHAR(45) NOT NULL,
  `adressZip` INT(5) UNSIGNED NOT NULL,
  `adressStreet` VARCHAR(45) NOT NULL,
  `adressExtNum` VARCHAR(30) NOT NULL,
  `adressIntNum` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`adressId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Genereishop`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Genereishop`.`User` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(100) NOT NULL,
  `userPhone` BIGINT UNSIGNED NOT NULL,
  `userEmail` VARCHAR(100) NOT NULL,
  `userPassword` VARCHAR(45) NOT NULL,
  `Adress_adressId` INT NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userEmail_UNIQUE` (`userEmail` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Genereishop`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Genereishop`.`Product` (
  `productId` INT NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(50) NOT NULL,
  `productDescription` VARCHAR(70) NOT NULL,
  `productPrice` FLOAT UNSIGNED NOT NULL,
  `productStock` INT ZEROFILL UNSIGNED NOT NULL,
  `productImage` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`productId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Genereishop`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Genereishop`.`Order` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `orderDate` DATE NOT NULL,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`orderId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Genereishop`.`Order_has_Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Genereishop`.`Order_has_Product` (
  `Order_orderId_fk` INT NOT NULL,
  `Product_productId_fk` INT NOT NULL,
  `Order_has_Product_Quantity` INT UNSIGNED NOT NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
