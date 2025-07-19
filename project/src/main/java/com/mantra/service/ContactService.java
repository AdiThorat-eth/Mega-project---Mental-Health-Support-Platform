package com.mantra.service;

import com.mantra.dto.contact.ContactRequest;

public interface ContactService {
    void submitContact(ContactRequest request);
}