package info.dabu.domain;

import java.util.Date;

/**
 * Created by AlexY on 2016/8/13.
 *
 * 回复
 */
public class Reply {

    private Integer rid;

    private String replyContent;  //回帖内容

    private String ipAddr ; //回帖人ip地址

    private Date createDate; // 回帖时间


//    多对一： 多个回复 属于同一个主题
    private Topic topic;


    public Reply() {

    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


    @Override
    public String toString() {



        return "Reply {"+ rid+","+replyContent+","+ ipAddr + " ] }";
    }
}
