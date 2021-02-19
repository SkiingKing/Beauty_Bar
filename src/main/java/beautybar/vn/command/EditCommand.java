package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.entity.Record;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EditCommand implements Command{
    private static final Logger log = Logger.getLogger(EditCommand.class);
    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start");

        int currentPage = (int) request.getSession().getAttribute("currentPage");
        int recordsPerPage = (int) request.getSession().getAttribute("recordsPerPage");


        int recordId = Integer.parseInt(request.getParameter("recordId"));
        Time start = Time.valueOf(request.getParameter("start"));
        Time end = Time.valueOf(request.getParameter("end"));
        log.trace("new time start --> " + start);
        log.trace("new time end --> " + end);


        DaoFactory factory  = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        recordDao.updateAdminRecord(recordId,start,end);

        List<Record> records = recordDao.getAllRecords(currentPage,recordsPerPage);
        Collections.sort(records, new Comparator<Record>() {
            public int compare(Record p1, Record p2) {
                return p1.getDate().compareTo(p2.getDate());
            }
        });

        request.setAttribute("records",records);
        log.trace("Set the request attribute: records --> " + records);

        Integer rows = recordDao.getNumberOfRows();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        log.debug("Command finished");
        return Path.PAGE__ADMIN_LIST;

    }
}
