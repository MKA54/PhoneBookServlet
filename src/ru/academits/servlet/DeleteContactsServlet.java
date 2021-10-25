package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DeleteContactsServlet extends HttpServlet {
    private final ContactService phoneBookService = PhoneBook.phoneBookService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String contactJson = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        contactJson = contactJson.substring(1, contactJson.length() - 1);

        int[] indexList = Arrays.stream(contactJson.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int initialSize = phoneBookService.size();

        for (int i : indexList) {
            phoneBookService.deleteContact(i);
        }

        int currentSize = phoneBookService.size();

        if (currentSize != initialSize - indexList.length) {
            resp.setStatus(500);
        }
    }
}