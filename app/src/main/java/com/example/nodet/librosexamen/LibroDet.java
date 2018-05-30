package com.example.nodet.librosexamen;

public class LibroDet {

    private String author;
    private String title;
    private String image;
    private String _id;
    private String description;
    private String publisher;
    private String date;
    private int rating;

    public LibroDet(String author, String title, String image, String _id, String description, String publisher, String date, int rating) {
        this.author = author;
        this.title = title;
        this.image = image;
        this._id = _id;
        this.description = description;
        this.publisher = publisher;
        this.date = date;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "----------LibroDet{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", _id='" + _id + '\'' +
                ", description='" + description + '\'' +
                ", publisher='" + publisher + '\'' +
                ", date='" + date + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}