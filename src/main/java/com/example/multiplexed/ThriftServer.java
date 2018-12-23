package com.example.multiplexed;

import com.server.TopicService;
import com.server.UserService;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * Created by Theodore_YU on 2017/11/23.
 */
public class ThriftServer {
    public static void main(String[] args){
        try {
            TServerTransport tServerTransport = new TServerSocket(9090);
            TMultiplexedProcessor processor = new TMultiplexedProcessor();

            //注册一个服务接口
            TopicService.Processor<TopicServiceImpl> pro1 = new TopicService.Processor<>(new TopicServiceImpl());
            processor.registerProcessor("TopicService",pro1);

            //注册一个接口
            UserService.Processor<UserServiceImpl> pro2 = new UserService.Processor<>(new UserServiceImpl());
            processor.registerProcessor("UserService",pro2);

            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(tServerTransport).processor(processor));
            System.out.println("the service started and is listening at 9090...");
            server.serve();//啓動服務
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done.");

    }
}
