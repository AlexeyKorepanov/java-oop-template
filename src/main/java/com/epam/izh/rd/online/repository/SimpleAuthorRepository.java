package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository {

    private  Author[] authors = new Author[]{} ;

    @Override
    public boolean save(Author author) {
        int saveCount = count() ;
        if (findByFullName(author.getName(), author.getLastName()) == null){

            saveCount++ ;
            Author[] saveAuthor = new Author[saveCount] ;
            System.arraycopy(authors, 0 ,saveAuthor ,0, saveCount);
            authors = saveAuthor ;
            return true ;
        }
        return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {

        for (Author author : authors) {
            if (author.getName().equals(name) && author.getLastName().equals(lastname)){
                return author ;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {

        return false;
    }

    @Override
    public int count() {

        return authors.length ;
    }
}
