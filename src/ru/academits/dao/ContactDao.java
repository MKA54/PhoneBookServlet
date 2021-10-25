package ru.academits.dao;

import ru.academits.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactDao {
    private final List<Contact> contactList = new ArrayList<>();
    private final AtomicInteger idSequence = new AtomicInteger(0);

    public ContactDao() {
        Contact contact = new Contact();
        contact.setId(getNewId());
        contact.setFirstName("Иван");
        contact.setLastName("Иванов");
        contact.setPhone("9123456789");
        contact.setShown(true);
        contactList.add(contact);
    }

    private int getNewId() {
        return idSequence.addAndGet(1);
    }

    public List<Contact> getAllContacts() {
        return contactList;
    }

    public void add(Contact contact) {
        contact.setId(getNewId());
        contactList.add(contact);
    }

    public void deleteContact(int id) {
        contactList.removeIf(contact -> contact.getId() == id);
    }

    public int size() {
        return contactList.size();
    }

    public void filter(String text) {
        for (Contact contact : contactList) {
            if (text.equals(contact.getLastName()) || text.equals(contact.getFirstName()) || text.equals(contact.getPhone())) {
                continue;
            }

            contact.setShown(false);
        }
    }

    public void resetFilter() {
        for (Contact contact : contactList) {
            contact.setShown(true);
        }
    }
}