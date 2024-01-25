package com.lfailasse.RPBackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lfailasse.RPBackend.Models.EntityRPRecipient;

public interface RPRecipientsRepository extends JpaRepository<EntityRPRecipient, String> {

    EntityRPRecipient findBydocument(String id);

}
