package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.dao.UserDAO;
import beautybar.vn.entity.Record;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UpdateMasterStatus implements Command{
    private static final Logger log = Logger.getLogger(UpdateMasterStatus.class);
    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start");

        HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));

        String recordId = request.getParameter("recordId");
        log.trace("recordList --> " + recordId);
        int recId=Integer.parseInt(recordId);

        DaoFactory factory  = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        recordDao.updateMasterStatus(recId);

        //write update list
        List<Record> records = recordDao.getAllRecordsByMaster((String) session.getAttribute("master"),currentPage,recordsPerPage);

        request.setAttribute("records",records);
        log.trace("Set the request attribute: records --> " + records);

        // data for pagination
        UserDAO userDAO = factory.getUserDAO();
        int rows = userDAO.getNumberOfRows();
        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        session.setAttribute("currentPage",currentPage);
        session.setAttribute("recordsPerPage",recordsPerPage);

        log.debug("Command finished");
        return Path.PAGE__MASTER_TIMETABLE;
    }
}
