package com.bat.yalong.config;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.jms.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CountInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ActiveMQUtil activeMQUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        //获取用户信息 如果有的话 必须是单点登陆 配合登陆认证服务使用
//        CookieUtil.getCookieValue(request, "user", true);

        //用户浏览器信息
        String agent = request.getHeader("user-agent");
        //用户的请求地址
        StringBuffer requestURL = request.getRequestURL();
//        客户端Ip
        String remoteAddr = request.getRemoteAddr();

//        发送一个消息队列 保存分析数据 为了对付高并发也可以做一个hash分流

        sendCountMsg(agent,requestURL,remoteAddr);

        return super.preHandle(request, response, handler);
    }

    private void sendCountMsg(String agent, StringBuffer requestURL, String remoteAddr) {
        Connection connection = activeMQUtil.getConnection();
        Session session = null;
        MessageProducer producer = null;

        try {
            connection.start();
            session = connection.createSession(true, Session.SESSION_TRANSACTED);
            Queue queue  = session.createQueue("YALONG_COUNT_QUEUE");
            producer = session.createProducer(queue);
            MapMessage mapMessage = new ActiveMQMapMessage();
            mapMessage.setString("agent", agent);
            mapMessage.setString("requestURL", new String(requestURL));
            mapMessage.setString("remoteAddr", remoteAddr);
            producer.send(mapMessage);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            activeMQUtil.closeJmsConnection(connection, session, producer);
        }
    }
}
