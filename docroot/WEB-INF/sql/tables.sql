create table GB_Clazz (
	uuid_ VARCHAR(75) null,
	clazzId LONG not null primary key,
	clazzName VARCHAR(75) null
);

create table GB_School (
	uuid_ VARCHAR(75) null,
	schoolId LONG not null primary key,
	schoolName VARCHAR(75) null
);

create table GB_Student (
	uuid_ VARCHAR(75) null,
	userId LONG not null primary key,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	createDate DATE null,
	schoolId LONG,
	clazzId LONG
);