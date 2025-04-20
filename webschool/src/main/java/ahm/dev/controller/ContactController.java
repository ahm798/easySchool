package ahm.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ahm.dev.model.Contact;
import ahm.dev.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ContactController {

    final private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/contact")
    public String saveContactDetails(@Valid @ModelAttribute("contact") Contact contact, 
                                    Errors errors,
                                    RedirectAttributes redirectAttributes) {
        if(errors.hasErrors()) {
            log.error("Contact form validation failed: {}", errors.getAllErrors());
            return "contact";
        }
        
        // boolean result = contactService.sendContact(contact);
        // if(result) {
        //     redirectAttributes.addFlashAttribute("success", "Contact details sent successfully!");
        // } else {
        //     redirectAttributes.addFlashAttribute("error", "Failed to send contact details.");
        // }
        contactService.sendContact(contact);
        
        return "redirect:/contact";
    }
}
