insert into authors(name)
values ('fio1'),
       ('fio2'),
       ('fio3');
insert into genres(name)
values ('genre1'),
       ('genre2'),
       ('genre3');
insert into books(name, author_id, genre_id)
values ('book1', 1, 1),
       ('book2', 2, 2),
       ('book3', 3, 3);