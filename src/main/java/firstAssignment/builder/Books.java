package firstAssignment.builder;

public class Books {
    private int isbn;
    private int year;
    private String author;


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Books(int isbn, int year, String author) {
        this.isbn = isbn;
        this.year = year;
        this.author = author;
    }


}
