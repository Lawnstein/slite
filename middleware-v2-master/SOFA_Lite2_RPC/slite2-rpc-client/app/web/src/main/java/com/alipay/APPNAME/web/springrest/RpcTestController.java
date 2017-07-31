package com.alipay.APPNAME.web.springrest;

import com.alipay.APPNAME.facade.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8080/rpc/hello
 * RpcTestController
 * <p>
 * Created by yangguanchao on 16/12/12.
 */
@RestController
@RequestMapping("/rpc")
public class RpcTestController {

    @Autowired
    private SampleService sampleRpcService;

    @RequestMapping("/hello")
    String rpcUniqueAndTimeout() {
        String rpcResult = this.sampleRpcService.message();
        return rpcResult;
    }
}
