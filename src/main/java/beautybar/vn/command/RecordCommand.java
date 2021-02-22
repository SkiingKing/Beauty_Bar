package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.entity.Master;
import beautybar.vn.entity.Record;
import beautybar.vn.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Date;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;


public class RecordCommand implements Command {

    private static final Logger log = Logger.getLogger(RecordCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start!");
        String errorMessage;
        String forward = Path.PAGE__ERROR_PAGE;

        User user = (User) request.getSession().getAttribute("user");
        Master master = (Master) request.getSession().getAttribute("name_of_service");

        String name_of_master = request.getParameter("masters");
        if(name_of_master.isEmpty() || name_of_master == null){
            errorMessage = "Master can not be empty!";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        }

        Date date = Date.valueOf(request.getParameter("data"));
        if(date == null || !date.toString().matches("\\d*[-]\\d*[-]\\d*")){
            errorMessage = "Field date empty or not correct!";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        }

        Time start_time = Time.valueOf(request.getParameter("start_time"));
        if(start_time == null || !start_time.toString().matches("\\d*[:]\\d*[:]\\d*")){
            errorMessage = "Field start time empty or not correct!";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        }
        Time ending_time;

        DaoFactory factory = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        Record record = new Record();

         // Calculation ending time of service by service
        LocalTime s = start_time.toLocalTime();
        HashMap<String, Long> map = recordDao.getTimeByService();
        Long temp = null;

        for (String key : map.keySet()) {
            if (key.equals(master.getServices())) temp = map.get(key);
        }
        ending_time = Time.valueOf(s.plusMinutes(temp));
        log.info("Ending time: "+ ending_time);

        // Save data in record
        record.setUser_id(user.getId());
        record.setDate(date);
        record.setStarting_time(start_time);
        record.setEnding_time(ending_time);
        record.setService(master.getServices());
        record.setMaster_name(name_of_master);

        // Check if is free time slot
        List<Time> start = recordDao.getStartTimeByMasterAndDate(name_of_master, date);
        List<Time> end = recordDao.getEndingTimeByMasterAndDate(name_of_master, date);

        if (start.isEmpty()) {
            recordDao.addRecord(record);
            log.info("No records");
            return Path.PAGE__MAIN;
        } else
            for (int i = 0; i < start.size(); i++) {
                if (start_time.equals(start.get(i))) return Path.PAGE__ERROR_PAGE_RECORD;
                if (ending_time.equals(end.get(i))) return Path.PAGE__ERROR_PAGE_RECORD;

                int sa = start_time.toLocalTime().getHour();
                int en = end.get(i).toLocalTime().getHour();
                int sam = start_time.toLocalTime().getMinute();
                int enm = end.get(i).toLocalTime().getMinute();
                int ens = ending_time.toLocalTime().toSecondOfDay();
                int egs = end.get(i).toLocalTime().toSecondOfDay();

                if (start_time.before(start.get(i)) && ending_time.before(end.get(i))) {
                    recordDao.addRecord(record);
                    log.info("Recorded:" + record);
                    return Path.PAGE__MAIN;
                }

                if (sa == en && sam >= enm) {
                    if (ens - egs >= (int) (temp * 60)) {
                        recordDao.addRecord(record);
                        log.info("Recording:" + record);
                        return Path.PAGE__MAIN;
                    } else {
                        errorMessage = "This time employment!!!";
                        request.setAttribute("errorMessage", errorMessage);
                        log.error("errorMessage --> " + errorMessage);
                    }
                }
            }
        log.debug("Command end!");
        return null;
    }
}
