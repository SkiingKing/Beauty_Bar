package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.MasterDao;
import beautybar.vn.entity.Master;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCommand implements Command{

    private static final Logger log = Logger.getLogger(SortCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start!");
        String sort = request.getParameter("sort");
        log.trace("Sort by "+ sort);

        DaoFactory factory = DaoFactory.getInstance();
        MasterDao masterDao = factory.getMasterDAO();

        List<Master> masters_2 = masterDao.getMasters();

        //sorting by name of sort
        switch (sort){
            case "For the master":
                Collections.sort(masters_2, new Comparator() {
                    @Override
                    public int compare(Object one, Object two) {

                        return ((Master)one).getName()
                                .compareTo(((Master)two).getName());
                    }
                });
                break;

            case "For the rate":
                Collections.sort(masters_2, new Comparator() {
                    @Override
                    public int compare(Object one, Object two) {

                        return ((Master)one).getRate()
                                .compareTo(((Master)two).getRate());
                    }
                });
                Collections.reverse(masters_2);

                break;

            case "For the service":
                Collections.sort(masters_2, new Comparator() {
                    @Override
                    public int compare(Object one, Object two) {

                        return ((Master)one).getServices()
                                .compareTo(((Master)two).getServices());
                    }
                });
                break;
        }

        request.setAttribute("masters_2",masters_2);

        log.debug("Command end!");
        return Path.PAGE__SORT_MASTER;
    }
}
