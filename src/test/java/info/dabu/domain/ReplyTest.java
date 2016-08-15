package info.dabu.domain;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * Created by AlexY on 2016/8/14.
 */
public class ReplyTest {



    @Test
    public void createTable(){

        SchemaExport export = new SchemaExport(new Configuration().configure());
        export.create(true,false);

    }

}