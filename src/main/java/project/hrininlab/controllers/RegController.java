package project.hrininlab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

/**
 * Created by mrhri on 14.01.2017.
 */
@Controller
@RequestMapping("/registration")
public class RegController {

    @RequestMapping(method = RequestMethod.GET)
    public String doWelcome(ModelMap model){

        return "registration";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String doPostWelcome(WebRequest request, ModelMap model) throws SQLException, ClassNotFoundException {


        return "registration";
    }
}
