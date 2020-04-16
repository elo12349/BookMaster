package com.example.service;

import java.util.Date;

import com.example.base.BookSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public BookMaster findById(String bookId) {
    	try {
        return bookMasterMapper.findById(bookId);
    	}catch(Exception e) {
    		throw new BookSystemException("search.error");
    	}
    }


    @Transactional
    @Override
    public void deletebyId(String bookId) {
    	try {
    		 bookMasterMapper.deletebyId(bookId);
    	}catch(Exception e) {
    		throw new BookSystemException("delete.error");
    	}
       
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
        try {
            bookMasterMapper.update(bookMaster);
        } catch (Exception e) {
            throw new BookSystemException("update.error");
        }
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
        try {
            return bookMasterMapper.insert(bookMaster);
        } catch (Exception e) {  
            throw new BookSystemException("insert.error");
        }
    }
}