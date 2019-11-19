package cn.dxxy.dao;

import cn.dxxy.entity.Admin;

public interface LoginDao {

    Admin findUserById(String aId);

    void updateAdmin(Admin user);
}
