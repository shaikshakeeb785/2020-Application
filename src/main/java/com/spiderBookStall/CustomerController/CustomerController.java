package com.spiderBookStall.CustomerController;
import com.spiderBookStall.CustomValidator.CustomerRegistrationValidator;
import com.spiderBookStall.CustomerDto.CustomerDetail;
import com.spiderBookStall.CustomerDto.Order;
import com.spiderBookStall.CustomerService.CustomerService;
import com.spiderBookStall.RestService.BookRestApiService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Random;

@Controller
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRegistrationValidator customerRegistrationValidator;
    @Autowired
    @Qualifier("BookRestApiService")
    private BookRestApiService bookRestApiService;

    private static final Logger logger = LogManager.getLogger(CustomerController.class);
    @RequestMapping(value = "/Register",method = RequestMethod.GET)
    public String customerRegistration( Model model)
    {
        model.addAttribute("registerObject", new CustomerDetail());

        return "customerRegistrationPage";
    }
    @RequestMapping(value = "/saveRegister",method = RequestMethod.POST)
    public String saveRegisteredCustomer(@Valid @ModelAttribute("registerObject") CustomerDetail customerRegistration, BindingResult result, Model model)
    {
        BasicConfigurator.configure();
        logger.info("here i am  calling custom validation method valid for validation ");
        customerRegistrationValidator.validate(customerRegistration,result);
       if(result.hasErrors())
       {
           return "customerRegistrationPage";
       }
       else{
           int result1=customerService.saveRegisterCustomer(customerRegistration);
           if(result1>=1)
           {
               return "redirect:/login";
           }else {
               return "error";
           }
       }
    }
    @RequestMapping(value = "/profile/{emailId}",method = RequestMethod.GET)
    public  String getRecordById(@PathVariable("emailId") String emailId,Model model)
    {

        logger.info("to access the profile of customer by using MailId ");
        CustomerDetail customerDetail=customerService.getProfile(emailId);
        model.addAttribute("cutomerDetail",customerDetail);
        return "profilePage";
    }
    @RequestMapping(value = "buyBook/{bookid}", method = RequestMethod.GET)
    public String buyBook(@PathVariable("bookid") String bookID, Principal principal, Model model)
    {
        logger.info("inside buyBook method ");
        CustomerDetail customerDetail=customerService.getRecordById(principal.getName());
        model.addAttribute("customerDetail", customerDetail);
        model.addAttribute("bookid", bookID);


        return "checkOutPage";
    }
    @RequestMapping(value = "/orderPlaced/{bookid}",method = RequestMethod.GET)
    public String oderPlaced(@ModelAttribute("order") Order order1,@PathVariable("bookid") String bookid, Principal principal, Model model)
    {
        logger.info("inside buyBook method ");
        order1.setProductID(bookid);
        Random random=new Random();
        int orderId=random.nextInt();
        String UserId=principal.getName();
        order1.setUserId(UserId);
        order1.setOderId(orderId);
        model.addAttribute("orderId",orderId);
        model.addAttribute("bookObject1",bookRestApiService.getBookById(bookid));
        int result=customerService.saveOrder(order1);
        if(result>=1)
        {
            return "orderPlacedPage";
        }
        return null;
    }
    @RequestMapping(value = "/editCustomer/{email}",method = RequestMethod.GET)
    public String updateProfile(@PathVariable("email") String Email, Model model)
    {

        CustomerDetail customerDetail=customerService.getProfile(Email);
        model.addAttribute("customerObject",customerDetail);

        return "updatePage";
    }
    @RequestMapping(value = "/saveUpdate",method = RequestMethod.POST)
     public String updateProfile(@ModelAttribute("customerObject") CustomerDetail detail)
    {
        int result= customerService.updateProfile(detail);
       if(result>=1)
       {
           return "saveUpdatePage";
       }
       return "error";
    }

}
