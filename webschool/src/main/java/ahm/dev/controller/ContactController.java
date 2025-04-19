package ahm.dev.controller;

import org.springframework.stereotype.Controller;

import ahm.dev.model.Contact;
import ahm.dev.service.ContactService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ContactController {

    final private ContactService contactService;

    ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    @PostMapping("/contact")
    public String contact(@ModelAttribute("contact") Contact contact) {
        contactService.sendContact(contact);
        return "redirect:/contact";
    }
}
