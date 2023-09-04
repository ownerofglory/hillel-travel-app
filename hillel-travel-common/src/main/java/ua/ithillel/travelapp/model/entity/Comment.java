package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "comment")
@Table(name = "t_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"id"})
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
}
