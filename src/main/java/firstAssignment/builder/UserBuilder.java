package firstAssignment.builder;

import java.util.List;

public class UserBuilder {
    private int id;
    private String name;
    private String title;
    private String views;
    private List<String> jobs;
    private Books book;

    public UserBuilder(int id) { // Mandatory field
        this.id = id;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public UserBuilder setViews(String views) {
        this.views = views;
        return this;
    }

    public UserBuilder setJobs(List<String> jobs) {
        this.jobs = jobs;
        return this;
    }

    public UserBuilder setBook(Books book) {
        this.book = book;
        return this;
    }

   /* public Users build() {
        return new Users(this);
    }*/
}


