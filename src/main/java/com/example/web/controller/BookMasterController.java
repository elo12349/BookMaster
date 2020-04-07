package com.example.web.controller;
import java.util.Calendar;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/BookMaster")
public class BookMasterController {
    @Autowired
    private BookMasterService bookMasterService;
	private BookMasterModel bookMaster;
	 
	
	@GetMapping("/{id}")
    public String show(String bookId,Model model) {
		
		 model.addAttribute("bookMaster", bookMasterService.findById(bookId));
		Optional<BookMaster> bookMaster = bookMasterService.findById(bookId);
        return "BookMaster";
    }

	@GetMapping("")
	public String newbook(Model model) {
		 if (!model.containsAttribute("bookMaster")) {
	            model.addAttribute("bookMaster", new BookMasterForm());
	        }
			return "bookmaster";
		}
	@PostMapping("")
	 public String add(@ModelAttribute("bookMasterForm") BookMasterForm bookMasterForm,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("BookMaster", bookMasterForm);
		BookMasterModel model = new BookMasterModel();
		model.setBookId(bookMasterForm.getBookId());
		model.setBookTitle(bookMasterForm.getBookTitle());
		model.setAuthorName(bookMasterForm.getAuthorName());
		model.setPublisher(bookMasterForm.getPublisher());
		Calendar publicationDay = Calendar.getInstance();
		publicationDay.set(bookMasterForm.getPublicationYear(),bookMasterForm.getPublicationMonth(),bookMasterForm.getPublicationDate());
		model.setPublicationDay(publicationDay.getTime());
		bookMasterService.insert(model);
		return "redirect:/BookMaster";
    } 
	@RequestMapping(value="/BookMaster",method = RequestMethod.POST)
    public String update(String bookId, @ModelAttribute BookMasterForm bookMasterForm,HttpServletRequest request) {
        request.getParameter("btn-update");
        
        bookMasterService.update(bookMaster);
        return "redirect:/BookMaster";
    }
	@RequestMapping(value="/BookMaster/{bookId}",method = RequestMethod.GET)  
    public String destroy(String bookId,HttpServletRequest request) {
		request.getParameter("btn-delete");
        bookMasterService.deletebyId(bookId);
        return "redirect:/BookMaster";
    }
	
}