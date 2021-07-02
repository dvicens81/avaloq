DROP TABLE IF EXISTS dices;
DROP TABLE IF EXISTS roll;
DROP INDEX IF EXISTS number_side_dice_idx;

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

CREATE UNIQUE INDEX number_side_dice_idx ON rolls (number_dice, side_dice);