package beautybar.vn.command;

import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class EditCommand implements Command{
    private static final Logger log = Logger.getLogger(EditCommand.class);
    @Override
    public String execute(HttpServletRequest request) {


        String recordId = request.getParameter("recordId");
        log.trace("recordList --> " + recordId);
        int recId=Integer.parseInt(recordId);

        DaoFactory factory  = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        recordDao.updateAdminStatus(recId);












        return null;
    }
}
