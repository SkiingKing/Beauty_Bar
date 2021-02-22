package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.dao.UserDAO;
import beautybar.vn.entity.Record;
import beautybar.vn.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TimetableCommand implements Command{


    private static final Logger log = Logger.getLogger(TimetableCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("command start!");
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");

        DaoFactory factory = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        UserDAO userDAO  = factory.getUserDAO();

        // Find master in BD by email
        List<Record> records;
        String master = userDAO.findMasterByEmail(user.getEmail());
        records = recordDao.getAllRecordsByMaster(master);

        session.setAttribute("master",master);

        // Sort master time table by date
        Collections.sort(records, new Comparator<Record>() {
            public int compare(Record p1, Record p2) {
                return p1.getDate().compareTo(p2.getDate());
            }
        });


        request.setAttribute("records", records);

        log.debug("Command end!");
        return Path.PAGE__MASTER_TIMETABLE;
    }

}
