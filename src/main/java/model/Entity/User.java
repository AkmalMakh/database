package model.Entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="user")
public class User {

    //define fields
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String Address;

    //define constructors


   @OneToMany(targetEntity = Countries.class,fetch = FetchType.LAZY,
              cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                         CascadeType.DETACH,CascadeType.REFRESH})
   @JsonManagedReference
   @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<Countries> countries;

   /*user has cities*/
    @OneToMany(targetEntity = cities.class,fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                    CascadeType.DETACH,CascadeType.REFRESH})
    @JsonManagedReference
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<cities> cities;

    public User(){

    }
    public User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = email;

    }
    // define getter//setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "User [Address=" + Address + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }

    public List<model.Entity.cities> getCities() {
        return cities;
    }

    public void setCities(List<model.Entity.cities> cities) {
        this.cities = cities;
    }

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }

    public void add(Countries tempCountries){
        if(countries == null){
            countries = new ArrayList<>();
        }
        countries.add( tempCountries );
        tempCountries.setUser( this );
    }

}