package com.hongxi.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hongxi.pojo.GuestMessage;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/6/9 21:38
 */
@WebServlet(name = "GuestMessageServlet" ,value = "/GuestMessageServlet")
public class GuestMessageServlet extends HttpServlet {
    public static List<GuestMessage> guestMessageArrayList = null;
    public Gson gson = new Gson();
    static {
        guestMessageArrayList = new ArrayList<>();
    }

    @Test
    public void testTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(dateTime.format(formatter));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决post请求中文乱码问题
        // 一定要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        // 解决响应中文乱码
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        //为了防止刷新页面导致页面信息丢失
        if ("load".equals(req.getParameter("method"))){
//                /*设置现有留言个数*/
//            System.out.println("method为"+req.getParameter("method"));
//            System.out.println("messageNum为"+req.getParameter("messageNum"));
//            Integer messageNum = new Integer(req.getParameter("messageNum"));
//            System.out.println("载入页面,得到的messageNum为"+messageNum);
//            GuestMessage.setMessageNum(messageNum);
            if (guestMessageArrayList!=null){
                //List转json字符串
                String s = gson.toJson(guestMessageArrayList);
                System.out.println("List转json字符串为："+s);
                System.out.println("发送给客户端的Json集合数组为"+s);
                writer.write(s);
            }
        }else {
            System.out.println("得到Message表单信息");
            System.out.println("来宾名为="+req.getParameter("nickname"));
            System.out.println("邮箱为="+req.getParameter("email"));
            System.out.println("联系方式为="+req.getParameter("contact"));
            System.out.println("留言内容="+req.getParameter("messageText"));

            GuestMessage guestMessage = new GuestMessage(req.getParameter("email"), req.getParameter("nickname"), req.getParameter("contact"), req.getParameter("messageText"));
            guestMessageArrayList.add(guestMessage);

            System.out.println("目前留言个数为="+GuestMessage.getMessageNum()+"内容为="+guestMessage);

            //转化为json并传回客户端
            String s = gson.toJson(guestMessage);
            System.out.println("传回客户端的值为："+s);
            System.out.println("====================================");
            writer.write(s);
        }





    }
}
