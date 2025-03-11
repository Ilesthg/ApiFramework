package firstAssignment.builder;

import firstAssignment.builder.Books;
import firstAssignment.builder.UserBuilder;

import java.util.List;

public final class Users {


    private int id;
    private String name;
    private String title;
    private String views;
    private List<String> jobs;
    private Books books;


/*    public Users(int id, String name, String title, String views, List<String> jobs, Books books) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.views = views;
        this.jobs = jobs;
        this.books = books;
    }


// or

    public Users(int id, String name, String title, String views, List<String> jobs) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.views = views;
        this.jobs = jobs;
        this.books = new Books(18, 12547, "Perez");

    }*/
    private Users(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.title = builder.title;
        this.views = builder.views;
        this.jobs = builder.jobs;
        this.books = builder.book;
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public String getTitle() { return title; }
    public String getViews() { return views; }
    public List<String> getJobs() { return jobs; }
    public Books getBook() { return books; }



}
