package com.example.service;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.BookMasterModel;
import com.example.mapper.BookMasterMapper;
import com.example.entity.BookMaster;

@Service
public class BookMasterServiceImpl implements BookMasterService {

	 private final BookMasterMapper bookMasterMapper;

	    @Autowired
	    public BookMasterServiceImpl(BookMasterMapper bookMasterMapper) {
	        this.bookMasterMapper = bookMasterMapper;
	    }
 
	    @Transactional
	    @Override
	    public BookMaster findById(String bookId) {
	    	return bookMasterMapper.findById(bookId);
	    }
	    

	    @Transactional
	    @Override
	    public void deletebyId(String bookId) {
	        bookMasterMapper.deletebyId(bookId);
	    }

	    @Transactional
	    @Override
	    public void update(BookMasterModel model) {
	    	BookMaster bookMaster = new BookMaster();
	    	bookMaster.setBookId(model.getBookId());
	    	bookMaster.setBookTitle(model.getBookTitle());
	    	bookMaster.setAuthorName(model.getAuthorName());
	    	bookMaster.setPublisher(model.getPublisher());
	    	bookMaster.setPublicationDay(model.getPublicationDay());
	    	bookMaster.setUpdateDay(new Date());
	        bookMasterMapper.update(bookMaster);
	    }

    @Override
    public int insert(BookMasterModel model) {
    	BookMaster bookMaster = new BookMaster();
    	bookMaster.setBookId(model.getBookId());
    	bookMaster.setBookTitle(model.getBookTitle());
    	bookMaster.setAuthorName(model.getAuthorName());
    	bookMaster.setPublisher(model.getPublisher());
    	bookMaster.setPublicationDay(model.getPublicationDay());
    	bookMaster.setInsertDay(new Date());
    	return bookMasterMapper.insert(bookMaster);
    }
}
