INSERT INTO t_user (username, email, password, profile_picture) VALUES
                                                                    ('john_doe', 'john.doe@example.com', 'password1', 'john_profile.jpg'),
                                                                    ('jane_doe', 'jane.doe@example.com', 'password2', 'jane_profile.jpg'),
                                                                    ('sarah_smith', 'sarah.smith@example.com', 'password3', 'sarah_profile.jpg'),
                                                                    ('mike_brown', 'mike.brown@example.com', 'password4', 'mike_profile.jpg');

INSERT INTO t_travel_entry (user_id, title, description, entry_date) VALUES
                                                                         (1, 'Trip to Paris', 'It was an amazing trip!', '2023-07-10'),
                                                                         (2, 'Beach Vacation', 'Relaxing by the sea.', '2023-06-15'),
                                                                         (3, 'Hiking Adventure', 'Climbed the highest peak!', '2023-04-22'),
                                                                         (4, 'Weekend Getaway', 'A lovely weekend escape.', '2023-05-05');

INSERT INTO t_location (entry_id, latitude, longitude, location_name) VALUES
                                                                          (1, 48.8566, 2.3522, 'Paris'),
                                                                          (2, 36.7783, -119.4179, 'California Beach'),
                                                                          (3, 40.7128, -74.0060, 'Mountain Peak'),
                                                                          (4, 41.9028, 12.4964, 'Rome');

INSERT INTO t_comment (entry_id, user_id, comment_text) VALUES
                                                            (1, 2, 'Looks fun!'),
                                                            (2, 1, 'I am jealous!'),
                                                            (2, 3, 'Wow!'),
                                                            (3, 4, 'Amazing view!'),
                                                            (4, 1, 'Great place!');

INSERT INTO t_like (entry_id, user_id) VALUES
                                           (1, 2),
                                           (1, 3),
                                           (2, 1),
                                           (3, 4),
                                           (4, 2),
                                           (4, 3),
                                           (4, 1);
