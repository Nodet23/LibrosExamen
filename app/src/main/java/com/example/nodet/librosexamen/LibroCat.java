package com.example.nodet.librosexamen;

public class LibroCat {

    private String author;
    private String title;
    private String image;
    private String _id;

    public LibroCat(String author, String tittle, String image, String _id) {
        this.author = author;
        this.title = tittle;
        this.image = image;
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTittle() {
        return title;
    }

    public void setTittle(String tittle) {
        this.title = tittle;
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

    @Override
    public String toString() {
        return "LibroCat{" +
                "author='" + author + '\'' +
                ", tittle='" +  title + '\'' +
                ", image='" + image + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
