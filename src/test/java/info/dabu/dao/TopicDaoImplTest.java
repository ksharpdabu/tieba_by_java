package info.dabu.dao;

import info.dabu.domain.Topic;
import info.dabu.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by AlexY on 2016/8/14.
 */
public class TopicDaoImplTest {
    @Test
    public void getAll() throws Exception {

        TopicDao  dao = new TopicDaoImpl();
        Session  session = HibernateUtils.getCurrentSession();

        session.getTransaction().begin();


        Topic topic = (Topic) session.get(Topic.class, new Integer(12));


        System.out.println(topic.getReplyList().size());


        System.out.println( dao.getAll(""));

        session.getTransaction().commit();

    }

}