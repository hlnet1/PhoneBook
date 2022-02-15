package com.example.phonebook.service;

import com.example.phonebook.model.dto.ContactDTO;
import com.example.phonebook.model.dto.EntryDTO;
import com.example.phonebook.model.entity.Contact;
import com.example.phonebook.model.entity.Entry;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<ContactDTO> getAllContacts();





    void deleteContact(Long id);

    long addContact(ContactDTO bookDTO);

    Long updateContact(ContactDTO bookDTO);

    List<Contact> searchContactByEntry(Entry entry);
}
