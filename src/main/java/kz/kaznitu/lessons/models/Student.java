package kz.kaznitu.lessons.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String items;
    private String receipt;
    private int phoneNumber;
    private String address;
    @ManyToMany
    private List<Location> locations;

    public Student(){
        super(); }

    public Student(int id, String firstName, String lastName, String email, String items, String receipt, int phoneNumber, String address, List<Location> locations){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.items = items;
        this.receipt = receipt;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.locations = locations;
    }
    public Student(String firstName, String lastName, String email, String items, String receipt, int phoneNumber, String address, List<Location> locations){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.items = items;
        this.receipt = receipt;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.locations = locations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public boolean hasLocation(Location location) {
        for(Location containedLocation: getLocations()){
            if(containedLocation.getId() == location.getId()){
                return true;
            }
        }
        return false;
    }
}
