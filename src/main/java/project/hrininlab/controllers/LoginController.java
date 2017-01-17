package project.hrininlab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import project.hrininlab.Entity.DAO.UserDao;
import project.hrininlab.Entity.User;


/**
 * Created by mrhri on 15.01.2017.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String doWelcome(ModelMap model){

        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(WebRequest request, ModelMap model){

        UserDao dao = new UserDao();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = dao.get_user_by_login(login);

        if(!password.equals(user.getPassword())){
            model.addAttribute("error","Пароль не верный");
            System.out.println("ошибка");
            return null;
        }else{
            return "adminpage";
        }
    }
}
