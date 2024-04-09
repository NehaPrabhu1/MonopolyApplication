/* DDL statements - Create tables*/
create table player(playername varchar(50) primary key,amount int, 
					placeid int, constraint fk_place foreign key(placeid) references place(placeid));

create table place(placeid serial primary key, 
				   placename varchar(100), 
				   buyprice int, 
				   rent int,  
				   boughtby varchar(50));
				   
create table game(gameid serial primary key,
				 playername varchar(50),
				 placeid int, 
				 buy boolean,
				 rent boolean,
				 constraint fk_player foreign key(playername) references player(playername),
				 constraint fk_place foreign key(placeid) references place(placeid));

/* DML statements*/
insert into player values ('p1',1000,1);
insert into player values ('p2',1000,1);


insert into place(placename,buyprice,rent,boughtby) values('start', 0,0,null);
insert into place(placename,buyprice,rent,boughtby) values('Old Kent Road', 60,30,null);
insert into place(placename,buyprice,rent,boughtby) values('Whitechapel Road', 60,30,null);
insert into place(placename,buyprice,rent,boughtby) values('King''s Cross station', 200,100,null);
insert into place(placename,buyprice,rent,boughtby) values('The Angel Islington', 100,50,null);
insert into place(placename,buyprice,rent,boughtby) values('Euston Road', 100,50,null);
insert into place(placename,buyprice,rent,boughtby) values('Pentonville Road', 120,60,null);
insert into place(placename,buyprice,rent,boughtby) values('Pall Mall', 140,70,null);
insert into place(placename,buyprice,rent,boughtby) values('Whitehall', 140,70,null);
insert into place(placename,buyprice,rent,boughtby) values('Northumberland Avenue', 160,80,null);
insert into place(placename,buyprice,rent,boughtby) values('Marylebone station', 200,100,null);


select * from player;

select * from place;

select * from game;




