

##sturts与Hibernate实现简单的发帖功能


![需求和功能分析](./ScreenImage/40c33a3e9a8ec0325366ed2ee70c7558.bmp)


###关键

关键：
1.
事务扩大。因为Hibernate的加载策略。如果我们使用延迟加载，当我们在Dao成开启和关闭事务以及session后，就无法获取属性。如果不设置延迟加载，则有的时候会就比较浪费内存，比如，只需要列表数量的时候，显然是没有必要查询帖子内容的。

通过将事务的开启和关闭放到过滤器中，这样就等于将事务的范围扩大到 接收Request 和返回Response之间，这样，当jsp调用Topic中的ReplaySet集合中的Replay对象的属性的时候，还是处于session的声明周期内，可以根据实际需求来自动选择延迟还是立即加载。


2. Action类通过在struts.xml中使用 通配符，可以 动态设置和调用 Action类里方法，让一个Action类实现多个功能。
Action标签name属性使用通配符（*）


Action标签的name属性可以使用通配符，这样在后面的子元素或属性中就可以动态设置属性值或元素值了。



下面是使用通配符来动态设置和调用同一个Action类中的不同method：
```
        <!--动态设置 action的method-->
        <action name="TopicAction_*" method="{1}" class="info.dabu.web.action.TopicAction">
            <result name="toList" type="redirectAction" >
                <param name="actionName" >TopicAction_list</param>
                <param name="namespace">/</param>
            </result>
        </action>
```

3.
比如，假设我们的实体类中的属性为Date类型，我们需要对应mysql数据库中的datetime类型（含日期和时间），有良好总方式：
```
        <property name="lastReplyDate" type="java.util.Date"  />
```
或者
```
      <property name="lastReplyDate"  >
            <column name="lastReplyDate" sql-type="datetime" ></column>
        </property>
```


