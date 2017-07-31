/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.alipay.APPNAME.endpoint.constants;

import javax.ws.rs.core.MediaType;

/**
 * constants
 *
 * @author hui.shih
 * @version $Id: RestAPPNAMEConstants.java, v 0.1 2015-8-24 下午2:28:34 hui.shih Exp $
 */
public class RestAPPNAMEConstants {

    /**
     * response encoding
     */
    public static final String DEFAULT_CHARSET = "UTF-8";
    /**
     * Content-Type
     */
    public static final String DEFAULT_CONTENT_TYPE = MediaType.APPLICATION_JSON + ";" + MediaType.CHARSET_PARAMETER + "=" + DEFAULT_CHARSET;

}
