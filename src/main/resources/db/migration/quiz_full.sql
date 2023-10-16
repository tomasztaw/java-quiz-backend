CREATE TABLE Quiz (
    id                 SERIAL          PRIMARY KEY,
    category           VARCHAR(128)     NOT NULL,
    difficulty_level   VARCHAR(128)     NOT NULL,
    question           VARCHAR(128)     NOT NULL,
    answer_a           VARCHAR(128)     NOT NULL,
    answer_b           VARCHAR(128)     NOT NULL,
    answer_c           VARCHAR(128)     NOT NULL,
    answer_d           VARCHAR(128)     NOT NULL,
    correct_answer     VARCHAR(128)     NOT NULL,
);

INSERT INTO Quiz (category, difficulty_level, question, answer_a, answer_b, answer_c, answer_d, correct_answer)
VALUES
('Java', 'easy', 'Jakie jest typowanie w Javie?', 'silne', 'słabe', 'żadne', 'obiektowe', 'silne'),
('Java', 'easy', 'Co jaki czas pojawiają się obecnie nowe wersje Javy?', 'nie ma ustalonego czasu', 'co roku', 'co 6 miesięcy', 'co dwa lata', 'co 6 miesięcy'),
('Java', 'easy', 'Do czego służy Garbage Collector w Javie?', 'pierwsze słyszę', 'do zarządzania pamięcią', 'obsługuje metody matematyczne', 'jest to server aplikacji', 'do zarządzania pamięcią'),
('Java', 'easy', 'Pytanie testowe - jak jest', 'super', 'tak sobie', 'ale o co chodzi', 'ok', 'super');