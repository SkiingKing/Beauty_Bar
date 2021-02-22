package EntityTest;

import beautybar.vn.entity.Services;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ServiceTest {
    @Test
    public void testServiceTest(){

        Services services = new Services();

        assertNotNull(services);

        services.setId(1);
        services.setName_of_services("make-up");
        services.setPrice(200);
        services.setTime_of_service(120L);

        Long l = 120L;

        assertEquals(services.getId(),1);
        assertEquals(services.getName_of_services(),"make-up");
        assertEquals(services.getPrice(),200);
        assertEquals(services.getTime_of_service(),l);
        assertEquals(services.toString(),"Services{id=1, name_of_services='make-up', price=200, " +
                "time_of_service=120}");


    }
}
