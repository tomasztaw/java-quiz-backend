CREATE TABLE Questions (
    question_id        SERIAL          PRIMARY KEY,
    category           VARCHAR(128)     NOT NULL,
    difficulty_level   VARCHAR(128)     NOT NULL,
    question           VARCHAR(128)     NOT NULL
);

CREATE TABLE Answers (
    answer_id    SERIAL       PRIMARY KEY,
    question_id  INT          NOT NULL REFERENCES Questions(question_id),
    answer       VARCHAR(128) NOT NULL,
    is_correct   BOOLEAN      NOT NULL
);