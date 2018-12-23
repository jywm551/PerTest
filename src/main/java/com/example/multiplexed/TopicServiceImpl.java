package com.example.multiplexed;

import com.server.Topic;
import com.server.TopicService;
import org.apache.thrift.TException;

/**
 * Created by Theodore_YU on 2017/11/24.
 */
public class TopicServiceImpl implements TopicService.Iface {
    @Override
    public void store(Topic topic) throws TException {
        System.out.println("theinput topic: ");
        System.out.println("uid:"+topic.getUid());
        System.out.println("name:"+topic.getName());
        System.out.println("content:"+topic.getContent());
    }

    @Override
    public Topic retrieve(int uid) throws TException {
        System.out.println("theinput uid: "+uid);
        return new Topic(uid,"test","test");
    }
}
