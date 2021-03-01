package EntityTest;

import beautybar.vn.entity.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserTest {
    @Test
    public void testUserEntity() {
        User user = new User();

        assertNotNull(user);

        user.setId(10);
        user.setEmail("svova313@gmail.com");
        user.setPassword("1234");
        user.setNameAndSurname("Vova Shvets");
        user.setRoleId(1);

        Integer a = 10;

        assertEquals(user.getId(), a);
        assertEquals(user.getEmail(), "svova313@gmail.com");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.getNameAndSurname(), "Vova Shvets");
        assertEquals(user.getRoleId(), 1);
        assertEquals(user.toString(),"User{id=10, email='svova313@gmail.com', " +
                "password='1234', NameAndSurname='Vova Shvets', roleId=1}");
    }
}
