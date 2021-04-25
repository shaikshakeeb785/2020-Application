package com.spiderBookStall.RestController;
import com.spiderBookStall.CustomerDto.Book;
import com.spiderBookStall.RestService.BookRestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
public class BookRestApiController
{
    @Autowired
    private BookRestApiService bookRestApiService;
    @RequestMapping("/getBookById")
    public String getBookByID(@RequestParam("bookId") String bookId,Model model)
    {
       Book book= bookRestApiService.getBookById(bookId);

        model.addAttribute("bookObject1",book);
        return "getBookByIdPage";
    }
}
