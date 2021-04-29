create table tribble(
id serial primary key ,
name text , 
size int ,
color text ,
age int, 
number_of_hairs int 

)

create table labs (
id serial primary key ,
address text , 
zip text ,
country text

)


create table tribbleXlabs(
tribbleId int REFERENCES tribble (id) ON DELETE CASCADE ,
labId int 

)


INSERT INTO public.labs
(address, zip, country)
VALUES('140th', '3421', 'US');

INSERT INTO public.labs
(address, zip, country)
VALUES('150th', '33213', 'US');

INSERT INTO public.labs
(address, zip, country)
VALUES('230th', '9999', 'US');

INSERT INTO public.tribble
("name", "size", color, age, number_of_hairs)
VALUES('John', 423, 'Red', 2, 423424);


INSERT INTO public.tribble
("name", "size", color, age, number_of_hairs)
VALUES('Dan', 12, 'Blue', 20, 17);

INSERT INTO public.tribble
("name", "size", color, age, number_of_hairs)
VALUES('Ringo', 32, 'Yellow', 1, 123123);

INSERT INTO public.tribble
("name", "size", color, age, number_of_hairs)
VALUES('Paul', 23, 'Orange', 1, 2);

INSERT INTO public.tribble
("name", "size", color, age, number_of_hairs)
VALUES('George', 2, 'Red', 55, 23);

INSERT INTO public.tribble
("name", "size", color, age, number_of_hairs)
VALUES('Star', 42, 'Green', 21, 32);



INSERT INTO public.tribblexlabs
(tribbleid, labid)
VALUES(1, 1);

INSERT INTO public.tribblexlabs
(tribbleid, labid)
VALUES(2, 1);

INSERT INTO public.tribblexlabs
(tribbleid, labid)
VALUES(3, 1);


INSERT INTO public.tribblexlabs
(tribbleid, labid)
VALUES(5, 2);



