//create table userinfo (
//  username varchar2(20),
//  password varchar2(20),
//  identity varchar2(10),
//  constraints pk_userinfo primary key (username)  
//);

insert into userinfo values('郝得然', '123456', '管理员');

create table bookinfo (
  bookid varchar2(20) not null,
  category varchar2(20),
  bookname varchar2(50) not null,
  author varchar2(30),
  press varchar2(30),
  bid numeric(4,2),
  price numeric(4,2),
  storage int,
  constraints pk_book_id primary key(bookid)
);

alter table bookinfo modify(press varchar2(50)); 
alter table bookinfo modify(bookname varchar2(100)); 
insert into bookinfo values('HHSD-0000','计算机','Java语言程序设计基础版','Y.Daniel Liang','机械工业出版社','60.00','75.00',213);


//create table sellrecord (
//  bookid varchar2(20) not null,
//  bookname varchar2(50) not null,
//  bid numeric(4,2),
//  price numeric(4,2),
//  quantity int not null，
//  totalprice numeric(8,2),
//  buydate date not null,
//  profit numeric(8,2),
//  constraints fk_sellrecord_bookid foreign key (bookid) references bookinfo (bookid)
//)

//create table sellrecord (
//  recordid int primary key,
//  bookid varchar2(20) not null,
//  quantity int not null，
//  totalprice numeric(8,2),
//  buydate date not null,
//  profit numeric(8,2),
//  constraints fk_sellrecord_bookid foreign key (bookid) references bookinfo (bookid)
//);

//create sequence SEQUENCE_RECORD                       
//minvalue 1               
//maxvalue 999999999999999999999999999  
//start with 1 
//increment by 1
//cache 20; 

//create trigger "trigger_record" before
//insert on sellrecord for each row when(new.recordid is null)
//begin
//select SEQUENCE_RECORD .nextval into:new.recordid from dual;
//end; 

//drop table sellrecord;



