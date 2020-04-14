package com.example.mapper;

import com.example.Entity.BookMaster;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BookMasterMapper {

    @Insert("insert into public.\"BookMaster\" (book_id, book_title, author_name, publisher, publication_day, insert_day, update_day) values (#{bookId}, #{bookTitle}, #{authorName}, #{publisher}, #{publicationDay}, #{insertDay}, #{updateDay})")
    int insert(BookMaster bookMaster);

    @Select("select * from public.\"BookMaster\" where book_id = #{bookId}")

    @Results(value = {
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "bookTitle", column = "book_title"),
            @Result(property = "authorName", column = "author_name"),
            @Result(property = "publisher", column = "publisher"),
            @Result(property = "publicationDay", column = "publication_day"),
    })
    BookMaster findById(String bookId);

    @Delete("DELETE FROM public.\"BookMaster\" WHERE book_id = #{bookId}")
    void deletebyId(String bookId);

    @Update("UPDATE public.\"BookMaster\" SET book_title = #{bookTitle}, author_name = #{authorName}, publisher = #{publisher}, publication_day =#{publicationDay}, update_day =#{updateDay} WHERE book_id = #{bookId}")
    void update(BookMaster bookMaster);
}