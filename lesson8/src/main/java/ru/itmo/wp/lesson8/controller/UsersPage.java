package ru.itmo.wp.lesson8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.lesson8.form.StatusCredentials;
import ru.itmo.wp.lesson8.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UsersPage extends Page {
    private final UserService userService;

    public UsersPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "UsersPage";
    }

    @PostMapping("/users/all")
    public String status(Model model, StatusCredentials statusCredentials, HttpSession httpSession) {
        if (getUser(httpSession) == null) {
            setMessage(httpSession, "Authorization is required");
        } else if (getUser(httpSession) != null && getUser(httpSession).getId() != statusCredentials.getUserId()) {
            userService.updateStatus(statusCredentials.getUserId(), statusCredentials.getStatus().equals("Disable"));
            setMessage(httpSession, "User " + statusCredentials.getUserId() + " is now " +
                    (statusCredentials.getStatus().equals("Disable") ? " disabled" : " enabled"));
        }
        model.addAttribute("users", userService.findAll());
        return "UsersPage";
    }
}
