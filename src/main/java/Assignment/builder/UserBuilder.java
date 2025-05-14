package Assignment.builder;

import java.util.List;

public class UserBuilder {


    String id;
    String name;
    String title;
    int views;
    /*private*/ List<String> jobs;
    /*private*/     List<Book> books;

   /* public UserBuilder(int id) { // Mandatory field
        this.id = id;
    }*/
    public UserBuilder() {

    }
    public static UserBuilder builder() {
        return new UserBuilder();
    }
    public UserBuilder setId(String id) {
        this.id = id;
        return this;
    }


    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

     public UserBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public UserBuilder setViews(int views) {
        this.views = views;
        return this;
    }

    public UserBuilder setJobs(List<String> jobs) {
        this.jobs = jobs;
        return this;
    }

    public UserBuilder setBook(List<Book> bookList) {
        this.books = bookList;
        return this;
    }


    public User build() {
        return new User(this);
    }
}


