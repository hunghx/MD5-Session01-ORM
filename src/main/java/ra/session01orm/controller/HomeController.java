package ra.session01orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.session01orm.dao.CustomerDao;
import ra.session01orm.model.Customer;

import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    private CustomerDao customerDao;
    @RequestMapping("/add")
    public String home(){
        Customer c = new Customer(7L,"Nguyễn Văn C","0978493575",true,new Date());
        customerDao.save(c);
        return "home";
    }
    @RequestMapping("/delete/{id}")
    public String home(@PathVariable Long id){
        customerDao.delete(id);
        return "home";
    }
}
