package firstAssignment.builder;

import java.util.List;

public final class User {


    private  String id;
    private  String name;
    private  String title;
    private   int views;
    private   List<String> jobs;
    private List<Book> books;


/*    public User(int id, String name, String title, String views, List<String> jobs, Book books) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.views = views;
        this.jobs = jobs;
        this.books = books;
    }


// or

    public User(int id, String name, String title, String views, List<String> jobs) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.views = views;
        this.jobs = jobs;
        this.books = new Book(18, 12547, "Perez");

    }*/
     User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.title = builder.title;
        this.views = builder.views;
        this.jobs = builder.jobs;
        this.books = builder.books;
    }


    public String getId() { return id; }
    public String getName() { return name; }
    public String getTitle() { return title; }
    public int getViews() { return views; }
    public List<String> getJobs() { return jobs; }
    public List<Book> getBooks() { return books; }


}
