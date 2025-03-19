package firstAssignment.builder;

public class Book {


    private int isbn;
    private int year;
    private String author;


    private Book(BookBuilder bookBuilder) {
        this.isbn = bookBuilder.isbn;
        this.year = bookBuilder.year;
        this.author = bookBuilder.author;
    }
    public int getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }


    public static  class BookBuilder{
        private int isbn;
        private int year;
        private String author;
        public BookBuilder() {
            this.isbn = isbn;
            this.year = year;
            this.author = author;
        }

        public  static BookBuilder builder(){
            return new BookBuilder();
        }

        public BookBuilder setIsbn(int isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Book build(){
            return new Book(this);
        }


    }

}
