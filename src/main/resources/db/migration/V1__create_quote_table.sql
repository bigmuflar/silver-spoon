USE quotes;
CREATE TABLE quote_data
(
    quote_id INT AUTO_INCREMENT PRIMARY KEY,
    quote VARCHAR(1000) NOT NULL,
    author VARCHAR(50) NOT NULL,
    book VARCHAR(100) NOT NULL,
);