package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class FilterContactServlet extends HttpServlet {
    private final ContactService phoneBookService = PhoneBook.phoneBookService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String contactJson = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        contactJson = contactJson.substring(1, contactJson.length() - 1);

        phoneBookService.filter(contactJson);
    }
}