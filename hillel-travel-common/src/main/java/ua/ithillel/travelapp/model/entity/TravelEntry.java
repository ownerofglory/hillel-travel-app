package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity(name = "travelEntry")
@Table(name = "t_travel_entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "user", "comments", "likes"})
public class TravelEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "entry_date")
    private Date entryDate;
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "travelEntry", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Location> locations;

    @OneToMany(mappedBy = "travelEntry", fetch = FetchType.EAGER)
    private List<Comment> comments;

    @OneToMany(mappedBy = "travelEntry", fetch = FetchType.EAGER)
    private List<Like> likes;


}
