-- INSERT ONE DEFAULT seq
INSERT INTO manager_sequence
(id, create_on, update_on, "version", ref_no, latest, status, "module", "sequence", prefix)
VALUES(sys_uuid(), now(), now(), 1, 'REFNUM202112-0001', TRUE, TRUE, 'sequence', 1, 'REFNUM');

INSERT INTO manager_sequence
(id, create_on, update_on, "version", ref_no, latest, status, "module", "sequence", prefix)
VALUES(sys_uuid(), now(), now(), 1, 'REFNUM202112-0002', TRUE, TRUE, 'user', 1, 'USER');
