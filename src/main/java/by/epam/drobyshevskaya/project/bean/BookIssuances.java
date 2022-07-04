package by.epam.drobyshevskaya.project.bean;

import java.sql.Date;

public class BookIssuances {
    private int id_issuance;
    private int id_card;
    private int id_book;
    private Date dateOfIssue;
    private Date returnDate;

    public int getId_issuance() {
        return id_issuance;
    }

    public void setId_issuance(int id_issuance) {
        this.id_issuance = id_issuance;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
