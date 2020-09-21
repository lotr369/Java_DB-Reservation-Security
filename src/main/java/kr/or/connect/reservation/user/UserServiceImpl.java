package kr.or.connect.reservation.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.security.UserEntity;
import kr.or.connect.reservation.security.UserRoleEntity;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
    private UserRoleDao userRoleDao;

	@Override
    @Transactional
    public UserEntity getUser(String loginUserId) {
        User user = userDao.getUserByEmail(loginUserId);
        return new UserEntity(user.getEmail(), user.getPassword());
    }

	@Override
    @Transactional
    public List<UserRoleEntity> getUserRoles(String loginUserId) {
        List<UserRole> userRoles = userRoleDao.getRolesByEmail(loginUserId);
        List<UserRoleEntity> list = new ArrayList<>();

        for(UserRole userRole : userRoles) {
            list.add(new UserRoleEntity(loginUserId, userRole.getRoleName()));
        }
        return list;
    }
    
}