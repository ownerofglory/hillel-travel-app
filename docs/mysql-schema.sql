CREATE TABLE t_user (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(255) NOT NULL UNIQUE,
                        email VARCHAR(255) NOT NULL UNIQUE,
                        password VARCHAR(255) NOT NULL,
                        profile_picture VARCHAR(512),
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE t_travel_entry (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                user_id INT,
                                title VARCHAR(255),
                                description TEXT,
                                entry_date DATETIME,
                                created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                FOREIGN KEY (user_id) REFERENCES t_user(id)
);

CREATE TABLE t_location (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            entry_id INT,
                            latitude DECIMAL(9,6),
                            longitude DECIMAL(9,6),
                            location_name VARCHAR(255),
                            created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (entry_id) REFERENCES t_travel_entry(id)
);

CREATE TABLE t_comment (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           entry_id INT,
                           user_id INT,
                           comment_text TEXT,
                           created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (entry_id) REFERENCES t_travel_entry(id),
                           FOREIGN KEY (user_id) REFERENCES t_user(id)
);

CREATE TABLE t_like (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        entry_id INT,
                        user_id INT,
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (entry_id) REFERENCES t_travel_entry(id),
                        FOREIGN KEY (user_id) REFERENCES t_user(id)
);
