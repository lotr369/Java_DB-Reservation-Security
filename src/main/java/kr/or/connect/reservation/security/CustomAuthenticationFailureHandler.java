package kr.or.connect.reservation.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./users/loginerror");
		if(exception instanceof InternalAuthenticationServiceException){
			request.setAttribute("errorMessage", "존재하지 않는 아이디입니다.");
			dispatcher.forward(request, response);
		}else if(exception instanceof BadCredentialsException) {
			request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("errorMessage", "알수 없는 오류입니다.");
			dispatcher.forward(request, response);
		}
	}

}
