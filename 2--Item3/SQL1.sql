drop table if exists auditorder;
drop table if exists auditstaff;
drop table if exists audittable;
drop table if exists buydocument;
drop table if exists buyproduct;
drop table if exists bwaylog;
drop table if exists canceldocument;
drop table if exists cancelproduct;
drop table if exists clientmanagement;
drop table if exists code;
drop table if exists colormanagement;
drop table if exists contractdata;
drop table if exists countryport;
drop table if exists departments;
drop table if exists dept;
drop table if exists exportclient;
drop table if exists exportproduct;
drop table if exists filemanager;
drop table if exists folders;
drop table if exists guestorder;
drop table if exists incasementdocument;
drop table if exists incasementproduct;
drop table if exists informationmanagement;
drop table if exists instoredocument;
drop table if exists instoreproduct;
drop table if exists linkman;
drop table if exists logs;
drop table if exists merchant;
drop table if exists orderproduct;
drop table if exists outstoredocument;
drop table if exists outstoreproduct;
drop table if exists paymentbuy;
drop table if exists paymentincase;
drop table if exists privodelog;
drop table if exists producenote;
drop table if exists produceproduct;
drop table if exists productsmanagement;
drop table if exists providemanagement;
drop table if exists reperstorymanagement;
drop table if exists sampledocument;
drop table if exists sampleproduct;
drop table if exists shippingmark;
drop table if exists smalltag;
drop table if exists staffinfo;
drop table if exists steelsinformation;
drop table if exists storymanagement;
drop table if exists test;
drop table if exists units;
create table auditorder (id int(4) not null auto_increment, ordername varchar(50), orderexplain varchar(50), primary key (id));
create table auditstaff (id int(4) not null auto_increment, staffid varchar(50), staffname varchar(50), auditorderid varchar(50), orderid varchar(50), remark varchar(50), primary key (id));
create table audittable (id int(4) not null auto_increment, staffid varchar(50), auditstaffid varchar(50), audittype varchar(50), orderid varchar(50), state varchar(50), audittime varchar(50), remark varchar(50), feedback varchar(50), primary key (id));
create table buydocument (id int(4) not null auto_increment, orderid varchar(50), codes varchar(50), providername varchar(50), address varchar(50), linkman varchar(50), tel varchar(50), times varchar(50), checks varchar(50), emails varchar(50), fax varchar(50), types varchar(50), primary key (id));
create table buyproduct (id int(4) not null auto_increment, buydocumentid varchar(50), specs varchar(50), colors varchar(50), totals varchar(50), simpleprice varchar(50), totalprice varchar(50), notes varchar(50), picurl varchar(50), productid varchar(50), primary key (id));
create table bwaylog (id int(4)  not null auto_increment, userid varchar(50) not null, createdate varchar(50) not null, functionname varchar(255), types varchar(255), detail varchar(255), primary key (id));
create table canceldocument (id int(4) not null auto_increment, stockid varchar(50), productionid varchar(50), times varchar(50), productionnames varchar(50), linkman varchar(50), tel varchar(50), faxs varchar(50), documentname varchar(50), checks varchar(50), primary key (id));
create table cancelproduct (id int(4) not null auto_increment, names varchar(50), specs varchar(50), colors varchar(50), numbers varchar(50), unitprice varchar(50), moneys varchar(50), reason varchar(50), documentid varchar(50), primary key (id));
create table clientmanagement (id int(4) not null auto_increment, names varchar(50), propertys varchar(50), deliver varchar(50), address varchar(50), supply varchar(50), review varchar(50), contractcode varchar(50), charter varchar(50), payment varchar(50), appointment varchar(50), express varchar(50), contractleave varchar(50), country varchar(50), primary key (id));
create table code (id int(4)  not null auto_increment, menu varchar(255), code varchar(50), codeid varchar(50), codesum varchar(50), primary key (id));
create table colormanagement (id int(4) not null auto_increment, colorcode varchar(50), lily varchar(50), names varchar(50), patten varchar(50), product varchar(50), lamphouse varchar(50), replycolor varchar(50), accepttime varchar(50), oknumber varchar(50), oktime varchar(50), transactor varchar(50), notes varchar(100), primary key (id));
create table contractdata (id int(4) not null auto_increment, types varchar(50), names varchar(50), contents varchar(50), times varchar(50), payment varchar(50), operations varchar(50), propertys varchar(50), documentid varchar(50), primary key (id));
create table countryport (id int(4) not null auto_increment, types varchar(50), portchiness varchar(50), portenglish varchar(50), portaddress varchar(50), areas varchar(50), plans varchar(50), countrychiness varchar(50), countryenlish varchar(50), notes varchar(50), primary key (id));
create table departments (id int(4)  not null auto_increment, deptlavel varchar(50) not null, deptname varchar(50) not null, staffid varchar(11) not null, deptmanager varchar(50), deptdetail varchar(250), primary key (id));
create table dept (id int(4)  not null auto_increment, menuid varchar(255), munefatherid varchar(255), menuname varchar(255), menuurl varchar(50) not null, deptname varchar(255), staffid varchar(255), deptmanager varchar(255), deptlavel varchar(255), deptdetail varchar(255), primary key (id));
create table exportclient (id int(4) not null auto_increment, clientnumber varchar(50), clientaddress varchar(50), tel varchar(50), dates varchar(50), names varchar(50), fax varchar(50), sales varchar(50), linkman varchar(50), checks int(4), primary key (id));
create table exportproduct (productid int(4) not null auto_increment, id int(4), productcode varchar(50), clientcode varchar(50), sizes varchar(50), specs varchar(50), stuff varchar(50), colors varchar(50), units varchar(50), money varchar(50), item varchar(200), image varchar(50), numbers varchar(50), primary key (productid));
create table filemanager (id int(4) not null auto_increment, menuid varchar(50) not null, munefatherid varchar(50) not null, menuname varchar(50) not null, menuurl varchar(50) not null, primary key (id));
create table folders (id int(4) not null auto_increment, menuid varchar(50) not null, munefatherid varchar(50) not null, menuname varchar(50) not null, menuurl varchar(50) not null, isshare varchar(255), staffid varchar(255), staffname varchar(255), primary key (id));
create table guestorder (id int(4) not null auto_increment, guestcode varchar(50), address varchar(50), times varchar(50), froms varchar(50), tel varchar(50), fax varchar(50), linkman varchar(50), checks int(4), primary key (id));
create table incasementdocument (id int(4) not null auto_increment, plid varchar(50), companycode varchar(50), clientcode varchar(50), numbers varchar(50), suttle varchar(50), grossweight varchar(50), sizes varchar(50), documentname varchar(50), checks varchar(50), primary key (id));
create table incasementproduct (id int(4) not null auto_increment, documentid varchar(50), productname varchar(50), productspecs varchar(50), numbers varchar(50), units varchar(50), colors varchar(50), suttle varchar(50), grossweight varchar(50), stuff varchar(50), primary key (id));
create table informationmanagement (id int(4) not null auto_increment, inforid varchar(50), infortype varchar(50), inforcontent varchar(100), inforurl varchar(100), infortime varchar(50), informan varchar(50), inforget varchar(50), tablename varchar(50), isaudit int(4), primary key (id));
create table instoredocument (id int(4) not null auto_increment, intime varchar(50), storetype varchar(50), inman varchar(50), notes varchar(50), documentname varchar(50), checks varchar(50), primary key (id));
create table instoreproduct (id int(4) not null auto_increment, documentid varchar(50), commodityname varchar(50), units varchar(50), numbers varchar(50), addtatol varchar(50), oldtatol varchar(50), nowtatol varchar(50), primary key (id));
create table linkman (id int(4) not null auto_increment, names varchar(50), address varchar(50), tel varchar(50), faxs varchar(50), emails varchar(50), msn varchar(50), documentid varchar(50), types varchar(50), primary key (id));
create table logs (id int(4) not null auto_increment, names varchar(50), codes varchar(50), times varchar(50), operations varchar(50), documentid varchar(50), types varchar(50), tablename varchar(50), primary key (id));
create table merchant (id int(4) not null auto_increment, staffid varchar(100) not null, staffname varchar(255) not null, mername varchar(120), mercode varchar(20), simplename varchar(100), tel varchar(100), fax varchar(20), weburl varchar(220), email varchar(100), area varchar(20), postcode varchar(11), addr varchar(250), remark varchar(250), bankaccount varchar(250), account varchar(120), adddate varchar(20), primary key (id));
create table orderproduct (productid int(4) not null auto_increment, id int(4), productcode varchar(50), ordercode varchar(50), sizes varchar(50), specs varchar(50), stuff varchar(50), colors varchar(50), units varchar(50), money varchar(50), item varchar(200), image varchar(50), numbers varchar(50), primary key (productid));
create table outstoredocument (id int(4) not null auto_increment, outtime varchar(50), storetype varchar(50), outman varchar(50), notes varchar(50), documentname varchar(50), checks varchar(50), primary key (id));
create table outstoreproduct (id int(4) not null auto_increment, documentid varchar(50), productname varchar(50), units varchar(50), numbers varchar(50), productid varchar(50), primary key (id));
create table paymentbuy (id int(4) not null auto_increment, orderid varchar(50), codes varchar(50), providername varchar(50), address varchar(50), linkman varchar(50), tel varchar(50), times varchar(50), pay varchar(50), emails varchar(50), fax varchar(50), primary key (id));
create table paymentincase (id int(4) not null auto_increment, plid varchar(50), companycode varchar(50), clientcode varchar(50), numbers varchar(50), suttle varchar(50), grossweight varchar(50), sizes varchar(50), documentname varchar(50), checks varchar(50), times varchar(50), getid varchar(50), primary key (id));
create table privodelog (id int(4) not null auto_increment, types varchar(50), documentid varchar(50), provideid varchar(50), primary key (id));
create table producenote (id int(4) not null auto_increment, orderid varchar(50), codes varchar(50), requiretime varchar(50), confirmtime varchar(50), names varchar(50), checks varchar(50), primary key (id));
create table produceproduct (id int(4) not null auto_increment, orderid varchar(50), productcode varchar(50), productname varchar(50), guige varchar(50), color varchar(50), totals varchar(50), unit varchar(50), moneytype varchar(50), suttle varchar(50), discount varchar(50), price varchar(50), money varchar(50), fullmoney varchar(50), sizes varchar(50), primary key (id));
create table productsmanagement (id int(4) not null auto_increment, names varchar(50), price varchar(50), spec varchar(50), craftwork varchar(50), color varchar(50), stuff varchar(50), provide varchar(50), productionperiod varchar(50), qc varchar(50), note varchar(50), images varchar(50), primary key (id));
create table providemanagement (id integer not null auto_increment, names varchar(50), address varchar(50), linkman varchar(50), tel varchar(50), web varchar(50), mail varchar(50), msn varchar(50), fax varchar(50), finance varchar(50), bankaccout varchar(50), propertys varchar(50), sizes varchar(50), logs varchar(50), company varchar(50), review varchar(50), charter varchar(50), deliver varchar(50), payment varchar(200), documentid varchar(200), types varchar(200), primary key (id));
create table reperstorymanagement (id int(4) not null auto_increment, codes varchar(50), names varchar(50), price varchar(50), spec varchar(50), craftwork varchar(50), color varchar(50), stuff varchar(50), provide varchar(50), productionperiod varchar(50), qc varchar(50), types varchar(50), numbers varchar(50), primary key (id));
create table sampledocument (id int(4) not null auto_increment, clientname varchar(50), linkman varchar(50), times varchar(50), froms varchar(50), sales varchar(50), checks varchar(50), primary key (id));
create table sampleproduct (id int(4) not null auto_increment, codes varchar(50), numbers varchar(50), describes varchar(50), musttime varchar(50), entertime varchar(50), imgess varchar(50), productid varchar(50), documentid varchar(50), primary key (id));
create table shippingmark (id int(4) not null auto_increment, pono varchar(50), pino varchar(50), itemno varchar(50), color varchar(50), sizes varchar(50), qty varchar(50), nw varchar(50), primary key (id));
create table smalltag (id int(4) not null auto_increment, color varchar(50), sizes varchar(50), qty varchar(50), primary key (id));
create table staffinfo (id int(4) not null auto_increment, menuid varchar(255), menufatherid varchar(255), staffid varchar(255), deptid varchar(255), deptname varchar(255), staffname varchar(50), sex varchar(250), passward varchar(250), staffcnname varchar(250), phone varchar(250), mobile varchar(20), email varchar(250), noid varchar(50), age varchar(30), birthday varchar(30), identitys varchar(30), nationals varchar(60), origin varchar(50), accountlocation varchar(60), ismarriage varchar(255), qualifications varchar(255), professional varchar(255), graduate varchar(255), startjobtime varchar(30), endjobtime varchar(30), jobinunit varchar(30), endjobinunit varchar(30), duty varchar(30), titles varchar(30), political varchar(250), homeaddr varchar(250), jobchanges varchar(250), jobdetail varchar(250), awardrecords varchar(250), teachback varchar(250), social varchar(250), medicalrecord varchar(250), detail varchar(250), addtime varchar(20), primary key (id));
create table steelsinformation (lilynumber int(4) not null auto_increment, guestnumber varchar(50), tenet varchar(50), providenumber varchar(50), oktime varchar(50), transactor varchar(50), primary key (lilynumber));
create table storymanagement (id int(4) not null auto_increment, names varchar(50), types varchar(50), discrib varchar(100), primary key (id));
create table test (id int(4) not null auto_increment, name varchar(255), sex varchar(255), primary key (id));
create table units (id int(4) not null auto_increment, norm varchar(50), capital varchar(50), names varchar(50), primary key (id));