package com.spiderBookStall.RestService;

import com.spiderBookStall.CustomerController.CustomerController;
import com.spiderBookStall.CustomerDto.Book;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * implementation for {@link BookRestApiService}
 */
public class BookRestApiServiceImpl implements BookRestApiService {
    private static final Logger logger = LogManager.getLogger(BookRestApiServiceImpl.class);

    private RestTemplate restTemplate;

    @Override
    public List<Book> getALLBookRestData() {
        BasicConfigurator.configure();

        String url= "http://localhost:8081/SpiderBookStore_war_exploded/getAllBooksjson";
        try{
            ResponseEntity<Book[]> responseEntity= restTemplate.getForEntity(url,Book[].class);
            if(responseEntity.getBody()!=null)
            {
                return  Arrays.asList(responseEntity.getBody());
            }
        } catch (RestClientException e) {
            logger.error("WHAT IS THE ERROR SHOW ME"+e);
            e.printStackTrace();
        }

        return  Collections.emptyList();
    }

    @Override
    public Book getBookById(String bookId) {
        String url="http://localhost:8081/SpiderBookStore_war_exploded/getByIdjsondata?bookId="+bookId;
       Book book= restTemplate.getForObject(url,Book.class);
        return book;
    }
    @Override
    public  Book sellerPortal(Book book)
    {
        String url="http://localhost:8081/SpiderBookStore_war_exploded/clientBookObject";
        try{
            Book book1=getRestTemplate().postForObject(url,book,Book.class);
            return book1;

        } catch (RestClientException e) {
            logger.error("exception"+e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteSellerBook(String sellerName) {
        String url="http://localhost:8081/SpiderBookStore_war_exploded/deleteClientBook";
        Book book1=getRestTemplate().postForObject(url,sellerName,Book.class);
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
    @Required
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
