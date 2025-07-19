package com.mantra.controller;

import com.mantra.dto.ApiResponse;
import com.mantra.dto.contact.ContactRequest;
import com.mantra.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
@Tag(name = "Contact", description = "Contact form submission")
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    @Operation(summary = "Submit contact form")
    public ResponseEntity<ApiResponse<String>> submitContact(@Valid @RequestBody ContactRequest request) {
        contactService.submitContact(request);
        return ResponseEntity.ok(ApiResponse.success("Contact form submitted successfully", "Thank you for your message"));
    }
}