package model;
import jakarta.persistence.*;
import java.util.Date;


@Entity
public class DailyEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double correctionValue; // Valeur de correction (en degré)

    @Temporal(TemporalType.DATE)
    private Date entryDate; // Date de la saisie journalière

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // L'utilisateur associé à cette saisie

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCorrectionValue() {
        return correctionValue;
    }

    public void setCorrectionValue(Double correctionValue) {
        this.correctionValue = correctionValue;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
