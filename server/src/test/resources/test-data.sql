insert into publisher (personid, username, email, firstname, lastname) values (1, 'heuby', 'andreas.heubeck@atos', 'Andreas', 'Heubeck');
insert into publisher (personid, username, email, firstname, lastname) values (2, 'andi', 'andreas.kuhtz@atos.ch', 'Andreas', 'Kuhtz');
insert into publisher (personid, username, email, firstname, lastname) values (3, 'paule', 'pascal.seufert@atos.ch', 'Pascal', 'Seufert');

insert into subscriber (personid, username, email, firstname, lastname) values (1, 'martin', 'martin.goebel@atos.ch', 'Martin', 'Goebel');
insert into subscriber (personid, username, email, firstname, lastname) values (2, 'dani', 'daniel.grimm@atos.ch', 'Daniel', 'Grimm');
insert into subscriber (personid, username, email, firstname, lastname) values (3, 'mächi', 'patrick.maechler@atos.ch', 'Patrick', 'Mächler');

insert into eventtype (eventtypeid, name, publisher_personid) values (1, 'Entwicklerkonferenz', 2)
insert into eventtype (eventtypeid, name, publisher_personid) values (2, 'Tech-Talk', 2)

insert into location (locationid, name, description) values (1, 'Moscone Center', 'San Francisco')
insert into location (locationid, name, description) values (2, 'Technopark', 'Zürich')
insert into location (locationid, name, description) values (3, 'The Westin Grand Hotel', 'München')
insert into location (locationid, name, description) values (4, 'Estrel' , 'Berlin')
insert into location (locationid, name, description) values (5, 'Shilcity' , 'Zürich')

insert into eventtype_location_assoc (locationid, eventtypeid) values (1, 1)
insert into eventtype_location_assoc (locationid, eventtypeid) values (3, 1)
insert into eventtype_location_assoc (locationid, eventtypeid) values (2, 2)

insert into event (eventid, name, eventtype_eventtypeid, location_locationid, publisher_personid) values (1, 'JavaOne', 1, 1, 2)
insert into event (eventid, name, eventtype_eventtypeid, location_locationid, publisher_personid) values (2, 'W-JAX', 1, 3, 2)
insert into event (eventid, name, eventtype_eventtypeid, location_locationid, publisher_personid) values (3, 'Jazoon', 1, 5, 2)

insert into subscription (personid, eventid, comment) values (2, 2, 'Some text.')