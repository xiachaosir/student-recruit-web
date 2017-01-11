package com.student.recruit.realm;

import com.student.recruit.domain.User;
import com.student.recruit.repository.UserRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description .
 * @Author xiachao
 * @CreateTime 2017/1/11 15:24
 */

public class UserRealm extends AuthorizingRealm {

  private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

  @Autowired
  private UserRepository userRepository;

  /**
   * @Description 授权  .
   * @Author xiachao
   * @CreateTime 2017/1/11 15:33
   * @Param
   * @Return
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

    return null;
  }

  /**
   * @Description 登录认证 .
   * @Author xiachao
   * @CreateTime 2017/1/11 15:34
   * @Param
   * @Return
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws
      AuthenticationException {
    UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
    logger.info("当前subject的token为：" + usernamePasswordToken);
    User user = userRepository.findByUsername(((UsernamePasswordToken) token).getUsername());
    if(user != null) {
      return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
    }
    return null;
  }
}
