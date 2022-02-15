package com.example.phonebook.repository;

import com.example.phonebook.model.dto.ContactDTO;
import com.example.phonebook.model.entity.Contact;
import com.example.phonebook.model.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contact,Long> {
List<Contact> findContactByEntry(Entry entry);
}
