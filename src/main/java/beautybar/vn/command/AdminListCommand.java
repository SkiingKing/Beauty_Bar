package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.entity.Record;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AdminListCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {


        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));


        DaoFactory factory = DaoFactory.getInstance();
        RecordDao recordDao =factory.getRecordDAO();

        List<Record> records = recordDao.getAllRecords();

        request.setAttribute("records",records);

        int rows = recordDao.getNumberOfRows();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);


        return Path.PAGE__ADMIN_LIST;
    }
}
