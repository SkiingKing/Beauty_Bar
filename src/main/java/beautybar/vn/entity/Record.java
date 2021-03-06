package beautybar.vn.entity;


import java.sql.Date;
import java.sql.Time;


public class Record {

    private Long id;

    private Integer user_id;


    private Date date;

    private boolean stage;

    private boolean status_for_admin;

    private Time starting_time;

    private Time ending_time;

    private String service;

    private String master_name;

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    public String getService() {
        return service;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setId(Long id) {
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



    public Long getId() {
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

    public void setStarting_time(Time starting_time) {
        this.starting_time = starting_time;
    }

    public void setEnding_time(Time ending_time) {
        this.ending_time = ending_time;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", date=" + date +
                ", stage=" + stage +
                ", status_for_admin=" + status_for_admin +
                ", starting_time=" + starting_time +
                ", ending_time=" + ending_time +
                ", service='" + service + '\'' +
                ", master_name='" + master_name + '\'' +
                '}';
    }
}
