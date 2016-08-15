package info.dabu.domain;

import java.util.*;

/**
 * Created by AlexY on 2016/8/13.
 *
 * 帖子
 */
public class Topic {


    private Integer tid;
    private String title; //标题
    private String topicContent; //    内容

    private String ipAddr ;   //ip地址（作者）

    private Date lastReplyDate; // 最后回复 的时间
    private Date createDate; // 发帖时间（创建时间）



    //一对多： 一个主题 可以拥有 【多个回复】
    private List<Reply> replyList = new ArrayList<>();


    public Topic() {



    }


    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Date getLastReplyDate() {
        return lastReplyDate;
    }

    public void setLastReplyDate(Date lastReplyDate) {
        this.lastReplyDate = lastReplyDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {



        return "{Topic [" + tid+","+title+","+ topicContent+ "] }";
    }
}




