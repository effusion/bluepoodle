
    create table Event (
        id bigint generated by default as identity (start with 1),
        version bigint,
        endDate timestamp,
        name varchar(255),
        startDate timestamp,
        state varchar(255),
        eventType_id bigint,
        location_id bigint,
        publisher_id bigint,
        primary key (id)
    );

    create table EventType (
        id bigint generated by default as identity (start with 1),
        version bigint,
        description varchar(255),
        name varchar(255),
        publisher_id bigint,
        primary key (id)
    );

    create table Location (
        id bigint generated by default as identity (start with 1),
        version bigint,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table Publisher (
        id bigint generated by default as identity (start with 1),
        version bigint,
        email varchar(255),
        firstName varchar(255),
        lastName varchar(255),
        userName varchar(255),
        primary key (id)
    );

    create table Subscriber (
        id bigint generated by default as identity (start with 1),
        version bigint,
        email varchar(255),
        firstName varchar(255),
        lastName varchar(255),
        userName varchar(255),
        primary key (id)
    );

    create table Subscription (
        comment varchar(255),
        event_id bigint,
        subscriber_id bigint,
        primary key (event_id, subscriber_id)
    );

    create table eventtype_location_assoc (
        eventtype_id bigint not null,
        location_id bigint not null,
        primary key (eventtype_id, location_id)
    );

    alter table Publisher 
        add constraint UK_iy96bfqgytb65jwmd5986rx6i  unique (email);

    alter table Subscriber 
        add constraint UK_tf9b040pc69q4wew5andgc0qd  unique (email);

    alter table Event 
        add constraint FK_r0cgi9ln6eiajq27i33ex5hhm 
        foreign key (eventType_id) 
        references EventType;

    alter table Event 
        add constraint FK_2805as0f1ibrdfkmeth9hsdip 
        foreign key (location_id) 
        references Location;

    alter table Event 
        add constraint FK_byyu1x9rnusgvlu3d9x6knau1 
        foreign key (publisher_id) 
        references Publisher;

    alter table EventType 
        add constraint FK_fv43wmjnmkrixh8iwf1gbhmbi 
        foreign key (publisher_id) 
        references Publisher;

    alter table Subscription 
        add constraint FK_p9cfmjk7ep69h3su4lk8px19p 
        foreign key (event_id) 
        references Event;

    alter table Subscription 
        add constraint FK_kr6rb2hqvfff55erc7iejv3sl 
        foreign key (subscriber_id) 
        references Subscriber;

    alter table eventtype_location_assoc 
        add constraint FK_23p1ksysesybtdi1t74r30tj2 
        foreign key (location_id) 
        references Location;

    alter table eventtype_location_assoc 
        add constraint FK_3hgcmf9hmoh5qo5mblvnhu4n 
        foreign key (eventtype_id) 
        references EventType;
