package com.spiderBookStall.CustomerService;

import com.spiderBookStall.CustomerDto.CustomerDetail;
import com.spiderBookStall.CustomerDto.Order;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

public interface CustomerService
{
    /**saveRegisterCustomer method is used to saved the data into the database and return no of record is effected
     * @return no of record is effected
     */
    public int saveRegisterCustomer(CustomerDetail customerRegistration);

    /**
     * @param EmailId get record by using Email id from the database
     * @return CustomerDetail
     */
    public CustomerDetail getRecordById(String EmailId);

    /**updating customerProfile by using email
     * @param detail customer updated detail
     * @return no of record is effected
     */
    public int updateProfile(CustomerDetail detail);

    /**
     * @param order it is object of ORDER which is saved into the database
     * @return no of record is effected;
     */
    public int saveOrder(Order order);

    /**
     * @param EmailId using id getting customerProfile detail
     * @return customerProfile
     */
    public CustomerDetail getProfile(String EmailId);




}
