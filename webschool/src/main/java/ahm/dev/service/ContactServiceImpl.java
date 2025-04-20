package ahm.dev.service;

import org.springframework.stereotype.Service;

import ahm.dev.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {
    @Override
    public boolean sendContact(Contact contact) {
        // Logic to send contact information
        System.out.println("Sending contact: " + contact);
        return true; // Simulate successful sending
    }

    @Override
    public void validateContact(Contact contact) {
        System.out.println("Validating contact: " + contact);
    }


}
