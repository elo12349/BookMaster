package com.example.web.controller;
import java.util.Calendar;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.Entity.BookMaster;
import com.example.model.BookMasterModel;
import com.example.service.BookMasterService;
import Form.BookMasterForm;


/**
 * 
 * ã€�ã‚¯ãƒ©ã‚¹ã�®èª¬æ˜Žã€‘ 
 * æœ¬ãƒžã‚¹ã‚¿ã�®ã‚³ãƒ³ãƒˆãƒ­ãƒ¼ãƒ©ã‚¯ãƒ©ã‚¹
 * 
 * ã€�å¤‰æ›´å±¥æ­´ã€‘ 1.00 2018/09/16 æ–°è¦�ä½œæˆ�
 * 
	 * @author T.Yagi
 * 
 * @version 1.00
 *
 */
@Controller
@RequestMapping("/")
public class BookMasterController {
    @Autowired
    private BookMasterService bookMasterService;
    				
    @GetMapping("/")
    public String index(Model model) {
        if (!model.containsAttribute("bookMaster")) {
            model.addAttribute("bookMaster", new BookMasterForm());
        }
        return "bookmaster";
    }

    @PostMapping(value = "/", params = "btn_search=検索")
    public String show(String bookId, RedirectAttributes redirectAttributes,BookMasterModel model) {  
    	BookMaster bookMaster = bookMasterService.findById(bookId);
        if(bookMaster != null) {
        	BookMasterForm form = new BookMasterForm();
        	form.setBookId(bookMaster.getBookId());
        	form.setBookTitle(bookMaster.getBookTitle());
        	form.setAuthorName(bookMaster.getAuthorName());
        	form.setPublisher(bookMaster.getPublisher());
        	Calendar publicationDay = Calendar.getInstance();
        	
            redirectAttributes.addFlashAttribute("bookMaster", form);
        	
        }
         return "redirect:/";
    }

    @PostMapping(value = "/", params = "btn_insert=add")
    public String add(@ModelAttribute("bookMaster") BookMasterForm bookMasterForm, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("bookMaster", bookMasterForm);
        BookMasterModel model = new BookMasterModel();
        model.setBookId(bookMasterForm.getBookId());
        model.setBookTitle(bookMasterForm.getBookTitle());
        model.setAuthorName(bookMasterForm.getAuthorName());
        model.setPublisher(bookMasterForm.getPublisher());
        Calendar publicationDay = Calendar.getInstance();
        publicationDay.set(bookMasterForm.getPublicationYear(), bookMasterForm.getPublicationMonth(), bookMasterForm.getPublicationDate());
        model.setPublicationDay(publicationDay.getTime());
        bookMasterService.insert(model);
        return "redirect:/";
    }

    @PostMapping(value = "/", params = "btn_update=update")
    public String update(@ModelAttribute BookMasterForm bookMasterForm, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("bookMaster", bookMasterForm);
        BookMasterModel model = new BookMasterModel();
        bookMasterForm.setBookId(model.getBookId());
        bookMasterForm.setBookTitle(model.getBookTitle());
        bookMasterForm.setAuthorName(model.getAuthorName());
        bookMasterForm.setPublisher(model.getPublisher());
        Calendar publicationDay = Calendar.getInstance();
        publicationDay.set(bookMasterForm.getPublicationYear(), bookMasterForm.getPublicationMonth(),bookMasterForm.getPublicationDate());
        model.setPublicationDay(publicationDay.getTime());
        bookMasterService.update(model);
        return "redirect:/";
    }

    @PostMapping(value = "/", params = "btn_delete=delete")
    public String destroy(String bookId)  {
        bookMasterService.deletebyId(bookId);
        return "redirect:/";
    }
}