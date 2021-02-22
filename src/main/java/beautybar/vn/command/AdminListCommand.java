package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.entity.Record;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdminListCommand implements Command{

    private static final Logger log = Logger.getLogger(AdminListCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command starts");
        HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));


        DaoFactory factory = DaoFactory.getInstance();
        RecordDao recordDao =factory.getRecordDAO();

        // get records
        List<Record> records = recordDao.getAllRecords(currentPage,recordsPerPage);
        log.trace("Found in BD records: "+records);

        // sort list by date
        Collections.sort(records, new Comparator<Record>() {
            public int compare(Record p1, Record p2) {
                return p1.getDate().compareTo(p2.getDate());
            }
        });
        log.trace("Sorted list: "+records);
        request.setAttribute("records",records);

        // data for pagination
        int rows = recordDao.getNumberOfRows();
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

        return Path.PAGE__ADMIN_LIST;
    }
}
