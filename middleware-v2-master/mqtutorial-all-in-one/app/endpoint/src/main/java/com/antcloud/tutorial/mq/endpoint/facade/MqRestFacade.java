/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.facade;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.antcloud.tutorial.mq.endpoint.constants.RestConstants;
import com.antcloud.tutorial.mq.endpoint.constants.URLConstants;
import com.antcloud.tutorial.mq.endpoint.model.MqMessage;
import com.antcloud.tutorial.mq.endpoint.response.RestSampleFacadeResp;

import java.util.List;

/**
 * REST interface used to trigger message publish.
 *
 * base url: http://host:port/webapi/mq/
 *
 */
@Path(URLConstants.REST_API_PEFFIX + "/mq")
@Consumes(RestConstants.DEFAULT_CONTENT_TYPE)
@Produces(RestConstants.DEFAULT_CONTENT_TYPE)
public interface MqRestFacade {

    @GET
    @Path("/publish")
    RestSampleFacadeResp<MqMessage> publish() throws Exception;

    @GET
    @Path("/subscribe")
    RestSampleFacadeResp<List<MqMessage>> subscribe() throws Exception;

}
