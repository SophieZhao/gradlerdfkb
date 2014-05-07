
import junit.framework.Assert;

import org.junit.Test;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import models.database.Journal;
import com.avaje.ebean.*;

import java.util.List;

/**
 * Created by matthew on 07/05/2014.
 */
public class test  {

    @Test
    public void test(){

        String sql = "select count(*) as count from journal";
        SqlRow row =
                Ebean.createSqlQuery(sql)
                        .findUnique();

        Integer i = row.getInteger("count");

        System.out.println("Got "+i+"  - DataSource good.");


        //BasicEntity e = new BasicEntity();
       // EbeanServer server = Ebean.getServer(null);
        //BasicEntity e2 = server.find(Journal.class, "1");

        List<Journal> ee = Ebean.find(Journal.class).findList();
        System.out.println("Got "+ ee);

    }
}
