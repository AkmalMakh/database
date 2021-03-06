package model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
//
//        "name": "Seoul",
//        "picture": "url of pic",
//        "dateOfVisit": "2020.02.22"


@Entity
@Table(name="Countries")
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="picture")
    private String pictureUrl;

    @Column(name="visit")
    private String dateOfVisit;

    //we will creat transit field for user_Id to add object in json
    private transient Long userId;



    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                          CascadeType.DETACH,CascadeType.REFRESH})
    @JsonBackReference
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public Countries() {
    }

    public Countries(String name, String pictures,String dateOfVisit) {
        this.name = name;
        this.pictureUrl = pictures;
        this.dateOfVisit= dateOfVisit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user_id) {
        this.user = user_id;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "name='" + name + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", dateOfVisit='" + dateOfVisit + '\'' +
                '}';
    }
}