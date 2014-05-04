insert into publisher (id, version, username, email, firstname, lastname) values (1, 0, 'heuby', 'andreas.heubeck@atos', 'Andreas', 'Heubeck');
insert into publisher (id, version, username, email, firstname, lastname) values (2, 0, 'andi', 'andreas.kuhtz@atos.ch', 'Andreas', 'Kuhtz');
insert into publisher (id, version, username, email, firstname, lastname) values (3, 0, 'paule', 'pascal.seufert@atos.ch', 'Pascal', 'Seufert');
insert into publisher (id, version, username, email, firstname, lastname) values (4, 0, 'publisher', 'publisher@atos.ch', 'publisher', 'publisher');

insert into subscriber (id, version, username, email, firstname, lastname) values (5, 0, 'martin', 'martin.goebel@atos.ch', 'Martin', 'Goebel');
insert into subscriber (id, version, username, email, firstname, lastname) values (6, 0, 'dani', 'daniel.grimm@atos.ch', 'Daniel', 'Grimm');
insert into subscriber (id, version, username, email, firstname, lastname) values (7, 0, 'mächi', 'patrick.maechler@atos.ch', 'Patrick', 'Mächler');
insert into subscriber (id, version, username, email, firstname, lastname) values (8, 0, 'heuby', 'heuby@gmx.ch', 'Andreas', 'Heubeck');

insert into eventtype (id, version, name, publisher_id) values (9, 0, 'Entwicklerkonferenz', 2)
insert into eventtype (id, version, name, publisher_id) values (10, 0, 'Tech-Talk', 2)

insert into location (id, version, name, description) values (11, 0, 'Moscone Center', 'San Francisco')
insert into location (id, version, name, description) values (12, 0, 'Technopark', 'Zürich')
insert into location (id, version, name, description) values (13, 0, 'The Westin Grand Hotel', 'München')
insert into location (id, version, name, description) values (14, 0, 'Estrel' , 'Berlin')
insert into location (id, version, name, description) values (15, 0, 'Shilcity' , 'Zürich')

insert into eventtype_location_assoc (location_id, eventtype_id) values (11, 9)
insert into eventtype_location_assoc (location_id, eventtype_id) values (13, 9)
insert into eventtype_location_assoc (location_id, eventtype_id) values (12, 10)

insert into event (id, version, name, eventtype_id, location_id, publisher_id, state) values (16, 0, 'JavaOne', 9, 11, 2, 'CONFIRMED')
insert into event (id, version, name, eventtype_id, location_id, publisher_id, state) values (17, 0, 'W-JAX', 9, 13, 2, 'PLANNED')
insert into event (id, version, name, eventtype_id, location_id, publisher_id, state) values (18, 0, 'Jazoon', 9, 15, 2, 'PLANNED')

insert into subscription (subscriber_id, event_id, comment) values (5, 17, 'Some text.')
insert into subscription (subscriber_id, event_id, comment) values (8, 16, 'Java Roxs.')