package by.epam.drobyshevskaya.project.bean;

public class Author {
    private int id_author;
    private String name;
    private String middleName;
    private String surname;
    private int booksNumber;

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public void setBooksNumber(int booksNumber) {
        this.booksNumber = booksNumber;
    }

    @Override
    public String toString() {
        return "Author: " + "id_author= " + id_author + ", name= " + name + ", middleName= " + middleName + ", surname= " + surname +
                ", booksNumber=" + booksNumber;
    }
}
