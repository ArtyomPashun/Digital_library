package by.epamtc.pashunArtyom.digitalLibrary.dao.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.LibDAO;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TXTLibDAO implements LibDAO {

    public final static String PATH_TO_LIBRARY = "./resources/library.txt";
    public final static String DELIMITER = "/";

    @Override
    public void addBook(Book book) throws DAOException {
        List<Book> bookList;

        try {
            bookList = scanBooksFromFile();
            for (Book b : bookList) {
                if ((book.getAuthorName().equals(b.getAuthorName())) &&
                        (book.getBookTitle().equals(b.getBookTitle()))) {
                    throw new DAOException("This book is already exist in the Library");
                }
            }
            bookList.add(book);
            addBookInformationInFile(bookList);
        } catch (IOException e) {
            throw new DAOException("DAO ERROR: Library file is not found", e);
        }
    }

    @Override
    public void removeBook(int bookId) throws DAOException {
        List<Book> bookList;

        try {
            bookList = scanBooksFromFile();

            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getBookId() == bookId) {
                    bookList.remove(i);
                    break;
                }
            }
            addBookInformationInFile(bookList);
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            throw new DAOException("DAO ERROR: You could not delete this book", e);
        }
    }

    @Override
    public void editBook(int bookId, String newBookTitle, String newAuthorName) throws DAOException {
        List<Book> bookList;

        try {
            bookList = scanBooksFromFile();

            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getBookId() == bookId) {
                    Book book = bookList.get(i);
                    book.setBookTitle(newBookTitle);
                    book.setAuthorName(newAuthorName);
                    bookList.set(i, book);
                }
            }
            addBookInformationInFile(bookList);
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            throw new DAOException("DAO ERROR: You could not edit this book", e);
        }
    }

    @Override
    public Book findBook(String bookTitle) throws DAOException {
        List<Book> bookList;
        Book book = null;

        try {
            bookList = scanBooksFromFile();
            for (Book b : bookList) {
                if (bookTitle.equals(b.getBookTitle())) {
                    book = b;
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new DAOException("DAO ERROR: This book does not exist in library", e);
        }
        return book;
    }

    @Override
    public List<Book> findAllBooks() throws DAOException {
        List<Book> bookList;

        try {
            bookList = scanBooksFromFile();
        } catch (IOException | NumberFormatException e) {
            throw new DAOException("DAO ERROR: Receiving all books process error", e);
        }
        return bookList;
    }

    public List<Book> scanBooksFromFile() throws DAOException, IOException {
        List<Book> bookLibrary = new ArrayList<>();
        String temp;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_LIBRARY));
            while ((temp = reader.readLine()) != null) {
                String[] array = temp.split(DELIMITER);
                Book book = new Book();
                book.setBookId(Integer.parseInt(array[0]));
                book.setBookTitle(array[1]);
                book.setAuthorName(array[2]);
                bookLibrary.add(book);
            }
            reader.close();
        } catch (NumberFormatException | IOException e) {
            throw new DAOException("DAO ERROR: can not read library file", e);
        }
        return bookLibrary;
    }

    public void addBookInformationInFile(List<Book> bookList) throws DAOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_LIBRARY, false));
            for (Book b : bookList) {
                writer.append(String.valueOf(b.getBookId())).append(DELIMITER)
                        .append(b.getBookTitle()).append(DELIMITER)
                        .append(b.getAuthorName())
                        .append('\n');
            }
            writer.close();
        } catch (IOException e) {
            throw new DAOException("DAO ERROR:library.txt file could not be open", e);
        }
    }
}
