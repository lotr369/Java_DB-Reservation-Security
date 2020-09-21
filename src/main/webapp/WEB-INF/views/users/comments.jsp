<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
  <html>
    <head>
      <title>댓글달기 </title>
    </head>
  <body>
    
   ${comment}

 
 ${reservation.c.product_id  } <br>
 ${reservation.c.reservation_info_id  } <br>
 ${reservation.user_id } <br>
 ${reservation.score } <br>
 ${reservation.comment } <br>
 ${reservation.create_date } <br>

	<br>
	<br>
	<br>
    
  </body>
</html>