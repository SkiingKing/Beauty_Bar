package DaoTest;

import beautybar.vn.dao.RecordDao;
import beautybar.vn.entity.Record;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RecordDaoTest {
    @Test
    public void testRecordDao() {

        Record record_id = RecordDao.getInstance().findRecordById(4);


//        User userById = UserDao.findUserById(4l);
//        User userByLogin = UserDao.findUserByLogin("Vova");
//        List<User> accounts = UserDao.findAllUsers();
//        List<User> accounts1 = UserDao.findOnlyUsers();
//        User user = new User();
//        user.setLogin("Vlad");
//        user.setEmail("grgrey25@gmail.com");
//        user.setBill(10000);
//        user.setRoleId(1);
//        UserDao.insertUser(user);
//        user.setEmail("grgrey");
//        UserDao.updateUser(user);

        Assert.assertEquals(record_id.getMaster_name(),     "Nastya");
//        Assert.assertEquals(userByLogin.getId(), 2);
//        Assert.assertEquals(accounts.get(0).getLogin(), "Oleg");
//        Assert.assertEquals(accounts1.get(0).getLogin(), "Shmek");
//        Assert.assertEquals(user.getLogin(), "Vlad");
//        Assert.assertEquals(user.getEmail(), "grgrey");

    }

}
