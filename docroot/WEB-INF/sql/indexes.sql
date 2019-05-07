create index IX_56936CA9 on GB_Clazz (clazzId);
create index IX_76A3D2D4 on GB_Clazz (userId);
create index IX_A456F3DA on GB_Clazz (uuid_);

create index IX_1844C2B6 on GB_School (uuid_);

create index IX_595F5A57 on GB_Student (uuid_);
create index IX_543D9D71 on GB_Student (uuid_, companyId);