package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "location")
@Table(name = "t_location")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double latitude;
    private Double longitude;
    @Column(name = "location_name")
    private String locationName;

    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private TravelEntry travelEntry;
}
