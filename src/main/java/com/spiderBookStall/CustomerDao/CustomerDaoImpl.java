package com.spiderBookStall.CustomerDao;
import com.spiderBookStall.CustomerDto.CustomerDetail;
import com.spiderBookStall.CustomerDto.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoImpl implements CustomerDao {
    private JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveRegisterdCustomer(CustomerDetail register) {
        String query = "insert into customerregistration(firstName,lastName,email,password,rePassword,contact,dob,addressLine1,addressLine2,city,state,pinCode,role) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try{
            int result = this.jdbcTemplate.update(query, register.getFirstName(), register.getLastName(), register.getEmail(), register.getPassword(), register.getRePassword(), register.getContact(), register.getDob(), register.getAddressLine1(), register.getAddressLine2(), register.getCity(), register.getState(), register.getPinCode(), register.getRole());
            return result;

        } catch ( DataIntegrityViolationException e) {
            System.out.println(e+"error message");
            e.printStackTrace();

        }
        return 0;
    }

    @Override
    public CustomerDetail getRecordById(String EmailID)
    {

        MyRowMapper myRowMapper = new MyRowMapper();
        System.out.println(EmailID);
        String query = "select * from customerregistration where email=?";
        return (CustomerDetail) this.jdbcTemplate.queryForObject(query, myRowMapper, EmailID);


    }

    @Override
    public int updateProfile(CustomerDetail detail)
    {
        String query="update book.customerregistration set firstName=?,lastName=?,password=?,rePassword=?,contact=?,dob=?,addressLine1=?,addressLine2=?,city=?,state=?,pinCode=? where email=?";
        return this.jdbcTemplate.update(query,detail.getFirstName(),detail.getLastName(),detail.getPassword(),detail.getRePassword(),detail.getContact(),detail.getDob(),detail.getAddressLine1(),detail.getAddressLine2(),detail.getCity(),detail.getState(),detail.getPinCode(),detail.getEmail());
    }

    @Override
    public int saveOrder(Order order)
    {
        String query="insert into book.order values(?,?,?,?)";
       return this.jdbcTemplate.update(query,order.getUserId(),order.getOderId(),order.getProductID(),order.getPaymentMethod());

    }

    @Override
    public CustomerDetail getProfile(String EmailId) {
        String Emailid1=EmailId+".com";
        MyRowMapper myRowMapper = new MyRowMapper();
        String query = "select * from customerregistration where email=?";
        return (CustomerDetail) this.jdbcTemplate.queryForObject(query, myRowMapper, Emailid1);    }



}
