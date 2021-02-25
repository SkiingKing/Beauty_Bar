package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.Sender;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.dao.UserDAO;
import beautybar.vn.entity.Record;
import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Properties;


public class UpdateSatusForAdmin implements Command{
    private static final Logger log = Logger.getLogger(UpdateSatusForAdmin.class);
    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start");
        String recordId = request.getParameter("recordId");
        log.trace("recordList --> " + recordId);
        int recId=Integer.parseInt(recordId);

        DaoFactory factory  = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        UserDAO userDAO = factory.getUserDAO();
        recordDao.updateAdminStatus(recId);


        Sender sender = new Sender("svova313@gmail.com","vova14042003");
        sender.send("BeautyBar:response","Please leave a review!" +
                "http://localhost:8080/response?action=response","svova313@gmail.com",userDAO.findUserEmailById(recordDao.findUserByRecordId(recId)));

        //write update list
        int a= (int) request.getSession().getAttribute("currentPage");
        int b= (int) request.getSession().getAttribute("recordsPerPage");

        List<Record> records = recordDao.getAllRecords(a, b);

        request.setAttribute("records",records);
        log.trace("Set the request attribute: records --> " + records);

        log.debug("Command finished");
        return Path.PAGE__ADMIN_LIST;
    }
}
