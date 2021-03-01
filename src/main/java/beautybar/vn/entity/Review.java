package beautybar.vn.entity;

import java.sql.Date;

public class Review {

    private Long id;

    private String text;

    private Date date;

    private Integer user_id;

    private String Name;

    private String name_of_master;

    public String getName_of_master() {
        return name_of_master;
    }

    public void setName_of_master(String name_of_master) {
        this.name_of_master = name_of_master;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
