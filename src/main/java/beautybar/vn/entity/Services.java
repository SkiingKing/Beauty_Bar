package beautybar.vn.entity;

import java.sql.Time;

public class Services {

    private int id;

    private String name_of_services;

    private int price;

    private Time time_of_service;

    private int master_id;


    public int getId() {
        return id;
    }

    public String getName_of_services() {
        return name_of_services;
    }

    public int getPrice() {
        return price;
    }

    public int getMaster_id() {
        return master_id;
    }

    public Time getTime_of_service() {
        return time_of_service;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaster_id(int master_id) {
        this.master_id = master_id;
    }

    public void setName_of_services(String name_of_services) {
        this.name_of_services = name_of_services;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTime_of_service(Time time_of_service) {
        this.time_of_service = time_of_service;
    }
}
