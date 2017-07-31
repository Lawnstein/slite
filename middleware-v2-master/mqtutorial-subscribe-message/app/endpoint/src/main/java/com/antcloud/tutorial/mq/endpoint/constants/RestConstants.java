/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.constants;

import javax.ws.rs.core.MediaType;

/**
 * REST constants.
 *
 */
public class RestConstants {

    /**
     * response encoding
     */
    public static final String DEFAULT_CHARSET = "UTF-8";
    /**
     * Content-Type
     */
    public static final String DEFAULT_CONTENT_TYPE = MediaType.APPLICATION_JSON + ";" + MediaType.CHARSET_PARAMETER + "=" + DEFAULT_CHARSET;

}
