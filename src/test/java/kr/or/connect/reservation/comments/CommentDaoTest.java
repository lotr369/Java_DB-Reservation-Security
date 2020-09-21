package kr.or.connect.reservation.comments;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.MvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfig.class, ApplicationConfig.class })
public class CommentDaoTest {
	
	@Autowired
	private CommentDao commentDao;
	
	@Test
	public void getComments() {
		for(Comment comment:commentDao.getComments(1, 0, 5)) {
			System.out.println(comment);
		};
	}
	
	@Test
	public void getCommentsCnt() {
		System.out.println(commentDao.getCommentsCnt(1));
	}

}
