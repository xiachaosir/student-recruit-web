package com.student.recruit.controller;

import com.student.recruit.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Description .
 * @Author xiachao
 * @CreateTime 2017/1/11 14:24
 */
@Controller
public class LoginController {
  private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

  @GetMapping("login")
  public String login(@ModelAttribute Subject currentUser) {
    if(currentUser.isAuthenticated()){
      return "redirect:index";
    }
    return "login";
  }

  @PostMapping("login")
  public String login(@Validated User user, @ModelAttribute Subject currentUser, BindingResult
      bindingResult, RedirectAttributes redirectAttributes) {
    if(bindingResult.hasErrors()){
      return "login";
    }
    String username = user.getUsername();
    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),
        user.getPassword());

    try {
      //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
      //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
      //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
      logger.info("对用户[" + username + "]进行登录验证..验证开始");
      currentUser.login(usernamePasswordToken);
      logger.info("对用户[" + username + "]进行登录验证..验证通过");
    }catch(UnknownAccountException uae){
      logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
      redirectAttributes.addFlashAttribute("message", "未知账户");
    }catch(IncorrectCredentialsException ice){
      logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
      redirectAttributes.addFlashAttribute("message", "密码不正确");
    }catch(LockedAccountException lae){
      logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
      redirectAttributes.addFlashAttribute("message", "账户已锁定");
    }catch(ExcessiveAttemptsException eae){
      logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
      redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
    }catch(AuthenticationException ae){
      //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
      logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
      ae.printStackTrace();
      redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
    }
    if(currentUser.isAuthenticated()){
      logger.info("用户"+username+"认证成功");
    /* Session session = currentUser.getSession();
     session.setAttribute("username",username);
     session.setTimeout(300000);*/
      redirectAttributes.addFlashAttribute("username",username);
      return "redirect:index";
    }else{
      usernamePasswordToken.clear();
      return "login";
    }
  }

  @GetMapping(value="logout")
  public String logout(RedirectAttributes redirectAttributes ){
    //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
    SecurityUtils.getSubject().logout();
    redirectAttributes.addFlashAttribute("message", "您已安全退出");
    return "redirect:/login";
  }

  @ModelAttribute
  public Subject currentUser(){
    return SecurityUtils.getSubject();
  }
}
