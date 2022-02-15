package com.example.phonebook.model.entity;

import com.example.phonebook.model.entity.enums.TypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="contacts")
public class Contact extends BaseEntity {
    @Column(name = "phone_number",unique = true)
    @Pattern(regexp = "^\\+[0-9]{10,13}$")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="entry_id",nullable = false)

    private Entry entry;

    public String getNumbers() {
        return phoneNumber;
    }

    public void setNumbers(String numbers) {
        this.phoneNumber = numbers;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "number='" + phoneNumber + '\'' +
                ", type='" + type + '\'' +
              ", entry=" + entry +
                '}';
    }
}
