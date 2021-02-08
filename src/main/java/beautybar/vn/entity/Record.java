package beautybar.vn.entity;

import java.sql.Date;
import java.sql.Time;

public class Record {

    private int id;

    private Date date;

    private boolean stage;

    private boolean status_for_admin;

    private Time starting_time;

    private Time ending_time;


    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStage(boolean stage) {
        this.stage = stage;
    }


    public void setStatus_for_admin(boolean status_for_admin) {
        this.status_for_admin = status_for_admin;
    }

    public void setStarting_time(Time starting_time) {
        this.starting_time = starting_time;
    }

    public void setEnding_time(Time ending_time) {
        this.ending_time = ending_time;
    }


    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public boolean isStage() {
        return stage;
    }

    public boolean isStatus_for_admin() {
        return status_for_admin;
    }

    public Time getStarting_time() {
        return starting_time;
    }

    public Time getEnding_time() {
        return ending_time;
    }





}
