CREATE TABLE Quiz (
    id                 SERIAL          PRIMARY KEY,
    category           VARCHAR(128)     NOT NULL,
    difficulty_level   VARCHAR(128)     NOT NULL,
    question           VARCHAR(128)     NOT NULL,
    answer_a           VARCHAR(128)     NOT NULL,
    answer_b           VARCHAR(128)     NOT NULL,
    answer_c           VARCHAR(128)     NOT NULL,
    answer_d           VARCHAR(128)     NOT NULL,
    correct_answer     VARCHAR(128)     NOT NULL
);