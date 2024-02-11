package com.abijit.droolspoc.service;

import com.abijit.droolspoc.model.Request;
import com.abijit.droolspoc.model.Response;

import java.util.List;

public interface DroolsPOCService {
    Response getSimpleResponse(Request request);
    Response getSimpleResponseFromDRL(Request request);
    Response getObjectWithSubObject(Request request);
    List<Response> getObjectsList(Request request);
}
