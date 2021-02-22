package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.ServicesDao;
import beautybar.vn.entity.Services;
import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ServiceCommand implements Command{

    private static final Logger log = Logger.getLogger(ServiceCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start!");
        DaoFactory factory = DaoFactory.getInstance();
        ServicesDao servicesDao = factory.getServicesDao();

        // get all services
        List<Services> services = servicesDao.getAllService();
        request.setAttribute("services",services);

        log.debug("Command end!");
        return Path.PAGE__SERVICES;
    }
}
