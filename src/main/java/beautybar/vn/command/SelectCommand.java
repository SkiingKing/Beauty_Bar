package beautybar.vn.command;



import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.MasterDao;
import beautybar.vn.dao.ServicesDao;
import beautybar.vn.entity.Master;
import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SelectCommand implements Command{

    private static final Logger log = Logger.getLogger(SelectCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start!");
        HttpSession session = request.getSession();
        String name_of_service = request.getParameter("services");

        DaoFactory factory = DaoFactory.getInstance();
        MasterDao masterDao = factory.getMasterDAO();
        Master master = new Master();

        // set service
        master.setServices(name_of_service);
        session.setAttribute("name_of_service",master);

        //find master by service
        List<Master> masters = masterDao.getMasterByService(name_of_service);
        request.setAttribute("masters",masters);

        log.debug("Command end!");
        return Path.PAGE__RECORD;
    }

    /**
     * Returns list of services.
     * @return List<String>
     */
    public List<String> getServices(){

        DaoFactory factory = DaoFactory.getInstance();
        ServicesDao servicesDao = factory.getServicesDao();

        return servicesDao.getService();
    }

}
