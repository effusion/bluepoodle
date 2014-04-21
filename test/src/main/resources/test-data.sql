insert into publisher (id, version, username, email, firstname, lastname) values (1, 0, 'heuby', 'andreas.heubeck@atos', 'Andreas', 'Heubeck');
insert into publisher (id, version, username, email, firstname, lastname) values (2, 0, 'andi', 'andreas.kuhtz@atos.ch', 'Andreas', 'Kuhtz');
insert into publisher (id, version, username, email, firstname, lastname) values (3, 0, 'paule', 'pascal.seufert@atos.ch', 'Pascal', 'Seufert');
insert into publisher (id, version, username, email, firstname, lastname) values (4, 0, 'publisher', 'publisher@atos.ch', 'publisher', 'publisher');

insert into subscriber (id, version, username, email, firstname, lastname) values (1, 0, 'martin', 'martin.goebel@atos.ch', 'Martin', 'Goebel');
insert into subscriber (id, version, username, email, firstname, lastname) values (2, 0, 'dani', 'daniel.grimm@atos.ch', 'Daniel', 'Grimm');
insert into subscriber (id, version, username, email, firstname, lastname) values (3, 0, 'mächi', 'patrick.maechler@atos.ch', 'Patrick', 'Mächler');
insert into subscriber (id, version, username, email, firstname, lastname) values (4, 0, 'heuby', 'heuby@gmx.ch', 'Andreas', 'Heubeck');

insert into eventtype (id, version, name, publisher_id) values (1, 0, 'Entwicklerkonferenz', 2)
insert into eventtype (id, version, name, publisher_id) values (2, 0, 'Tech-Talk', 2)

insert into location (id, version, name, description) values (1, 0, 'Moscone Center', 'San Francisco')
insert into location (id, version, name, description) values (2, 0, 'Technopark', 'Zürich')
insert into location (id, version, name, description) values (3, 0, 'The Westin Grand Hotel', 'München')
insert into location (id, version, name, description) values (4, 0, 'Estrel' , 'Berlin')
insert into location (id, version, name, description) values (5, 0, 'Shilcity' , 'Zürich')

insert into eventtype_location_assoc (location_id, eventtype_id) values (1, 1)
insert into eventtype_location_assoc (location_id, eventtype_id) values (3, 1)
insert into eventtype_location_assoc (location_id, eventtype_id) values (2, 2)

insert into event (id, version, name, eventtype_id, location_id, publisher_id, state) values (1, 0, 'JavaOne', 1, 1, 2, 'CONFIRMED')
insert into event (id, version, name, eventtype_id, location_id, publisher_id, state) values (2, 0, 'W-JAX', 1, 3, 2, 'PLANNED')
insert into event (id, version, name, eventtype_id, location_id, publisher_id, state) values (3, 0, 'Jazoon', 1, 5, 2, 'PLANNED')

insert into subscription (subscriber_id, event_id, comment) values (1, 2, 'Some text.')
insert into subscription (subscriber_id, event_id, comment) values (4, 1, 'Java Roxs.')