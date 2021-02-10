package beautybar.vn.entity;

import java.util.List;

public class Master {

    private int id;

    private String name;

    private String email;

    private String services;

    private int rate;

    private List<String> master_by_service;

    public void setServices(String services) {
        this.services = services;
    }
    public String getServices() {
        return services;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    private String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRate() {
        return rate;
    }

    public void setMastersByService(List<String> list){
        this.master_by_service =list;

    }

    public List<String> getMasterByService(){
        return  master_by_service;
    }


}
