package com.example.service;
import java.util.Optional;

import com.example.Entity.BookMaster;
import com.example.model.BookMasterModel;

public interface BookMasterService {
	int insert(BookMasterModel model);
	
	Optional<BookMaster> findById(String bookId);

	void deletebyId(String bookId);
	
	void update(BookMasterModel model);

}

