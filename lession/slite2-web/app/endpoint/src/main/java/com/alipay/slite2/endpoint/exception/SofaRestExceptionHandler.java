package com.alipay.slite2.endpoint.exception;

import com.alibaba.common.lang.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * SofaRestExceptionHandler
 * <p/>
 * Sofa Rest 关键异常处理:实践样例,定义自己的异常分别处理这样更好
 * <p/>
 * Created by yangguanchao on 16/11/18.
 */
@Component
@Provider
public class SofaRestExceptionHandler implements ExceptionMapper<Throwable> {

    private static final Logger logger = LoggerFactory
            .getLogger(SofaRestExceptionHandler.class);


    public static final String ERROR_CODE_KEY = "code";
    public static final String MESSAGES_KEY = "messages";
    private static final int ERROR_STATUS = 451;

    @Override
    public Response toResponse(Throwable ex) {
        String errorCode = "NO Common Error Code!!";
        String message = "";

        if (ex instanceof CommonException) {
            CommonException casted = (CommonException) ex;
            errorCode = StringUtil.isBlank(casted.getErrorCode()) ? errorCode : casted
                    .getErrorCode();
            message = casted.getMessage();

        } else {
            errorCode = "NO Common Error Code!!";
            message = MessageFormat.format("Unknown Exception[{0}]", ex.getMessage());
        }

        logger.error("web api error!", ex);
        logger.error("errorCode={0}, message={1}", errorCode, message);

        Map errorMap = new HashMap<String, String>();
        errorMap.put(ERROR_CODE_KEY, errorCode);
        errorMap.put(MESSAGES_KEY, Arrays.asList(message));
        return Response.status(ERROR_STATUS).entity(errorMap).build();
    }
}
