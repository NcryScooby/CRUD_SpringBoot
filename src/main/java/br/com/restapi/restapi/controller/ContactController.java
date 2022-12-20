package br.com.restapi.restapi.controller;

import br.com.restapi.restapi.database.ContactRepository;
import br.com.restapi.restapi.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    // GET All Contacts
    @GetMapping
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    // GET Contact by ID
    @GetMapping("/{id}")
    public Contact getContact(@PathVariable Long id) {
        return contactRepository.findById(id).get();
    }

    // Create Contact
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact createContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    // Update Contact
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        contact.setId(id);
        return contactRepository.save(contact);
    }

    // Delete Contact
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }
}
