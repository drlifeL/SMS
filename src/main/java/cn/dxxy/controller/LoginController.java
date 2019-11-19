package cn.dxxy.controller;

import cn.dxxy.entity.Admin;
import cn.dxxy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/toLogin")
    public String login(Admin admin, HttpServletRequest request, Model model) {
        if (loginService.userExist(admin)) {
            request.getSession().setAttribute("user", admin.getaId());
            return "redirect:showStuInfo";
        }
        model.addAttribute("errorInfo", "用户名或密码错误！");
        return "forward:toLoginPage";
    }

    @RequestMapping("/toLoginPage")
    public String toLoginPage() {
        return "realLogin";
    }

    @RequestMapping("/toAdminEditPage")
    public String toEditPage() {
        return "admin/updateUser";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "login";
    }

    @RequestMapping("/updateAdmin")
    public String updateAdmin(String oldPassword, String newPassword, String againPassword, HttpServletRequest request, Model model) {
        if (oldPassword == null || newPassword == null || againPassword == null) {
            model.addAttribute("error", "不能提交空字段！");
            return "forward:toAdminEditPage";
        }
        if (newPassword.length() < 6) {
            model.addAttribute("error", "密码的长度必须大于6位");
            return "forward:toAdminEditPage";
        }
        if (!newPassword.equals(againPassword)) {
            model.addAttribute("error", "新密码两次不一致");
            return "forward:toAdminEditPage";
        }

        String userId = (String) request.getSession().getAttribute("user");
        Admin user = loginService.findUserById(userId);
        //cha
        if (user.getaPassword().equals(oldPassword)) {
            user.setaPassword(newPassword);
            loginService.updateAdmin(user);
        } else {
            model.addAttribute("error", "旧密码不正确");
            return "forward:toAdminEditPage";
        }
        return "redirect:logout";
    }

}
