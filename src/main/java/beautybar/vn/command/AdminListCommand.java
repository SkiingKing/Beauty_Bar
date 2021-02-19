package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.entity.Record;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdminListCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));


        DaoFactory factory = DaoFactory.getInstance();
        RecordDao recordDao =factory.getRecordDAO();

        List<Record> records = recordDao.getAllRecords(currentPage,recordsPerPage);
        Collections.sort(records, new Comparator<Record>() {
            public int compare(Record p1, Record p2) {
                return p1.getDate().compareTo(p2.getDate());
            }
        });
        request.setAttribute("records",records);

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

        return Path.PAGE__ADMIN_LIST;
    }
}
