package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "location")
@Table(name = "t_location")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
