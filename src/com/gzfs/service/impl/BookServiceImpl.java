package com.gzfs.service.impl;

import com.gzfs.entity.Book;
import com.gzfs.entity.Borrow;
import com.gzfs.repository.BookRepository;
import com.gzfs.repository.BorrowRepository;
import com.gzfs.repository.impl.BookRepositoryImpl;
import com.gzfs.repository.impl.BorrowRepositoryImpl;
import com.gzfs.service.BookService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();
    BorrowRepository borrowRepository  = new BorrowRepositoryImpl();
    private  final  int LIMIT = 8;
    @Override
    public List<Book> findAll(int page) {
        int index = (page-1)*page;
        return bookRepository.findAll(index,LIMIT);
    }

    @Override
    public int getPages() {
        int count = bookRepository.count();
        return   (count+LIMIT-1)/LIMIT;
    }

    @Override
    public int getBorrowPages(Integer readerid) {
        int count = borrowRepository.count(readerid);
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT+1;
        }
        return page;
    }

    @Override
    public void addBorrow(Integer bookid, Integer readerid) {
        //借书时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = simpleDateFormat.format(date);
        //还书时间，借书时间+14天
        Calendar calendar = Calendar.getInstance();
        int dates = calendar.get(Calendar.DAY_OF_YEAR) + 14;
        calendar.set(Calendar.DAY_OF_YEAR, dates);
        Date date2 = calendar.getTime();
        String returnTime = simpleDateFormat.format(date2);

        //把这条借书记录插入到数据库当中
        borrowRepository.insert(bookid,readerid,borrowTime,returnTime,null,0);

    }

    @Override
    public List<Borrow> findAllBorrowByReaderId(Integer id, Integer page) {
        //业务：将 page 换算成 index,limit
        int index = (page-1)*LIMIT;
        return borrowRepository.findAllByReaderId(id,index,LIMIT);
    }

    @Override
    public List<Borrow> findAllBorrowByState(Integer state, Integer page) {
        int index = (page-1)*LIMIT;
        return borrowRepository.findAllByState(state,index,LIMIT);
    }

    @Override
    public int getBorrowPagesByState(Integer state) {
        int count = borrowRepository.countByState(state);
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT+1;
        }
        return page;
    }

    @Override
    public void handleBorrow(Integer borrowId, Integer state, Integer adminId) {
        borrowRepository.handle(borrowId,state,adminId);
    }


}
