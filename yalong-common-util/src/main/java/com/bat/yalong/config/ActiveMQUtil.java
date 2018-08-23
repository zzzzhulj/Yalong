package com.bat.yalong.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class ActiveMQUtil {

    PooledConnectionFactory pooledConnectionFactory = null;

    public void init(String brokerUrl){
        ActiveMQConnectionFactory activeMQConnectionFactory
                = new ActiveMQConnectionFactory(brokerUrl);
        pooledConnectionFactory = new PooledConnectionFactory(activeMQConnectionFactory);
        //设置超时时间
        pooledConnectionFactory.setExpiryTimeout(2000);
        // 设置出现异常的时候，继续重试连接
        pooledConnectionFactory.setReconnectOnException(true);
        // 设置最大连接数
        pooledConnectionFactory.setMaxConnections(5);
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = pooledConnectionFactory.createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeJmsConnection(Connection connection, Session session, MessageProducer producer) {
        try{
            if(producer!=null){
                producer.close();
            }
            if(session!=null){
                session.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch(JMSException e){
            e.printStackTrace();
        }
    }

}
