package com.hongxi.web;

import com.google.gson.Gson;
import com.hongxi.pojo.ImgDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/6/7 15:55
 */
@WebServlet(name = "imgDetailServlet", value="/imgDetailServlet")
public class imgDetailServlet extends HttpServlet {
    HashMap<String, ImgDetail> imgDetails =null;

     {
//        加载各图片路径和文本
//        ArrayList<imgDetail> imgDetails = new ArrayList<>();
//        imgDetails.add(new imgDetail(1,"/path","旭日教学大楼"));
        imgDetails = new HashMap<>();
        imgDetails.put("imgOne",new ImgDetail(1,"img/SceneryTestImg/imgOne/1.jpg","旭日教学大楼","<p>旭日大楼是第一教学楼，位于蓬瀛湖畔、正对图书馆、紧邻操场，是学校最早建成的教学楼之一。</p><p>旭日大楼正门前坐拥全校最大的广场——旭日广场，平时晚上会有部分协会在广场上举行日常活动。在双子楼未建成前，旭日大楼是许多学院的主要上课地点，大楼前后左右各有一个出入口，正门位于旭日广场。</p>"));
        imgDetails.put("imgTwo",new ImgDetail(2,"img/SceneryTestImg/imgTwo/1.jpg","电子楼","电子楼是学校的第五教学楼，也是电子、地旅、信息科学技术学院的主要教学楼。位于音乐楼对面，田家炳大楼旁，楼高六层。"));

        imgDetails.put("imgThree",new ImgDetail(3,"img/SceneryTestImg/imgThree/1.jpg","特色建筑","惠州学院始祖丰湖书院，也就是今天西湖“聚贤堂”十二先生祠，千百年来，它相伴于惠州西湖。西湖的山水灵气、书院的人文气息、王守仁的遗迹、薛侃讲学传播的印迹，为惠州积聚了丰厚的文化底蕴。伊秉绶的楹联“学焉得其性之所近，览者将有感于斯文”，宋湘的名联“人文古邹鲁，山水小蓬瀛”，这些都历历在册，光华耀目。从西湖迁来的惠州学院，与金山湖山水气脉相连，它秉承先哲的精神风范，肩负弘扬惠州文化的历史使命，终将铸成一座名山，为后人景仰。"));
        imgDetails.put("imgFour",new ImgDetail(4,"img/SceneryTestImg/imgFour/1.jpg","阆苑储英，人竞向学",
                "<p>“阆苑储英” 出自清代名儒、曾任溥仪老师、丰湖书院山长的梁鼎芬（1859～1919）为丰湖书院撰写的楹联 “水湄山晖，平湖聚秀；春华秋实，阆苑储英。”</p>\n" +
                "<p>“人竞向学”出自清代惠州知府程含章（1763～1832）的《增广丰湖书院膏火碑记》 “进所属俊髦士，延师教之。为之正其趋向，发其志气，增其书舍，厚其膏火，严其考课，亲为讲解文字。于是从者云集，人竞向学矣。”</p>\n" +
                "<p>校训意为学院以优越的环境聚集和培养优秀人才，师生以好学笃行的精神开展学习与探索。</p>"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码，设置响应文本格式
        resp.setContentType("text/html; charset=UTF-8");


        System.out.println("接收到AJAX请求");
        String id = req.getParameter("choseId");
        System.out.println("====id是"+id);

        //服务器匹配接收到的id，并以json形式发送给客户端
        Gson gson = new Gson();
        String imgDetailJsonString = gson.toJson(imgDetails.get(id));
        System.out.println(imgDetailJsonString);
        //发送给客户端
        resp.getWriter().write(imgDetailJsonString);
        System.out.println(id+"发送完成");

    }
}
