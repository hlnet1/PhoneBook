package com.example.phonebook.web;

import com.example.phonebook.model.entity.Contact;
import com.example.phonebook.model.entity.Entry;
import com.example.phonebook.model.entity.enums.TypeEnum;
import com.example.phonebook.repository.ContactsRepository;
import com.example.phonebook.repository.EntryRepository;
import com.example.phonebook.repository.EntrySearchSpecification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entries")
public class EntryRestController {
    private final EntryRepository entryRepository;
    private final ContactsRepository contactRepository;

    public EntryRestController(EntryRepository entryRepository, ContactsRepository contactRepository) {
        this.entryRepository = entryRepository;
        this.contactRepository = contactRepository;
    }

//    @GetMapping
//    public List<Entry> getAllContacts() {
//
//
//        return entryRepository.findAll();
//    }
    @GetMapping
    public List<Entry> getAllContacts(@RequestParam(required=false) String firstName,
                                      @RequestParam(required=false) String lastName,
                                      @RequestParam(required=false) TypeEnum contactType) {


        return entryRepository.findAll(new EntrySearchSpecification(firstName,lastName,contactType));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Entry> getById(@PathVariable Long id){
        Optional<Entry> entryOpt=entryRepository.findById(id);
        return entryOpt.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }



   @PostMapping
   public ResponseEntity<Entry> create(@RequestBody Entry entry,
                                       UriComponentsBuilder ucBuilder){
        Entry newEntry =entryRepository.save(entry);
        URI location=ucBuilder.path("/entries/{entryId}")
               .buildAndExpand(newEntry.getId()).toUri();
        return  ResponseEntity.created(location).build();

   }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entry> delete(@PathVariable Long id){

        entryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
