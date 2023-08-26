package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;

@Entity(name = "like")
@Table(name = "t_like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private TravelEntry travelEntry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TravelEntry getTravelEntry() {
        return travelEntry;
    }

    public void setTravelEntry(TravelEntry travelEntry) {
        this.travelEntry = travelEntry;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", travelEntry=" + travelEntry +
                '}';
    }
}
