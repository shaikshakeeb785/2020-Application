package com.spiderBookStall.CustomerService;

import com.spiderBookStall.CustomerDao.CustomerDao;
import com.spiderBookStall.CustomerDto.CustomerDetail;
import com.spiderBookStall.CustomerDto.Order;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;


public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
    @Override
    public int saveRegisterCustomer(CustomerDetail customerRegistration)
    {

        return customerDao.saveRegisterdCustomer(customerRegistration);
    }

    @Override
    public CustomerDetail getRecordById(String EmailId) {
        return customerDao.getRecordById(EmailId);
    }

    @Override
    public int updateProfile(CustomerDetail detail) {
        System.out.println(detail+"UNDER SERVICE SAVEUPDATE");

        return customerDao.updateProfile(detail);
    }

    @Override
    public int saveOrder(Order order) {

        return customerDao.saveOrder(order);
    }

    @Override
    public CustomerDetail getProfile(String EmailId) {
        return customerDao.getProfile(EmailId);
    }





    public CustomerDao getCustomerDao() {
        return customerDao;
    }
    @Required
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
