package ahm.dev.service;

import ahm.dev.model.Contact;



public interface ContactService {
    void sendContact(Contact contact);
    void validateContact(Contact contact);
}