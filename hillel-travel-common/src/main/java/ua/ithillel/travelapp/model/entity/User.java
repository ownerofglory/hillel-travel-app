package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "user")
@Table(name = "t_user")
@Data
@ToString(exclude = {"id", "password", "travelEntries"})
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TravelEntry> travelEntries;
}
