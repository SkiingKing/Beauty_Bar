package beautybar.vn.command;

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


public class RecordCommand implements Command{

    private static final Logger log = Logger.getLogger(RecordCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        User user = (User)request.getSession().getAttribute("user");
        Master master = (Master) request.getSession().getAttribute("name_of_service");

        String name_of_master = request.getParameter("masters");
        Date date = Date.valueOf(request.getParameter("data"));
        Time start_time = Time.valueOf(request.getParameter("start_time"));
        Time ending_time;

        DaoFactory factory = DaoFactory.getInstance();
        RecordDao recordDao = factory.getRecordDAO();
        Record record = new Record();

        /**
         * Calculation ending time of service by service
         */

        LocalTime s = start_time.toLocalTime();
        HashMap<String,Long> map = recordDao.getTimeByService();
        Long temp = null;

            for ( String key : map.keySet() ) {
                    if(key.equals(master.getServices())) temp = map.get(key);
            }
        ending_time = Time.valueOf(s.plusMinutes(temp));

        //save data in record
        record.setUser_id(user.getId());
        record.setDate(date);
        record.setStarting_time(start_time);
        record.setEnding_time(ending_time);
        record.setService(master.getServices());
        record.setMaster_name(name_of_master);

        log.info(record.getStarting_time());
        log.info(record.getEnding_time());


        /**
         * Check if is free time slot
         */

        List<Time> start = recordDao.getStartTimeByMasterAndDate(name_of_master,date);
        List<Time> end = recordDao.getEndingTimeByMasterAndDate(name_of_master,date);

        if(start.isEmpty()) {
            recordDao.addRecord(record);
            return "main.jsp";
        } else for(int i=0;i< start.size();i++){
                    if(!start_time.after(start.get(i)) && !ending_time.before(end.get(i))
                            || start_time.after(start.get(i)) && ending_time.after(end.get(i))){
                        recordDao.addRecord(record);
                        return "main.jsp";
                    }else return  "error.jsp";
            }

       return "main.jsp";
    }

}
