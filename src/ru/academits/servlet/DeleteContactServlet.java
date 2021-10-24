package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.coverter.ContactConverter;
import ru.academits.model.Contact;
import ru.academits.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class DeleteContactServlet extends HttpServlet {
    private final ContactService phoneBookService = PhoneBook.phoneBookService;
    private final ContactConverter contactConverter = PhoneBook.contactConverter;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String contactJson = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Contact contact = contactConverter.convertFormJson(contactJson);

        boolean isRemove = phoneBookService.deleteContact(contact);

        if (!isRemove) {
            resp.setStatus(500);
        }
    }
}