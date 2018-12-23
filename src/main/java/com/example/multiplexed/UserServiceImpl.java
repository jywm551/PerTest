package com.example.multiplexed;

import com.server.User;
import com.server.UserService;
import org.apache.thrift.TException;

/**
 * Created by Theodore_YU on 2017/11/24.
 */
public class UserServiceImpl implements UserService.Iface {
    @Override
    public void store1(User user) throws TException {
        System.out.println("theinput user: ");
        System.out.println("uid:"+user.getUid());
        System.out.println("name:"+user.getName());
        System.out.println("blurb:"+user.getBlurb());
    }

    @Override
    public User retrieve1(int uid) throws TException {
        System.out.println("theinput uid: "+uid);
        return new User(uid,"tom","123");
    }
}
