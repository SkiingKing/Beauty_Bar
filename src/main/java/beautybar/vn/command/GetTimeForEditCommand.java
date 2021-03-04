package beautybar.vn.command;

import beautybar.vn.Path;

import javax.servlet.http.HttpServletRequest;

public class GetTimeForEditCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {

        int record_id = Integer.parseInt(request.getParameter("recordId"));
        String start = request.getParameter("start");
        String end = request.getParameter("end");


        return Path.PAGE__EDIT;
    }
}
