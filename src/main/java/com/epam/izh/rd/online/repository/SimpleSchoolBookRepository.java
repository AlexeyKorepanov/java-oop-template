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
                SchoolBook[]tempBook = new SchoolBook[bookNum +1] ;
                tempBook[bookNum] = book ;
                bookNum++ ;
                books = tempBook ;
                System.arraycopy(tempBook, 0, books, 0 ,bookNum);
            }
        }
        return books;
    }

    @Override
    public boolean removeByName(String name) {
        int removeCount = count() ;
        SchoolBook[] removeBook = new SchoolBook[removeCount] ;
        for (SchoolBook book: schoolBooks) {
            if( book.getName().equals(name)){
                removeBook[removeCount] = book ;
                removeCount-- ;
                schoolBooks = removeBook ;
                System.arraycopy(removeBook,0,schoolBooks,0,removeCount);
                return true ;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
