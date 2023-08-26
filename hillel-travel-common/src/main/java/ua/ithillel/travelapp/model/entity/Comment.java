package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;

@Entity(name = "comment")
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "comment_text")
    private String commentText;

    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private TravelEntry travelEntry;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public TravelEntry getTravelEntry() {
        return travelEntry;
    }

    public void setTravelEntry(TravelEntry travelEntry) {
        this.travelEntry = travelEntry;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentText='" + commentText + '\'' +
                ", user=" + user.getName() +
                '}';
    }
}
