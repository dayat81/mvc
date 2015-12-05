package test.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import test.mvc.cust.dao.CustDAO;
import test.mvc.cust.model.Cust;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
        	 
            CustDAO customerDAO = (CustDAO) context.getBean("customerDAO");
            Cust customer = new Cust(1, "mkyong",28);
            customerDAO.insert(customer);
        	
            Cust customer1 = customerDAO.findByCustomerId(1);
            System.out.println(customer1);
		String msg="test controller";
		return new ModelAndView("home","msg",msg);
	}
}
