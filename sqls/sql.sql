-- root 권한으로
create database reservation;

grant all privileges on reservation.* 
to reservation@'localhost' 
identified by 'reservation';
flush privileges;