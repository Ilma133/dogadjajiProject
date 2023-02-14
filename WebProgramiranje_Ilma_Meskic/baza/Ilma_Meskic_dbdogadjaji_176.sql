use meskic_ilma_176_wp

select * from kategorija
select * from lokacija
select * from dogadjaj
select * from user;
select * from role;
select * from user_role;

insert into kategorija values (4, 'https://www.legendsoflearning.com/wp-content/uploads/2020/10/benefits-of-online-learning-graphic.png', 'Ucenje');
insert into kategorija values (5, 'https://www.rtvslon.ba/wp-content/uploads/2021/12/rvk-sport-01102021.jpg', 'Sport');

insert into lokacija values (4, 'Grad na dva kontinenta', 'Istanbul', 'https://tourscanner.com/blog/wp-content/uploads/2021/08/things-to-do-in-Istanbul-Turkey.jpg');
insert into lokacija values (5, '44. najnaseljenija drzava svijeta', 'Malezija', 'https://images.24ur.com/media/images/884xX/Dec2018/65e0cc13b6_62183970.jpg?v=d41d');
delete from dogadjaj where id=6;
insert into dogadjaj values (4, '25.07.2023', 'Edukativno putovanje', 'TrAvElefiL', 'https://www.addiko.hr/financijska-pismenost/static/uploads/2018/12/Moje-savrseno-putovanje-iStock-489525460-min-780x550.jpg', 4, 4);
insert into dogadjaj values (6, '18.02.2023', 'Takmicenje robotike', 'RoboLife' , 'https://www.hippo.id/wp-content/uploads/2021/10/Robotic.jpg', 4, 5);

insert into role values (1, 'ADMIN', 'Pristup svemu');
insert into role values (2, 'USER', 'Ogranicen pristup');


