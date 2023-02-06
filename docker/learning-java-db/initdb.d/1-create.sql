use training;

-- テーブル作成
DROP TABLE IF EXISTS employee_training;
-- 社員テーブル作成
CREATE TABLE employee_training(
    employee_id   int NOT NULL AUTO_INCREMENT
  , employee_name varchar(50) NOT NULL
  , phonetic      varchar(50) 
  , gender        int(1)    NOT NULL
  , birthday      DATE         NOT NULL
  , entering_date DATE         NOT NULL
  , fresher_flag  int(1)    DEFAULT 0 NOT NULL
  , division_cd   varchar(20) NOT NULL
  , CONSTRAINT PK_EMPLOYEE_TRAINING PRIMARY KEY (employee_id)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS division_training;
-- 部署テーブル作成SQL
CREATE TABLE division_training(
    division_cd varchar(20)  NOT NULL
  , division_name varchar(100)
  , CONSTRAINT PK_DIVISION_TRAINING PRIMARY KEY (division_cd)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS expense_training;
CREATE TABLE expense_training(
    expense_id     int     NOT NULL
  , employee_id    int     NOT NULL
  , recorded_date  DATE    NOT NULL
  , expense_amount int     NOT NULL
  , purpose        VARCHAR(100)
  , CONSTRAINT PK_EXPENSE_TRAINING PRIMARY KEY (expense_id)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS message_board;
CREATE TABLE message_board(
    id int NOT NULL
  , name VARCHAR(50)
  , message VARCHAR(100)
  , created_at TIMESTAMP
  , CONSTRAINT PK_MESSAGE_BOARD PRIMARY KEY (id)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC DEFAULT CHARSET=utf8mb4;
