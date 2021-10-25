package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ResetFilterServlet extends HttpServlet {
    private final ContactService phoneBookService = PhoneBook.phoneBookService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        phoneBookService.resetFilter();
    }
}