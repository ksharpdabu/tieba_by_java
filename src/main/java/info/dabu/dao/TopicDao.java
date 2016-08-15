package info.dabu.dao;

import info.dabu.domain.Reply;
import info.dabu.domain.Topic;

import java.util.List;

/**
 * Created by AlexY on 2016/8/14.
 */
public interface TopicDao {


     void save(Topic topic);

    List<Topic> getAll(String key);


    Topic showTopic(Integer id);


    void  saveReply(Reply reply);


}
