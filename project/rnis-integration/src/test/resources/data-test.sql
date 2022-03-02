insert into municipality(id, name)
values (1, 'МО1'),
       (2, 'МО2'),
       (3, 'МО3');
insert into transport_type(id, name)
values (1, 'Тип транспорта1'),
       (2, 'Тип транспорта2'),
       (3, 'Тип транспорта3');
insert into organization(id, name)
values (1, 'Организация1'),
       (2, 'Организация2'),
       (3, 'Организация3');
insert into transport_unit(id, object_name, phone_of_responsible, information_date, longitude, latitude,
                           speed, direction, municipality_id, transport_type_id, organization_id)
values (1, 'объект1', 'телефон1', '2022-02-02T00:56:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 1, 1, 1),
       (2, 'объект2', 'телефон2', '2022-02-02T00:51:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 2, 2, 2),
       (3, 'объект3', 'телефон3', '2022-02-02T00:52:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 3, 3, 3),
       (4, 'объект4', 'телефон4', '2022-02-02T00:53:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 1, 1, 1),
       (5, 'объект5', 'телефон5', '2022-02-02T00:54:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 1, 1, 2);
insert into navigation_information(id, information_date, longitude, latitude, speed, direction, transport_unit_id)
values (1, '2022-02-02T00:50:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 1),
       (2, '2022-02-02T00:51:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 2),
       (3, '2022-02-02T00:52:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 3),
       (4, '2022-02-02T00:53:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 4),
       (5, '2022-02-02T00:54:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 5),
       (6, '2022-02-02T00:55:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 1),
       (7, '2022-02-02T00:56:03Z', 45.1234, 45.1234, '100 км/ч', 100.0, 1);