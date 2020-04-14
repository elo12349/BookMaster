package com.example.web.controller;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.entity.BookMaster;
import com.example.model.BookMasterModel;
import com.example.service.BookMasterService;
import com.example.web.form.BookMasterForm;

import javax.validation.Valid;


/**
 * ã€�ã‚¯ãƒ©ã‚¹ã�®èª¬æ˜Žã€‘
 * æœ¬ãƒžã‚¹ã‚¿ã�®ã‚³ãƒ³ãƒˆãƒ­ãƒ¼ãƒ©ã‚¯ãƒ©ã‚¹
 * <p>
 * ã€�å¤‰æ›´å±¥æ­´ã€‘ 1.00 2018/09/16 æ–°è¦�ä½œæˆ�
 *
 * @author T.Yagi
 * @version 1.00
 */
@Controller
@RequestMapping("/")
public class BookMasterController {
    @Autowired
    private BookMasterService bookMasterService;
    @Autowired
    private MessageSource messagesource;


    @GetMapping("/")
    public String index(Model model) {
        if (!model.containsAttribute("bookMaster")) {
            model.addAttribute("bookMaster", new BookMasterForm());
        }
        return "bookmaster";
    }

    @PostMapping(value = "/", params = "btn_search")
    public String show(String bookId, RedirectAttributes redirectAttributes, BookMasterModel model) {

        BookMaster bookMaster = bookMasterService.findById(bookId);
        if (bookMaster != null) {
            BookMasterForm form = new BookMasterForm();
            form.setBookId(bookMaster.getBookId());
            form.setBookTitle(bookMaster.getBookTitle());
            form.setAuthorName(bookMaster.getAuthorName());
            form.setPublisher(bookMaster.getPublisher());

            Calendar publicationDay = Calendar.getInstance();
            publicationDay.setTime(bookMaster.getPublicationDay());
            form.setPublicationDate(publicationDay.get(Calendar.DAY_OF_MONTH));
            form.setPublicationMonth(publicationDay.get(Calendar.MONTH) + 1);
            form.setPublicationYear(publicationDay.get(Calendar.YEAR));

            redirectAttributes.addFlashAttribute("bookMaster", form);
        } else {
            //Cái này thì Book mới null nè
            String message = messagesource.getMessage("MSG0004", null, Locale.getDefault());
            // Lấy về rùi thì phải chuyển lên Model HTML mới lấy đc ha
            // Nhớ sửa HTML nha
            redirectAttributes.addFlashAttribute("message", message);
        }


        return "redirect:/";
    }


    // Muốn xài Not NUll thì thêm @Valid để nó kiềm tra, mấy cái lỗi sẽ nằm trong BindResult errors
    @PostMapping(value = "/", params = "btn_insert")
    public String add(@ModelAttribute("bookMaster") @Valid BookMasterForm bookMasterForm, BindingResult errors, RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            // Có lỗi thì làm gì, tức có ít nhất 1 trường bị null
            for (FieldError fieldError : errors.getFieldErrors()) {
                // Field có lồi thì làm gì tự làm nhá
            }
        }
        redirectAttributes.addFlashAttribute("bookMaster", bookMasterForm);
        BookMasterModel model = new BookMasterModel();
        model.setBookId(bookMasterForm.getBookId());
        model.setBookTitle(bookMasterForm.getBookTitle());
        model.setAuthorName(bookMasterForm.getAuthorName());
        model.setPublisher(bookMasterForm.getPublisher());

        Calendar publicationDay = Calendar.getInstance();
        publicationDay.set(bookMasterForm.getPublicationYear(), bookMasterForm.getPublicationMonth() - 1, bookMasterForm.getPublicationDate());
        model.setPublicationDay(publicationDay.getTime());

        bookMasterService.insert(model);
        return "redirect:/";
    }


    @PostMapping(value = "/", params = "btn_update")
    public String update(@ModelAttribute @Valid BookMasterForm bookMasterForm, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("bookMaster", bookMasterForm);
        BookMasterModel model = new BookMasterModel();
        model.setBookId(bookMasterForm.getBookId());
        model.setBookTitle(bookMasterForm.getBookTitle());
        model.setAuthorName(bookMasterForm.getAuthorName());
        model.setPublisher(bookMasterForm.getPublisher());

        Calendar publicationDay = Calendar.getInstance();
        publicationDay.set(bookMasterForm.getPublicationYear(), bookMasterForm.getPublicationMonth() - 1, bookMasterForm.getPublicationDate());
        model.setPublicationDay(publicationDay.getTime());

        bookMasterService.update(model);
        return "redirect:/";
    }

    @PostMapping(value = "/", params = "btn_delete")
    public String destroy(String bookId) {
        bookMasterService.deletebyId(bookId);
        return "redirect:/";
    }
}