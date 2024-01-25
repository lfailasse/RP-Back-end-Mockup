package com.lfailasse.RPBackend.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.lfailasse.RPBackend.Models.EntityRP;
import com.lfailasse.RPBackend.Models.EntityRPItems;

public class RPDTO {

    private EntityRP entityRP;

    private List<EntityRPItems> rpitems = new ArrayList<>();

    public RPDTO() {

    }

    public EntityRP getEntityRP() {
        return entityRP;
    }

    public void setEntityRP(EntityRP entityRP) {
        this.entityRP = entityRP;
    }

    public List<EntityRPItems> getRpitems() {
        return rpitems;
    }

    public void setRpitems(List<EntityRPItems> rpitems) {
        this.rpitems = rpitems;
    }

}
