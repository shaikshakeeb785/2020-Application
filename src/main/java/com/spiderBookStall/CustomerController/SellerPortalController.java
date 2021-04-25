package com.spiderBookStall.CustomerController;

import com.spiderBookStall.CustomerDto.Book;
import com.spiderBookStall.RestService.BookRestApiService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Random;

@Controller
public class SellerPortalController
{
    private static final Logger logger = LogManager.getLogger(SellerPortalController.class);

    @Autowired
    private BookRestApiService bookRestApiService;

     @RequestMapping("/sellerportal")
    public String sellerPortal()
    {
        return "sellerPortal";
    }
    @RequestMapping("/addbook")
    public String addBook( Model model)
    {
        Book book=new Book();
        model.addAttribute("book",book);
        return "addBookPage";
    }
    @RequestMapping(value = "/clientBookObject",method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book")Book  book,Model model)
    {
        System.out.println("inside save book clint");
        Random random=new Random();
        int bookId=random.nextInt();
        String bookId1="customer_"+bookId;
        book.setBookId(bookId1);
        System.out.println(book.toString());
       Book book1= bookRestApiService.sellerPortal(book);

           model.addAttribute("book",book1);
           return "success" ;      
    }
    @RequestMapping("/listOfBook")
    public String getListOfBook()
    {
        return "listOfBOOKPage";
    }
    @RequestMapping("/updateBook")
    public String updateBook()
    {
        return "updateBookPage";
    }
    @RequestMapping("/delete")
    public String deleteSellerBook(@RequestParam String emailId)
    {
        bookRestApiService.deleteSellerBook(emailId);

        return "deleteSellerBook";
    }
}
