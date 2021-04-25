package com.spiderBookStall.CustomerController;
import com.spiderBookStall.CustomerService.CustomerService;
import com.spiderBookStall.RestService.BookRestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;

@Controller
public class HomeController
{
    @Autowired
    private BookRestApiService bookRestApiService;
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/homePage")
    public String home(Model model, Principal principal)
    {
        if(principal!=null)
        {
            model.addAttribute("objCustomer", customerService.getRecordById(principal.getName()));
        }
        model.addAttribute("restObject",bookRestApiService.getALLBookRestData());

        return "homePage";
    }
    @RequestMapping("/contact")
    public String aboutUs()
    {
        return "aboutPage";
    }
    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model)
    {

        if (error != null) {
            model.addAttribute("error", "INVALID USERNAME OR PASSWORD!");
        }

        if (logout != null) {
            model.addAttribute("msg", "YOU HAVE LOGGED OUT SUCCESSFULLY.");
        }

        return "loginPage";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model)
    {
        model.addAttribute("title","Logged out page");

        return "logoutPage";
    }
    @RequestMapping(value = "/403", method = RequestMethod.POST)
    public ModelAndView accesssDenied(Principal customer) {

        ModelAndView model = new ModelAndView();
        if (customer != null) {
            model.addObject("msg", "Hi " + customer.getName()+customer
                    + ", You can not access this page!");
        } else {
            model.addObject("msg",
                    "You can not access this page!");
        }

        model.setViewName("notFoundPage");
        return model;
    }
    @RequestMapping(value = "/denied", method = RequestMethod.POST)
    public String denied() {
        System.out.println("under denied");
        return "deniedPage";
    }


}


