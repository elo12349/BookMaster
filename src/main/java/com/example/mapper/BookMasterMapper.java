package com.example.mapper;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.Entity.BookMaster;
import com.example.model.BookMasterModel;

@Mapper
public interface BookMasterMapper{

	@Insert("insert into public.\"BookMaster\" (book_id, book_title, author_name, publisher, publication_day, insert_day, update_day) values (#{bookId}, #{bookTitle}, #{authorName}, #{publisher}, #{publicationDay}, #{insertDay}, #{updateDay})")
     int insert(BookMaster bookMaster);
	
	@Select("select * from public.\"BookMaster\" where book_id = #{bookId}")
	Optional<BookMaster> findById(String bookId);
	
	@Delete("DELETE FROM public.\"BookMaster\" WHERE book_id = #{bookId}\"")
	 void deletebyId(String bookId);
	
	@Update("UPDATE public.\"BookMaster\" SET book_title = #{bookTitle}, author_name = #{authorName}, publisher = #{publisher}, publication_day =#{publicationDay} insert_day =#{insertDay} update_day =#{updateDay} WHERE book_id = #{bookId}")
    void update(BookMaster bookMaster);	
}