package com.spiderBookStall.CustomValidator;
import com.spiderBookStall.CustomerDto.CustomerDetail;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class CustomerRegistrationValidator implements Validator
{

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors)
    {
        CustomerDetail customerRegistration=(CustomerDetail)o;
        validateCustomerFirstName(customerRegistration.getFirstName(),errors);
        validateCustomerEmail(customerRegistration.getEmail(),errors);
        validateCustomerPassword(customerRegistration.getPassword(),errors);
        validateCustomerRePassword(customerRegistration.getRePassword(),customerRegistration.getPassword(),errors);
        validateCustomerContact(customerRegistration.getContact(),errors);
        validateCustomerDob(customerRegistration.getDob(),errors);
        validateCustomerAddressLine1(customerRegistration.getAddressLine1(),errors);
        validateCustomerCity(customerRegistration.getCity(),errors);
        validateCustomerState(customerRegistration.getState(),errors);
        validateCustomerPin(customerRegistration.getPinCode(),errors);

    }

    private void validateCustomerPin(Long pinCode, Errors errors)
    {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pinCode", "pinCode.errors", "*pincode should not Empty");
    }
    private void validateCustomerLastName(String lastName, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.errors", "*lastName cannot be empty");

    }
    private void validateCustomerFirstName(String firstName, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.errors", "*firstName cannot be empty");

    }
    private void validateCustomerState(String state, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "state.errors", "*state cannot be empty");

    }
    private void validateCustomerCity(String city, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "city.errors", "*city cannot be empty");

    }
    private void validateCustomerAddressLine2(String addressLine2, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine2", "addressLine2.errors", "*addressLine2 cannot be empty");

    }
    private void validateCustomerAddressLine1(String addressLine1, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "addressLine1.errors", "*addressLine1 cannot be empty");

    }
    private void validateCustomerDob(String dob, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "dob.errors", "*dob cannot be empty");

    }
    private void validateCustomerContact(Long contact, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "contact.errors", "*contact cannot be empty");

    }

    private void validateCustomerPassword(String password, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.errors", "*password cannot be empty");

    }
    private void validateCustomerRePassword(String rePassword,String Password, Errors errors)
    {
        if(!rePassword.equals(Password))
        {
            errors.rejectValue("rePassword", "rePassword.errors", "*Password MisMatch please chech you password");

        }
    }
    private void validateCustomerEmail(String email, Errors errors)
    {
        if(email.length()<15||!email.endsWith("@gmail.com"))
        {
                errors.rejectValue("email", "email.errors", "*Enter mail id formate is wrong mail end with @gmail.com");
        }
    }


}
