package ru.academits.model;

import java.util.Objects;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private boolean important;
    private boolean shown;

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + phone + " " + id;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + id;
        hash = prime * hash + (firstName != null ? firstName.hashCode() : 0);
        hash = prime * hash + (lastName != null ? lastName.hashCode() : 0);
        hash = prime * hash + (phone != null ? phone.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Contact c = (Contact) o;

        return id == c.id && Objects.equals(firstName, c.firstName) && Objects.equals(lastName, c.lastName) && Objects.equals(phone, c.phone);
    }
}