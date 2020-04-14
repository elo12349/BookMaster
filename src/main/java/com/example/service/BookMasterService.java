package com.example.service;

import org.springframework.stereotype.Repository;
import com.example.Entity.BookMaster;
import com.example.model.BookMasterModel;

@Repository
public interface BookMasterService {
	int insert(BookMasterModel model);
	
	BookMaster findById(String bookId);

	void deletebyId(String bookId);
	
	void update(BookMasterModel model);

}

