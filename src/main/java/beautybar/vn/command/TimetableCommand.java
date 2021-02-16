package beautybar.vn.command;

import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.dao.UserDAO;
import beautybar.vn.entity.Record;
import beautybar.vn.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Timetable
 *
 * @author Vova Shvets
 */

public class TimetableCommand implements Command{

    List<Record> records;

    @Override
    public String execute(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");

        DaoFactory factory = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        UserDAO userDAO  = factory.getUserDAO();

        String name = userDAO.findMasterByEmail(user.getEmail());
        records = recordDao.getAllRecordsByMaster(name);

        Collections.sort(records, new Comparator<Record>() {
            public int compare(Record p1, Record p2) {
                return p1.getDate().compareTo(p2.getDate());
            }
        });


        request.setAttribute("records", records);


        return "master_timetable.jsp";
    }

    public List<Record> getRecords(){
        DaoFactory factory = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();

        return records;
    }

}
