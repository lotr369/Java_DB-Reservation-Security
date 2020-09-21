-- 시큐리티 적용
SELECT ur.id, ur.user_id, ur.role_name 
FROM user_role ur 
JOIN user u ON ur.user_id = u.id 
WHERE u.email = 'carami@connect.co.kr';

-- 예약 삽입문
insert into reservation_info (
product_id, display_info_id, user_id, reservation_date,
create_date, modify_date) 
values ( 1, 1, 1, now(), now(), now());

-- 예약 가격 삽입
insert into reservation_info_price (
reservation_info_id, product_price_id, count) 
values (1, 1, 1, 1);

-- 예약 등록하기 응답 결과
select * 
from reservation_info
where id=30;
select *
from reservation_info_price
where reservation_info_id=30;

-- 주문 정보 구하기
select ri.id,ri.product_id,ri.display_info_id,ri.user_id,
ri.reservation_date,ri.create_date,ri.modify_date
,sum(price)  as sumPrice,
p.description as productDescription,
p.content as productContent
from reservation_info as ri
inner join reservation_info_price as rip
on ri.id=rip.reservation_info_id
inner join product_price as pp
on rip.product_price_id=pp.id
inner join product as p
on ri.product_id=p.id
where ri.user_id=1
group by ri.id;

-- 예약 취소 하기
delete from reservation_info_price where reservation_info_id=34;
delete from reservation_info where id=34;