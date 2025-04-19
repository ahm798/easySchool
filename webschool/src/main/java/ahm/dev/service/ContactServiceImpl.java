package ahm.dev.service;

import org.springframework.stereotype.Service;

import ahm.dev.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {
    @Override
    public void sendContact(Contact contact) {
        // Logic to send contact information
        System.out.println("Sending contact: " + contact);
    }

    @Override
    public void validateContact(Contact contact) {
        // Logic to validate contact information
        
    }


}
