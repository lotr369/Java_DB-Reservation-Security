-- 카테고리 목록 구하기
select c.id, c.name, count(p.category_id) as count
from category as c inner join product as p
on c.id=p.category_id
group by p.category_id;

-- 카테고리 수 구하기
select count(*) from category;

-- 상품 목록 전체 구하기
select p.id,p.category_id as categoryId,d.id as displayInfoId,c.name as name,
p.description,p.content,p.event,d.opening_hours as openingHours,d.place_name as placeName,
d.place_lot as placeLot, d.place_street as placeStreet,d.tel, d.homepage, d.email,
p.create_date as createDate, p.modify_date as modifyDate,pi.file_id as fileId
from product as p 
inner join display_info as d on p.id=d.product_id 
inner join category as c on p.category_id=c.id 
inner join product_image as pi on p.id=pi.product_id and pi.type like 'ma'
group by p.id;

-- 상품 목록 카테고리, start로 구하기
select p.id,p.category_id as categoryId,d.id as displayInfoId,c.name as name,
p.description,p.content,p.event,d.opening_hours as openingHours,d.place_name as placeName,
d.place_lot as placeLot, d.place_street as placeStreet,d.tel, d.homepage, d.email,
p.create_date as createDate, p.modify_date as modifyDate,pi.file_id as fileId
from product as p 
inner join display_info as d on p.id=d.product_id 
inner join category as c on p.category_id=c.id 
inner join product_image as pi on p.id=pi.product_id and pi.type like 'ma'
where c.id=3
group by p.id
limit 0,4;

-- 카테고리에 해당되는 상품 수 구하기
select count(*) from product where category_id=3;

-- 프로모션 목록 구하기
select pm.id,pm.product_id as productId,p.category_id as categoryId,
c.name as categoryName,p.description as description,pi.file_id as fileId
from promotion as pm
inner join product as p on pm.product_id=p.id
inner join product_image as pi on p.id=pi.product_id and pi.type like 'th'
inner join category as c on p.category_id=c.id;

-- 전시 정보 한개 구하기
select p.id,p.category_id as categoryId,d.id as displayInfoId,c.name as name,
p.description,p.content,p.event,d.opening_hours as openingHours,d.place_name as placeName,
d.place_lot as placeLot, d.place_street as placeStreet,d.tel, d.homepage, d.email,
p.create_date as createDate, p.modify_date as modifyDate,pi.file_id as fileId
from product as p 
inner join display_info as d on p.id=d.product_id 
inner join category as c on p.category_id=c.id 
inner join product_image as pi on p.id=pi.product_id and pi.type like 'ma'
where d.id=1
group by p.id;

-- productImages 구하기
select d.product_id as productId,pi.id as productImageId,pi.type,f.id as fileInfoId,
f.file_name as fileName,f.save_file_name as saveFileName,f.content_type as contentType,
f.delete_flag as deleteFlag,f.create_date as createDate, f.modify_date as modifyDate
from display_info as d
inner join product_image as pi on d.product_id=pi.product_id and pi.type like 'ma'
inner join file_info as f on pi.file_id=f.id
where d.id=1;

-- displayInfoImages 가져오기
select di.id as id,d.id as displayInfoId,di.file_id as fileId,
f.file_name as fileName,f.save_file_name as saveFileName,
f.content_type as contentType,f.delete_flag as deleteFlag,
f.create_date as createDate,f.modify_date as modifyDate
from display_info as d
inner join display_info_image as di on d.id=di.display_info_id
inner join file_info as f on di.file_id=f.id
where d.id=1;

-- avgScore : 댓글 점수의 평균 (int값)
select avg(r.score)
from display_info as d
inner join reservation_user_comment as r on d.product_id=r.product_id
where d.id=1
group by r.product_id;

-- productPrices : 상품 가격 정보들
select pp.id,pp.product_id as productId,pp.price_type_name as priceTypeName,
pp.price, pp.discount_rate as discountRate, pp.create_date as createDate,
pp.modify_date as modifyDate
from display_info as d
inner join product_price as pp on d.product_id=pp.product_id
where d.id=1
order by pp.id desc;

-- 댓글 목록 구하기
select c.id, c.product_id as productId, c.reservation_info_id as reservationInfoId,
c.score,u.email as reservationEmail,c.comment,c.create_date as createDate,
c.modify_date as modifyDate
from reservation_user_comment as c
inner join user as u on c.user_id=u.id
where c.product_id=1
order by c.id desc
limit 0,5;

-- 댓글 전체 수 구하기
select count(*)
from reservation_user_comment as c
where c.product_id=1;
