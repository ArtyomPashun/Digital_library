package by.epamtc.pashunArtyom.digitalLibrary.entity;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1749178591651905812L;
    private int bookId;
    private String bookTitle;
    private String authorName;

    public Book(int bookId, String bookTitle, String authorName) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAllBookInformation() {
        return getBookId() + " " + getBookTitle() + " " + getAuthorName();
    }

    @Override
    public int hashCode() {
        final int prime = 22;
        return prime * bookId + ((bookTitle == null) ? 0 : bookTitle.hashCode()) + ((authorName == null) ? 0 : authorName.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return bookId == book.bookId
                && ((bookTitle == book.bookTitle) || (bookTitle != null && bookTitle.equals(book.getBookTitle())))
                && ((authorName == book.authorName) || (authorName != null && authorName.equals(book.getAuthorName())));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@"
                + "bookId: " + bookId
                + "bookTitle:  " + bookTitle
                + "authorName: " + authorName;
    }
}
