package com.hongxi.pojo;

/**
 * @author Hongxi Yin
 * @version 1.0
 * @date 2022/6/7 20:33
 */
public class ImgDetail {
    private Integer imgId;
    private String imgPath;
    private String detailTitle;
    private String detailText;

    public ImgDetail(Integer imgId, String imgPath, String detailTitle) {
        this.imgId = imgId;
        this.imgPath = imgPath;
        this.detailTitle = detailTitle;
        this.detailText = "**此处显示的是默认文本****此处显示的是默认文本****此处显示的是默认文本****此处显示的是默认文本**" +
                "**此处显示的是默认文本**<p>**此处显示的是默认文本****此处显示的是默认文本****此处显示的是默认文本**</p><p>**此处显示的是默认文本**" +
                "**此处显示的是默认文本****此处显示的是默认文本**</P>";
    }

    public ImgDetail(Integer imgId, String imgPath, String detailTitle, String detailText) {
        this.imgId = imgId;
        this.imgPath = imgPath;
        this.detailTitle = detailTitle;
        this.detailText = detailText;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    @Override
    public String toString() {
        return "imgDetail{" +
                "imgId=" + imgId +
                ", imgPath='" + imgPath + '\'' +
                ", detailTitle='" + detailTitle + '\'' +
                ", detailText='" + detailText + '\'' +
                '}';
    }
}
