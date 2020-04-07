package com.example.service;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.BookMasterModel;
import com.example.mapper.BookMasterMapper;
import com.example.Entity.BookMaster;

@Service
public class BookMasterServiceImpl implements BookMasterService {

	 private final BookMasterMapper bookMasterMapper;

	    @Autowired
	    public BookMasterServiceImpl(BookMasterMapper bookMasterMapper) {
	        this.bookMasterMapper = bookMasterMapper;
	    }
	    
	    @Override
	    public  Optional<BookMaster> findById(String bookId) {
	    	return bookMasterMapper.findById(bookId);
	    }
	    
	    @Override
	    public void deletebyId(String bookId) {
	        bookMasterMapper.deletebyId(bookId);
	    }
	    @Override
	    public void update(BookMasterModel model) {
	    	BookMaster bookMaster = new BookMaster();
	    	bookMaster.setBookId(model.getBookId());
	    	bookMaster.setBookTitle(model.getBookTitle());
	    	bookMaster.setAuthorName(model.getAuthorName());
	    	bookMaster.setPublisher(model.getPublisher());
	    	bookMaster.setPublicationDay(model.getPublicationDay());
	    	bookMaster.setInsertDay(new Date());
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
