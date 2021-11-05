package by.epamtc.pashunArtyom.digitalLibrary.dao.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.LibDAO;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TXTLibDAO implements LibDAO {

    public final static String PATH_TO_LIBRARY = "./resources/library.txt";
    public final static String DELIMITER = "; ";

    @Override
    public void addBook(Book book) throws DAOException {
        try (FileWriter fileWriter = new FileWriter(PATH_TO_LIBRARY, true)) {
            fileWriter.append(book.getBookId() + DELIMITER + book.getBookTitle() + DELIMITER + book.getAuthorName() + DELIMITER);
        } catch (Exception e) {
            throw new DAOException("DAO ERROR: Library file is not found", e);
        }
    }

    @Override
    public void removeBook(int bookId) throws DAOException {

    }

    @Override
    public void editBook() throws DAOException {

    }

    @Override
    public ArrayList<Book> find(String bookTitle) throws DAOException {
        List<Book> library = null;
        try {
            library = bookBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Book> result = new ArrayList<Book>();
        for (Book book : library) {
            if (book.getBookTitle().equals(bookTitle))
                result.add(book);
        }
        return result;
    }

    public List<Book> bookBase() throws DAOException, IOException {

        List<Book> library = new ArrayList<>();
        String temp;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_LIBRARY));
            while ((temp = reader.readLine()) != null) {
                String[] array = temp.split(DELIMITER);
                Book book = new Book();
                book.setBookId(Integer.valueOf(array[0]));
                book.setBookTitle(array[1]);
                book.setAuthorName(array[2]);
                library.add(book);
            }
            reader.close();
        } catch (Exception e) {
            throw new DAOException("DAO ERROR: can not read library file");
        }
        return library;
    }
}
