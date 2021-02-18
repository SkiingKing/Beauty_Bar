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


        DaoFactory factory = DaoFactory.getInstance();
        RecordDao recordDao =factory.getRecordDAO();

        List<Record> records = recordDao.getAllRecords();

        request.setAttribute("records",records);


        return Path.PAGE__ADMIN_LIST;
    }
}
