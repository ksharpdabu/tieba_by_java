package info.dabu.dao;

import info.dabu.domain.Reply;
import info.dabu.domain.Topic;
import info.dabu.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by AlexY on 2016/8/14.
 */
public class TopicDaoImpl implements TopicDao {


    @Override
    public void save(Topic topic) {

        Session session = HibernateUtils.getCurrentSession();


        session.save(topic);


    }

    @Override
    public List<Topic> getAll(String key) {


        //1 获得session
        Session session = HibernateUtils.getCurrentSession();


        //2 创建query对象
        Query query = session.createQuery("from Topic where title like :key ");
        //3 设置参数
        if(key!=null && !"".equals(key.trim())){//页面传条件了
            query.setString("key", "%"+key+"%");
        }else{//页面没传条件=>查询所有
            query.setString("key", "%");
        }
        //4 查询 list
        return query.list();



    }

    @Override
    public Topic showTopic(Integer id) {

        Session session = HibernateUtils.getCurrentSession();

        Topic topic = (Topic) session.get(Topic.class, id);


        return topic;
    }

    @Override
    public void saveReply(Reply reply) {


        Session session  = HibernateUtils.getCurrentSession();

        session.save(reply);

    }
}
