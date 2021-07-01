DROP TABLE IF EXISTS dices;

CREATE TABLE dices (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  number_dice INT NOT NULL,
  side_dice INT NOT NULL,
  total_roll INT NOT NULL
);