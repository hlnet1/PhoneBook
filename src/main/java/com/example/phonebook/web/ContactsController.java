package com.example.phonebook.web;

import com.example.phonebook.model.dto.ContactDTO;
import com.example.phonebook.model.entity.Contact;
import com.example.phonebook.model.entity.Entry;
import com.example.phonebook.repository.EntryRepository;
import com.example.phonebook.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactsController {
    private final ContactService contactService;
    private final EntryRepository entryRepository;

    public ContactsController(ContactService contactService, EntryRepository entryRepository) {
        this.contactService = contactService;

        this.entryRepository = entryRepository;
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        List<ContactDTO> allContacts =contactService.getAllContacts();

        return ResponseEntity.
                ok(allContacts);
    }
    @GetMapping("/{entryId}/contacts")
    public ResponseEntity<List<Contact>> getEntryContacts(@PathVariable Long entryId) {
        Optional<Entry> entry = entryRepository.findById(entryId);

        return entry.
                map(Entry::getContacts).
                map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    }




