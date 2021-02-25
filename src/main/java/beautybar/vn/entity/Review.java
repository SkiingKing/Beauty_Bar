package beautybar.vn.entity;

import java.sql.Date;

public class Review {

    private Long id;

    private String text;

    private Date date;

    private Long user_id;

    private String Name;

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

    public Long getUser_id() {
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

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
