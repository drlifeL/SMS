package cn.dxxy.service;

import cn.dxxy.dao.LoginDao;
import cn.dxxy.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    public boolean userExist(Admin admin) {

        Admin user = loginDao.findUserById(admin.getaId());
        if (admin == null || user == null) {
            return false;
        }
        return user.equals(admin);
    }

    public Admin findUserById(String userId) {
        return loginDao.findUserById(userId);
    }

    public void updateAdmin(Admin user) {
        loginDao.updateAdmin(user);
    }
}
