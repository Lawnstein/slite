package com.alipay.slite2.endpoint.impl;


import com.alipay.slite2.endpoint.exception.CommonException;
import com.alipay.slite2.endpoint.facade.SampleRestFacade;
import com.alipay.slite2.endpoint.model.DemoUserModel;
import com.alipay.slite2.endpoint.response.RestSampleFacadeResp;

import javax.ws.rs.PathParam;

/**
 * rest 服务实现
 * <p>
 * sofa rest 资源,用于响应 rest 请求
 * <p/>
 * Created by yangguanchao on 16/11/18.
 */
public class SampleRestFacadeRestImpl implements SampleRestFacade {

    public RestSampleFacadeResp<DemoUserModel> userInfo(@PathParam("userName") String userName) throws CommonException {

        DemoUserModel demoUserModel = new DemoUserModel();
        demoUserModel.setRealName("Real " + userName);
        demoUserModel.setUserName(userName);

        RestSampleFacadeResp<DemoUserModel> result = new RestSampleFacadeResp<DemoUserModel>();
        result.setData(demoUserModel);
        result.setSuccess(true);
        return result;
    }

    public RestSampleFacadeResp<Integer> addUserInfo(DemoUserModel user) {
        int id = 1;
        RestSampleFacadeResp<Integer> result = new RestSampleFacadeResp<Integer>();
        result.setData(id);
        result.setSuccess(true);
        return result;
    }

    public RestSampleFacadeResp<Integer> deleteUser(String userName) {
        int deletedCount = 1;
        RestSampleFacadeResp<Integer> result = new RestSampleFacadeResp<Integer>();
        result.setData(deletedCount);
        result.setSuccess(true);
        return result;
    }

    public RestSampleFacadeResp<Integer> updateUser(@PathParam("userName") String userName, DemoUserModel demoUserModel) {
        int updatedCount = 1;
        RestSampleFacadeResp<Integer> result = new RestSampleFacadeResp<Integer>();
        result.setData(updatedCount);
        result.setSuccess(true);
        return result;
    }
}
