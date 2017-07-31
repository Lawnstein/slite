# SOFALite2ProjectDemo  工程

## 一、启动方式:保证两种方式均能正常启动成功，本地模式和云上启动模式均正确运行

### 1.1 IDE 中启动（本地启动模式）

* 直接运行`Slite2WebSpringBootAPPNAMEApplication` 这个函数即可，既可以正常运行也可以 debug 运行

### 1.2 java -jar 的方式运行（云上启动模式）

*  在项目工程的根目录下执行:

`java -jar ./target/APPNAME-web-1.0-SNAPSHOT-executable.jar`

* 本地debug 运行：

`java -jar -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000  ./target/APPNAME-web-1.0-SNAPSHOT-executable.jar`

## 二、验证

* 如果使用 `SOFA REST` 中间件，可以访问如下

`http://localhost:8341/webapi/users/xiaoming`得到类似如下的json数据输出即可认为成功，

```
{
data: {
realName: "Real xiaoming",
userId: 0,
userName: "xiaoming"
},
success: true
}

```

* 访问静态页面：

`http://localhost:8080/index.html`