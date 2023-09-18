insert into users(user_id, role, username) VALUES (null, 'ROLE_ADMIN', 'admin')
on duplicate key update username = 'admin';
