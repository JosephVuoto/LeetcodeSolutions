package com.xieyangzhe.others.proxy;

/**
 * @author Yangzhe Xie
 * @date 20/4/20
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public int insertUser(String name) {
        System.out.println("New user inserted: " + name);
        return 1;
    }
}
