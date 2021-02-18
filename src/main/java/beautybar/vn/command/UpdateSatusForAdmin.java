package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.entity.Record;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UpdateSatusForAdmin implements Command{
    private static final Logger log = Logger.getLogger(UpdateSatusForAdmin.class);
    @Override
    public String execute(HttpServletRequest request) {

        String recordId = request.getParameter("recordId");
        log.trace("recordList --> " + recordId);
        int recId=Integer.parseInt(recordId);

        DaoFactory factory  = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        recordDao.updateAdminStatus(recId);

        //write update list
        List<Record> records = recordDao.getAllRecords();

        request.setAttribute("records",records);
        log.trace("Set the request attribute: records --> " + records);

        log.debug("Command finished");
        return Path.PAGE__ADMIN_LIST;
    }
}