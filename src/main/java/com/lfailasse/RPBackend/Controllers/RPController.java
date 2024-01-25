package com.lfailasse.RPBackend.Controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lfailasse.RPBackend.DTOs.RPDTO;
import com.lfailasse.RPBackend.Models.EntityRP;
import com.lfailasse.RPBackend.Models.EntityRPItems;
import com.lfailasse.RPBackend.Models.EntityRPRecipient;
import com.lfailasse.RPBackend.Repositories.RPRecipientsRepository;
import com.lfailasse.RPBackend.Repositories.RPRepository;

@RestController
@RequestMapping(value = "/rp")
public class RPController {

    @Autowired
    private RPRecipientsRepository recipientsRepository;

    @Autowired
    private RPRepository rpRepository;

    @Autowired
    private RPRecipientController rpRecipientController;
    
    @GetMapping()
    public Page<EntityRP> getAll(@RequestParam int page) {
        Sort sort = Sort.by("count").descending();
        Pageable pageable = PageRequest.of(page, 50, sort);
        return rpRepository.findAll(pageable);
    }

    @GetMapping(value = "/search")
    public Page<EntityRP> findRPByParam(@RequestParam String id, String fav, int page) throws Exception {
        Sort sort = Sort.by("rp_count").descending();
        Pageable pageable = PageRequest.of(page, 50, sort);
        if (fav != null) {
            return rpRepository.findByfavorecido(fav, pageable);
        } else if (id != null) {
            return rpRepository.findByIdPage(id, pageable);
        } else {
            throw new Exception("Erro");
        }
    }

    @PostMapping()
    public EntityRP saveRP(@RequestBody RPDTO rpdto) throws ParseException {
        SimpleDateFormat getdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newdate = new SimpleDateFormat("dd/MM/yyyy");
        String dataemissao = newdate.format(getdate.parse(rpdto.getEntityRP().getDataemissao()));
        String datapagamento = newdate.format(getdate.parse(rpdto.getEntityRP().getDatapagamento()));
        Double total = 0.0;
        EntityRP eRp = rpdto.getEntityRP();
        List<EntityRPItems> eRpItems = new ArrayList<>();
        for (EntityRPItems entityRPItems : rpdto.getRpitems()) {
            total += entityRPItems.getValor();
            eRpItems.add(entityRPItems);
        }
        eRp.setRpitems(eRpItems);
        eRp.setTotal(total);
        eRp.setDataemissao(dataemissao);
        eRp.setDatapagamento(datapagamento);
        eRp.setStatus(false);
        LocalDate localDate = LocalDate.now(ZoneId.of("GMT-03:00"));
        Date nDate = Date.valueOf(localDate);
        SimpleDateFormat date = new SimpleDateFormat("yyyyMM");
        String cDate = date.format(nDate);
        EntityRP entityRP = rpRepository.findTopByOrderByCountDesc();
        List<EntityRPItems> cItems = new ArrayList<>();
        for (EntityRPItems items : rpdto.getRpitems()) {
            items.setEntityRP(eRp);
            cItems.add(items);
        }
        eRp.setRpitems(cItems);
        if (entityRP != null) {
            long count = entityRP.getCount() + 1;
            String cId = "RP" + cDate.concat("-" + count).toString();
            eRp.setCount(count);
            eRp.setId(cId);
        } else {
            long count = 1;
            String cId = "RP" + cDate.concat("-" + count).toString();
            eRp.setCount(count);
            eRp.setId(cId);
        }
        EntityRPRecipient rpRecipient = recipientsRepository.findBydocument(rpdto.getEntityRP().getDocumento());
        if (rpRecipient != null) {
            rpRecipient.setCredito_banco_n(rpdto.getEntityRP().getBanco_n());
            rpRecipient.setCredito_banco_nome(rpdto.getEntityRP().getBanco_nome());
            rpRecipient.setCredito_agencia_n(rpdto.getEntityRP().getAgencia_n());
            rpRecipient.setCredito_agencia_nome(rpdto.getEntityRP().getAgencia_nome());
            rpRecipient.setCredito_cc_n(rpdto.getEntityRP().getCc_n());
            rpRecipient.setPix(rpdto.getEntityRP().getAnexo());
            rpRecipient.setLastpayment(rpdto.getEntityRP().getPagamento());
            rpRecipientController.changeRecipient(rpRecipient);
        }
        return rpRepository.save(eRp);
    }

    @PatchMapping(value = "/cancel/{id}")
    public EntityRP cancelRP(@PathVariable String id){
        EntityRP entityRP = rpRepository.findByid(id);
        entityRP.setStatus(true);
        return rpRepository.save(entityRP);
    }
    

}
