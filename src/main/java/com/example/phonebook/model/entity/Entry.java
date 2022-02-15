package com.example.phonebook.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="entries")
public class Entry {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable = false,updatable = false)
    private Long id;


    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @JsonIgnore
    @OneToMany(mappedBy = "entry",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Contact> contacts=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Entry setFirstName(String firstName) {

        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Entry setLastName(String lastName) {

        this.lastName = lastName;
        return this;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Entry setContacts(List<Contact> contacts) {

        this.contacts = contacts;
        return this;
    }

public Entry addContact(Contact contact){
    this.contacts.add(contact);
    return this;
}
    @Override
    public String toString() {
        return "Entry{" +
                "firstName='" + firstName + '\'' +
                "lastName='" + lastName + '\'' +
                '}';
    }

}


