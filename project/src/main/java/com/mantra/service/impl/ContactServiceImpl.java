package com.mantra.service.impl;

import com.mantra.dto.contact.ContactRequest;
import com.mantra.entity.Contact;
import com.mantra.repository.ContactRepository;
import com.mantra.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public void submitContact(ContactRequest request) {
        Contact contact = new Contact();
        contact.setName(request.getName());
        contact.setEmail(request.getEmail());
        contact.setSubject(request.getSubject());
        contact.setMessage(request.getMessage());

        contactRepository.save(contact);
    }
}