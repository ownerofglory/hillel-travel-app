package ua.ithillel.travelapp.model.entity;

import jakarta.persistence.*;

@Entity(name = "location")
@Table(name = "t_location")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public TravelEntry getTravelEntry() {
        return travelEntry;
    }

    public void setTravelEntry(TravelEntry travelEntry) {
        this.travelEntry = travelEntry;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", locationName='" + locationName + '\'' +
                '}';
    }
}
