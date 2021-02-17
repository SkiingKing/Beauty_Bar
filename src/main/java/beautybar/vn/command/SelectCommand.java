package beautybar.vn.command;



import beautybar.vn.Path;
import beautybar.vn.Test;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.MasterDao;
import beautybar.vn.dao.ServicesDao;
import beautybar.vn.entity.Master;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class SelectCommand implements Command{

    List<String> list = new ArrayList<>();

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();

        String name_of_service = request.getParameter("services");

        DaoFactory factory = DaoFactory.getInstance();
        MasterDao masterDao = factory.getMasterDAO();
        Master master = new Master();

        master.setServices(name_of_service);
        session.setAttribute("name_of_service",master);

        list = masterDao.getMasterByService(name_of_service);
        Test.my =list;


        return Path.PAGE__RECORD;
    }

    public List<String> getServices(){

        DaoFactory factory = DaoFactory.getInstance();
        ServicesDao servicesDao = factory.getServicesDao();

        return servicesDao.getService();
    }

}
