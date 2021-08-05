INSERT INTO employee (international_name) VALUES ('Member 1');
INSERT INTO employee (international_name) VALUES ('Member 2');
INSERT INTO employee (international_name) VALUES ('Member 3');
INSERT INTO employee (international_name) VALUES ('Member 4');
INSERT INTO employee (international_name) VALUES ('Member 5');
INSERT INTO employee (international_name) VALUES ('Member 6');
INSERT INTO employee (international_name) VALUES ('Member 7');
INSERT INTO employee (international_name) VALUES ('Member 8');
INSERT INTO employee (international_name) VALUES ('Member 9');
INSERT INTO employee (international_name) VALUES ('Member 10');

INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-08-03 14:38:33.000000', '2021-08-03 14:38:33.000000', 1);
INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-09-03 14:38:33.000000', '2021-08-04 14:38:33.000000', 2);
INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-10-03 14:38:33.000000', '2021-08-05 14:38:33.000000', 3);
INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-11-03 14:38:33.000000', '2021-08-06 14:38:33.000000', 4);
INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-12-03 14:38:33.000000', '2021-08-07 14:38:33.000000', 5);
INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-03-03 14:38:33.000000', '2021-08-08 14:38:33.000000', 6);
INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-04-03 14:38:33.000000', '2021-08-09 14:38:33.000000', 7);
INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-05-03 14:38:33.000000', '2021-08-10 14:38:33.000000', 8);
INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-06-03 14:38:33.000000', '2021-08-11 14:38:33.000000', 9);
INSERT INTO member (offboard_date, onboard_date, employee_id) VALUES ('2021-07-03 14:38:33.000000', '2021-08-12 14:38:33.000000', 10);

INSERT INTO email (content, subject, created_by_id) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing.', 'Pellentesque at', 1);
INSERT INTO email (content, subject, created_by_id) VALUES ('Nunc quis ultrices elit. Nullam eros turpis.', 'Nunc eu', 1);
INSERT INTO email (content, subject, created_by_id) VALUES ('Quisque orci sem, cursus sed laoreet eget.', 'Sed rutrum', 1);
INSERT INTO email (content, subject, created_by_id) VALUES ('Etiam in dictum nulla. Nullam nisl lectus.', 'Aliquam erat', 2);
INSERT INTO email (content, subject, created_by_id) VALUES ('Extum talis eleates est.', 'Pellentesque habitant', 2);

INSERT INTO email_recipient (email, member) VALUES (1, 2);
INSERT INTO email_recipient (email, member) VALUES (1, 3);