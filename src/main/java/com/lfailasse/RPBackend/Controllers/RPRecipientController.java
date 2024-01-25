package com.lfailasse.RPBackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lfailasse.RPBackend.Models.EntityRPRecipient;
import com.lfailasse.RPBackend.Repositories.RPRecipientsRepository;

@RestController
@CrossOrigin()
@RequestMapping(value = "rp/favorecidos")
public class RPRecipientController {

    @Autowired
    private RPRecipientsRepository recipientsRepository;

    @GetMapping()
    public List<EntityRPRecipient> getRecipients() {

        return recipientsRepository.findAll();

    }

    @GetMapping(value = "{id}")
    public EntityRPRecipient getRecipientsbyId(@PathVariable String id) {

        return recipientsRepository.findBydocument(id);

    }

    @PostMapping()
    public EntityRPRecipient postRecipient(@RequestBody @NonNull EntityRPRecipient recipient) {

        return recipientsRepository.save(recipient);

    }

    @PatchMapping()
    public EntityRPRecipient changeRecipient(@RequestBody EntityRPRecipient recipient) {
        EntityRPRecipient cRecipient = recipientsRepository.findBydocument(recipient.getDocument());
        if (recipient.getPix() == null) {
            if (cRecipient.getPix() != null) {
                recipient.setPix(cRecipient.getPix());
            }
        }
        if (recipient.getCredito_agencia_n() == null) {
            if (cRecipient.getCredito_agencia_n() != null) {
                recipient.setCredito_agencia_n(cRecipient.getCredito_agencia_n());
            }
        }
        if (recipient.getCredito_agencia_nome() == null) {
            if (cRecipient.getCredito_agencia_nome() != null) {
                recipient.setCredito_agencia_nome(cRecipient.getCredito_agencia_nome());
            }
        }
        if (recipient.getCredito_banco_n() == null) {
            if (cRecipient.getCredito_banco_n() != null) {
                recipient.setCredito_banco_n(cRecipient.getCredito_banco_n());
            }
        }
        if (recipient.getCredito_agencia_n() == null) {
            if (cRecipient.getCredito_banco_nome() != null) {
                recipient.setCredito_banco_nome(cRecipient.getCredito_banco_nome());
            }
        }
        if (recipient.getCredito_cc_n() == null) {
            if (cRecipient.getCredito_cc_n() != null) {
                recipient.setCredito_cc_n(cRecipient.getCredito_cc_n());
            }
        }
        return recipientsRepository.save(recipient);
    }

    @GetMapping(value = "/documento")
    public EntityRPRecipient postRecipientdoc(@RequestParam String doc) {
        return recipientsRepository.findBydocument(doc);
    }

}
