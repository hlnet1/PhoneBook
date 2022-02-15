package com.example.phonebook.service.impl;

import com.example.phonebook.model.dto.ContactDTO;
import com.example.phonebook.model.dto.EntryDTO;
import com.example.phonebook.model.entity.Contact;
import com.example.phonebook.model.entity.Entry;
import com.example.phonebook.repository.ContactsRepository;
import com.example.phonebook.repository.EntryRepository;
import com.example.phonebook.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactsRepository contactsRepository;
    private final EntryRepository entryRepository;
    private final ModelMapper mapper;

    public ContactServiceImpl(ContactsRepository contactsRepository, EntryRepository entryRepository, ModelMapper mapper) {
        this.contactsRepository = contactsRepository;
        this.entryRepository = entryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Contact> searchContactByEntry(Entry entry) {
        return contactsRepository.findContactByEntry(entry);
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        return contactsRepository.
                findAll().
                stream().
                map(this::toDto).
                collect(Collectors.toList());
    }



    @Override
    public void deleteContact(Long id) {

    }

    @Override
    public long addContact(ContactDTO newContact) {
        return 0;
    }

    @Override
    public Long updateContact(ContactDTO existingContact) {
        return null;
    }
    private ContactDTO toDto(Contact contact) {
        ContactDTO contactDTO = mapper.map(contact, ContactDTO.class);
        EntryDTO entryDTO =  mapper.map(contact.getEntry(), EntryDTO.class);
        contactDTO.setEntryDTO(entryDTO);
        return contactDTO;
    }
}
