package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.entity.Record;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteRecord implements Command{
    private static final Logger log = Logger.getLogger(DeleteRecord.class);
    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start");

        String recordId = request.getParameter("recordId");
        log.trace("recordList --> " + recordId);
        int recId=Integer.parseInt(recordId);


        DaoFactory factory  = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        Record record = recordDao.findRecordById(recId);
        log.trace("Find record -->" + record);
        recordDao.deleteRecord(recId);

        int a= (int) request.getSession().getAttribute("currentPage");
        int b= (int) request.getSession().getAttribute("recordsPerPage");

        List<Record> records = recordDao.getAllRecords(a,b);

        request.setAttribute("records",records);
        log.trace("Set the request attribute: records --> " + records);

        log.debug("Command finished");
        return Path.PAGE__ADMIN_LIST;
    }
}
