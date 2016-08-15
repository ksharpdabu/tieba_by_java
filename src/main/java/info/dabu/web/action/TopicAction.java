package info.dabu.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import info.dabu.dao.TopicDao;
import info.dabu.dao.TopicDaoImpl;
import info.dabu.domain.Reply;
import info.dabu.domain.Topic;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

/**
 * Created by AlexY on 2016/8/14.
 */
public class TopicAction extends ActionSupport {


    private TopicDao tdao = new TopicDaoImpl();


    private Topic topic;

    private Reply reply;


    private String key;


    public String reply() {


        Topic tp = tdao.showTopic(topic.getTid());
        if (null != tp) {
//            reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
//            reply.setCreateDate(new Date());
//
//
//            reply.setTopic(tp);
//
//            tdao.saveReply(reply);

            reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
            reply.setCreateDate(new Date());

            tp.getReplyList().add(reply);


        }


        return "reply";


    }


    ////帖子列表
    public String list() {


        //1调用dao获得帖子列表
        List<Topic> list = tdao.getAll(key);

        //2 将帖子列表放入ActionContext中,但是不是放在值栈中，所以在jsp引用的时候，需要带"#"
        ActionContext.getContext().put("list", list);

        return "list";
    }


    //    发帖
    public String add() {


//        获取ip
        topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        topic.setCreateDate(new Date());
        topic.setLastReplyDate(topic.getCreateDate());


//        保存
        tdao.save(topic);


        return "toList";
    }


//    显示帖子和回复

    public String showTopic() {
        String id;
        if (null != topic && topic.getTid() != 0) {

            id = topic.getTid().toString();
        } else {
            id = ServletActionContext.getRequest().getParameter("tid");

        }


        if (null != id && id.matches("[\\d]+")) {

            Topic topic = tdao.showTopic(new Integer(id));


            ActionContext.getContext().put("topic", topic);

        }


        return "showTopic";
    }


    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
