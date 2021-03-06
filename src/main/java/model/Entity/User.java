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

    /*user has airport*/
    @OneToMany(targetEntity = Airports.class,fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                    CascadeType.DETACH,CascadeType.REFRESH})
    @JsonManagedReference
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<Airports> airports;

    /*user has attractions*/
    @OneToMany(targetEntity = Attraction.class,fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                    CascadeType.DETACH,CascadeType.REFRESH})
    @JsonManagedReference
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<Attraction> attraction;

    /*user has Culture*/
    @OneToMany(targetEntity = culture.class,fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                    CascadeType.DETACH,CascadeType.REFRESH})
    @JsonManagedReference
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<culture> culture;


    /*user has Culture*/
    @OneToMany(targetEntity = Hotels.class,fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                    CascadeType.DETACH,CascadeType.REFRESH})
    @JsonManagedReference
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<Hotels> hotels;


    /*user has Restaurants*/
    @OneToMany(targetEntity = Restaurants.class,fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                    CascadeType.DETACH,CascadeType.REFRESH})
    @JsonManagedReference
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<Restaurants> restaurants;




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

    public List<Airports> getAirports() {
        return airports;
    }

    public void setAirports(List<Airports> airports) {
        this.airports = airports;
    }

    public List<Attraction> getAttraction() {
        return attraction;
    }

    public void setAttraction(List<Attraction> attraction) {
        this.attraction = attraction;
    }

    public List<model.Entity.culture> getCulture() {
        return culture;
    }

    public void setCulture(List<model.Entity.culture> culture) {
        this.culture = culture;
    }

    public List<Hotels> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
    }

    public List<Restaurants> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurants> restaurants) {
        this.restaurants = restaurants;
    }



    public void add(Countries tempCountries){
        if(countries == null){
            countries = new ArrayList<>();
        }
        countries.add( tempCountries );
        tempCountries.setUser( this );
    }

}