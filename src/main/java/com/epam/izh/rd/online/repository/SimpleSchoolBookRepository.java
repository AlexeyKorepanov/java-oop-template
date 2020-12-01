package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository <SchoolBook> {

    SchoolBook[] schoolBooks = new SchoolBook[]{};

    @Override
    public boolean save(SchoolBook book) {
        int saveCount = count() ;
        SchoolBook [] saveBook = new SchoolBook[saveCount + 1] ;
        saveBook[saveCount] = book ;
        System.arraycopy(schoolBooks, 0 ,saveBook, 0 ,saveCount);
        schoolBooks = saveBook ;

        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] books = new SchoolBook[]{};
        int bookNum = 0 ;
        for (SchoolBook book: schoolBooks ) {
            if(book.getName().equals(name)){
                books[bookNum] = book ;
                bookNum++ ;
                
            }
        }

        return books;
    }

    @Override
    public boolean removeByName(String name) {
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
