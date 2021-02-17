package beautybar.vn.command;

import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.MasterDao;
import beautybar.vn.entity.Master;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MasterCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {


        DaoFactory factory = DaoFactory.getInstance();
        MasterDao masterDao = factory.getMasterDAO();

        List<Master> masters = masterDao.getMasters();

        request.setAttribute("masters",masters);

        return "master.jsp";
    }
}
