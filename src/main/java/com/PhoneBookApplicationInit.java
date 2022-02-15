package com;

import com.example.phonebook.repository.ContactsRepository;
import com.example.phonebook.repository.EntryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PhoneBookApplicationInit implements CommandLineRunner {
    private final EntryRepository entryRepository;
    private final ContactsRepository contactsRepository;

    public PhoneBookApplicationInit(EntryRepository entryRepository, ContactsRepository contactsRepository) {
        this.entryRepository = entryRepository;
        this.contactsRepository = contactsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
//    private void initSmith() {
//
//        initEntry("John",
//                "Smith",
//                "+359887654411","+3592654411","+3592654422"
//        );
//    }
//    private void initEntry(String firstName, String lastName, String... contacts) {
//        Entry entry = new Entry();
//        entry.setFirstName(firstName).setLastName(lastName);
//        entry=entryRepository.save(entry);
//
//       List<Contact> allContacts = new ArrayList<>();
//
//        for (String contact: contacts) {
//            Contact aContact = new Contact();
//            aContact.setNumbers(contact);
//            aContact.setType(TypeEnum.valueOf());
//
//            allContacts.add(aContact);
//        }
//
//        entry.setContacts(allContacts);
//
//        entryRepository.saveAll(allContacts);
//    }
}
