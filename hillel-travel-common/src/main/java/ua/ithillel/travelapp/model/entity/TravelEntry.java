package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity(name = "travelEntry")
@Table(name = "t_travel_entry")
@Data
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


}
