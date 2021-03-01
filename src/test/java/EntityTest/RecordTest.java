package EntityTest;

import beautybar.vn.entity.Record;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RecordTest {
    @Test
    public void testRecordEntity() {
        Record record = new Record();

        assertNotNull(record);

          record.setId(10L);
          record.setUser_id(2);
          record.setDate(Date.valueOf("2021-02-20"));
          record.setStage(false);
          record.setStatus_for_admin(false);
          record.setStarting_time(Time.valueOf("13:00:00"));
          record.setEnding_time(Time.valueOf("14:40:00"));
          record.setService("nails");
          record.setMaster_name("Tris");

          Long l = 10L;
          Integer li = 2;
          Date date = Date.valueOf("2021-02-20");
          Time start = Time.valueOf("13:00:00");
          Time end = Time.valueOf("14:40:00");

        assertEquals(record.getId(),l);
        assertEquals(record.getUser_id(),li);
        assertEquals(record.getDate(),date);
        assertEquals(record.isStage(),false);
        assertEquals(record.isStatus_for_admin(),false);
        assertEquals(record.getStarting_time(),start);
        assertEquals(record.getEnding_time(),end);
        assertEquals(record.getService(),"nails");
        assertEquals(record.getMaster_name(),"Tris");
        assertEquals(record.toString(),"Record{" +
                "id=" + 10 +
                ", user_id=" + 2 +
                ", date=" + "2021-02-20" +
                ", stage=" + false +
                ", status_for_admin=" + false +
                ", starting_time=" + "13:00:00" +
                ", ending_time=" + "14:40:00" +
                ", service='" + "nails" + '\'' +
                ", master_name='" + "Tris" + '\'' +
                '}');
    }
}
