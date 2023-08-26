package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "travelEntry")
@Table(name = "t_travel_entry")
public class TravelEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "entry_date")
    private Date entryDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "travelEntry", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Location> locations;

    @OneToMany(mappedBy = "travelEntry", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "travelEntry", fetch = FetchType.LAZY)
    private List<Like> likes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "TravelEntry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", entryDate=" + entryDate +
                ", locations=" + locations +
                '}';
    }
}
