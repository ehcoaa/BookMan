package com.gzfs.service;

import com.gzfs.entity.Book;
import com.gzfs.entity.Borrow;

import java.util.List;

public interface BookService {
       public List<Book> findAll(int page);
       public int getPages();
       public int getBorrowPages(Integer readerid);
       public void addBorrow(Integer bookid,Integer readerid);
       public List<Borrow> findAllBorrowByReaderId(Integer id,Integer page);
       public List<Borrow> findAllBorrowByState(Integer state,Integer page);
       public int getBorrowPagesByState(Integer state);
       public void handleBorrow(Integer borrowId,Integer state,Integer adminId);

}
