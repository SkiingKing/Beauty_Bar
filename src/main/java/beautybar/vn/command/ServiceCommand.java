package beautybar.vn.command;

import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.ServicesDao;
import beautybar.vn.entity.Services;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ServiceCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {

        DaoFactory factory = DaoFactory.getInstance();
        ServicesDao servicesDao = factory.getServicesDao();

        List<Services> services = servicesDao.getAllService();

        request.setAttribute("services",services);

        return "services.jsp";
    }
}
