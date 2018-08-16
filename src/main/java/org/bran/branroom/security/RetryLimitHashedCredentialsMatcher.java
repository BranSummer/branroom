package org.bran.branroom.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;


/**
 * @Description 凭证匹配器
 *
 * 指定散列算法为hash
 * 散列迭代次数为2
 * 存储散列后的密码为16进制
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        return super.doCredentialsMatch(token, info);
    }
}
