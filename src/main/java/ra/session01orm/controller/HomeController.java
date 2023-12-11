package ra.session01orm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import ra.session01orm.model.Customer;
import ra.session01orm.repository.ICustomerRepository;
import ra.session01orm.service.ICustomerService;

import java.util.Date;


@Controller
//@RequiredArgsConstructor
public class HomeController {
    @Autowired
    private  ICustomerService customerService;
    @RequestMapping("/add")
    public String home(){
        Customer c = new Customer(7L,"Nguyễn Văn C","0978493575",true,new Date());
        customerService.save(c);
        return "home";
    }
    @RequestMapping("/delete/{id}")
    public String home(@PathVariable Long id){
        customerService.deleteById(id);
        return "home";
    }
    @RequestMapping("/list")
    public String page(Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search, Model model){
       // trong pageable chứa page , size, sort
        Page<Customer> customerPage = customerService.findAllByName(search,pageable);
        model.addAttribute("pages",customerPage);
        model.addAttribute("search",search);
        return "home";

    }
}
