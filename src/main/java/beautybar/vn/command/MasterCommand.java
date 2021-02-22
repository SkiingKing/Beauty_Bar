package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.MasterDao;
import beautybar.vn.entity.Master;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MasterCommand implements Command{
    private static final Logger log = Logger.getLogger(MasterCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start!");
        DaoFactory factory = DaoFactory.getInstance();
        MasterDao masterDao = factory.getMasterDAO();

        //get list all masters
        List<Master> masters = masterDao.getMasters();
        request.setAttribute("masters",masters);

        log.debug("Command end!");
        return Path.PAGE__MASTERS;
    }
}
