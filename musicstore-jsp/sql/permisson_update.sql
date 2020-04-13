use permission;
update sys_config set action="http://172.20.56.118:9001/" where id = 10;

update sys_user set password='dfb1f8ae1a6a737b9a76bae8ab6e3e4ebdd7ae46693bf69c2c51925303549e8d', salt='ASiejOjL' where id=1;

show variables like '%time_zone%'; 
set time_zone = '+8:00'; 
set global time_zone = '+8:00';  
flush privileges;