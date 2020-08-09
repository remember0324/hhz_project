package com.hhz.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

import java.util.Scanner;

/**
 * 简单登陆 授权  验证
 *
 * @Author Rem
 * @Date 2020-08-02
 */


public class LoginTest {


    public static void main(String[] args) {
        //shior核心组件 安全管理器===>相当于sprngmvc的  DispatcherServlet
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        //shior和数据之间的校验桥梁 realm
        IniRealm realm = new IniRealm("classpath:shior.ini");
        securityManager.setRealm(realm);

        //Security 工具包
        SecurityUtils.setSecurityManager(securityManager);
        //获得shiro的 具体管理
        Subject subject = SecurityUtils.getSubject();


        Scanner scanner = new Scanner(System.in);
        System.out.println("输入登录名：");
        String username = scanner.nextLine();

        System.out.println("输入密码：");
        String pasword = scanner.nextLine();
        //用户输入 封装token
        UsernamePasswordToken token = new UsernamePasswordToken(username, pasword);


        //登陆
        boolean authenticated = subject.isAuthenticated();
        System.err.println("第一次未认证:" + authenticated);

        boolean authenticated2;
        try {
            subject.login(token);
            authenticated2 = true;
        } catch (IncorrectCredentialsException e) {
            authenticated2 = false;
        }

        System.err.println("登陆状态：" + authenticated2);


        if (authenticated2) {
            //角色验证
            boolean isSeller = subject.hasRole("seller");
            System.err.println("是否销售:" + isSeller);



            //权限验证
            boolean permitted = subject.isPermitted("order-add");
            System.err.println("是否有增加订单的权限：" + permitted);
        }


    }


}
