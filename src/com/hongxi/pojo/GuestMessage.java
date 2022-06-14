package com.hongxi.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/6/9 21:36
 */
public class GuestMessage {
    private String email;
    private String nickname;
    private String contact;
    private String messageText;

    private String sendTime;

    private static Integer messageNum = 0;

    private int messageID;

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public static Integer getMessageNum() {
        return messageNum;
    }

    public static void setMessageNum(Integer messageNum) {
        GuestMessage.messageNum = messageNum;
    }

    @Override
    public String toString() {
        return "GuestMessage{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", contact='" + contact + '\'' +
                ", messageText='" + messageText + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public GuestMessage(String email, String nickname, String contact, String messageText) {
        this.email = email;
        this.nickname = nickname;
        this.contact = contact;
        this.messageText = messageText;
        this.messageID = ++messageNum;
        this.sendTime = getSendTime();

    }

    private static String getSendTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        return dateTime.format(formatter);
    }
}
