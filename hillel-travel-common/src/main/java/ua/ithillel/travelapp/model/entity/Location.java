package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "location")
@Table(name = "t_location")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "travelEntry")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double latitude;
    private Double longitude;
    @Column(name = "location_name")
    private String locationName;
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entry_id")
    private TravelEntry travelEntry;
}
