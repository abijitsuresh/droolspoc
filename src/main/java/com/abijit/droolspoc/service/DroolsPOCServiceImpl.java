package com.abijit.droolspoc.service;

import com.abijit.droolspoc.model.Request;
import com.abijit.droolspoc.model.Response;
import lombok.extern.log4j.Log4j2;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Log4j2
@Service
public class DroolsPOCServiceImpl implements DroolsPOCService {
    private final KieContainer kieContainer;

    public DroolsPOCServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Override
    public Response getSimpleResponse(Request request) {
        log.info("request: {}", request);
        Response response = new Response();
        KieSession kieSession = kieContainer.newKieSession();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup("simpleObject").setFocus();
        kieSession.setGlobal("response", response);
        kieSession.insert(request);
        kieSession.fireAllRules();
        kieSession.dispose();
        log.info("response: {}", response);
        return response;
    }

    @Override
    public Response getResponse(Request request) {
        log.info("request: {}", request);
        Response response = new Response();
        KieSession kieSession = kieContainer.newKieSession();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup("objectWithSubObject").setFocus();
        kieSession.setGlobal("response", response);
        kieSession.insert(request);
        kieSession.fireAllRules();
        kieSession.dispose();
        log.info("response: {}", response);
        return response;
    }

    @Override
    public List<Response> getResponses(Request request) {
        log.info("request: {}", request);
        List<Response> responses = new ArrayList<>();
        var response = new Response();
        KieSession kieSession = kieContainer.newKieSession();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup("simpleTestList").setFocus();
        kieSession.setGlobal("response", response);
        kieSession.setGlobal("responses", responses);
        kieSession.insert(request);
        kieSession.fireAllRules();
        Collection<?> objects = kieSession.getObjects();
        for (var object : objects) {
            if (object instanceof Response response1) {
                responses.add(response1);
            }
        }
        kieSession.dispose();
        log.info("response: {}", responses);
        return responses;
    }
}
