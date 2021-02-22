package EntityTest;

import beautybar.vn.entity.Master;
import beautybar.vn.entity.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MasterTest {
    @Test
    public void testMasterTest(){
        Master master = new Master();

        assertNotNull(master);

        master.setId(10);
        master.setName("Ann");
        master.setEmail("svova313@gmail.com");
        master.setServices("nails");
        master.setRate(9);

        Integer a = 9;

        assertEquals(master.getId(), 10);
        assertEquals(master.getName(),"Ann");
        assertEquals(master.getEmail(), "svova313@gmail.com");
        assertEquals(master.getServices(),"nails");
        assertEquals(master.getRate(),a);
        assertEquals(master.toString(),"Master{id=10, name='Ann', email='svova313@gmail.com', " +
                "services='nails', rate=9}");
    }
}
