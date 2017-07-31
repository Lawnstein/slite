package com.alipay.slite2.endpoint.facade;


import com.alipay.slite2.endpoint.constants.URLConstants;
import com.alipay.slite2.endpoint.exception.CommonException;
import com.alipay.slite2.endpoint.constants.RestConstants;
import com.alipay.slite2.endpoint.model.DemoUserModel;
import com.alipay.slite2.endpoint.response.RestSampleFacadeResp;

import javax.ws.rs.*;

/**
 * rest 服务接口定义,访问示例:
 * <p>
 * 利用 get、post、delete和put方法访问如下地址,依次序进行增删改查
 * <p>
 * <p>
 * <p/>
 * Created by yangguanchao on 16/11/18.
 */
@Path(URLConstants.REST_API_PEFFIX + "/users")
@Consumes(RestConstants.DEFAULT_CONTENT_TYPE)
@Produces(RestConstants.DEFAULT_CONTENT_TYPE)
public interface SampleRestFacade {

    /**
     * 查询
     *
     * http://localhost:8341/webapi/users/xiaoming
     *
     * @param userName
     * @return
     */
    @GET
    @Path("/{userName}")
    public RestSampleFacadeResp<DemoUserModel> userInfo(@PathParam("userName") String userName) throws CommonException;

    /***

     *
     * @param userName 用户账户名称
     * @param realName 用户真实姓名
     * @return
     */

    /**
     * 增加
     *
     * 本地访问方法(注意是post方法,而不是get方法了,可以用postman模仿请求):
     * <p/>
     * http://localhost:8341/webapi/users
     * <p/>
     * post 方法添加一个用户,将用户数据放到 body 中
     * @param user
     * @return
     */
    @POST
    @Path("/")
    public RestSampleFacadeResp<Integer> addUserInfo(DemoUserModel user);

    /**
     * 删除
     *
     * @param userName
     * @return
     */
    @DELETE
    @Path("/{userName}")
    public RestSampleFacadeResp<Integer> deleteUser(@PathParam("userName") String userName);

    /***
     * 更新
     *
     * @param userName
     * @param demoUserModel
     * @return
     */
    @PUT
    @Path("/{userName}")
    public RestSampleFacadeResp<Integer> updateUser(@PathParam("userName") String userName, DemoUserModel demoUserModel);
}
