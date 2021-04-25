package com.spiderBookStall.CustomerDao;

import com.spiderBookStall.CustomerDto.CustomerDetail;
import com.spiderBookStall.CustomerDto.Order;

public interface CustomerDao
{
    /**saveRegisterdCustomer method is used to saved the data into the database and return no of record is effected
     * @return no of record is effected
     */
    public int saveRegisterdCustomer(CustomerDetail customerRegistration);

    /**
     * @param EmailID used to get a particular record from the database
     * @return CustomerDetail
     */
    public CustomerDetail getRecordById(String EmailID);

    /**updating customerProfile by using email
     * @param detail customer updated detail
     * @return no of record is effected
     */
    public int updateProfile(CustomerDetail detail);

    /**
     * @param order it is object of ORDER which is saved into  database.
     * @return no of record is effected;
     */
    public int saveOrder(Order order);
    /**
     * @param EmailId using id getting customerProfile detail
     * @return customerProfile
     */
    public CustomerDetail getProfile(String EmailId);

    /**
     * @param Email it is used to update a record of customer from the database
     * @return updated Customer detaile
     */

}
