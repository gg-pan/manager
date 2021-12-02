-- INSERT ONE DEFAULT user
DELETE FROM manager_user WHERE name = 'admin';

INSERT INTO manager_user(id, create_on, update_on, version, ref_no, latest, status, name, email, phone_num, password)
VALUES(sys_uuid(), now(), now(), 1, 'USER202111-0001', TRUE, TRUE, 'admin', 'admin@admin.com', '123456789', 'admin');
