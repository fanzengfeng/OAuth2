# OAuth2
# 操作方式

### 1. 获取授权码

浏览器请求：

http://localhost:8081/oauth/authorize?client_id=clientapp&redirect_uri=http://localhost:9001/callback&response_type=code&scope=read_userinfo

**注意：state参数暂忽略**

响应案例：

http://localhost:9001/callback?code=8uYpdo

### 2. 获取访问令牌

curl -X POST --user clientapp:112233 http://localhost:8081/oauth/token -H
"content-type: application/x-www-form-urlencoded" -d
"code=8uYpdo&grant_type=authorization_code&redirect_uri=http%3A%2F%2Flocalh
ost%3A9001%2Fcallback&scope=read_userinfo"

案例响应：

```json
{
    "access_token": "36cded80-b6f5-43b7-bdfc-594788a24530",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "read_userinfo"
}
```


### 3. 调用API

curl -X GET http://localhost:8081/api/userinfo -H "authorization: Bearer 36cded80-b6f5-43b7-bdfc-594788a24530"

案例响应：

```json
{
    "name": "user",
    "email": "user@spring2go.com"
}
```
