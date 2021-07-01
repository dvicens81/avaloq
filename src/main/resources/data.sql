DROP TABLE IF EXISTS dices;
DROP TABLE IF EXISTS roll;

CREATE TABLE dices (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  number_dice INT NOT NULL,
  side_dice INT NOT NULL,
  total_roll INT NOT NULL
);

CREATE TABLE rolls (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  number_dice INT NOT NULL,
  side_dice INT NOT NULL,
  number INT NOT NULL,
  total INT NOT NULL
);