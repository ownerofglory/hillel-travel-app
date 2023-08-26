package ua.ithillel.travelapp.model.dto;

public class LikeDTO {
    private Long id;
    private TravelEntryDTO travelEntry;
    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TravelEntryDTO getTravelEntry() {
        return travelEntry;
    }

    public void setTravelEntry(TravelEntryDTO travelEntry) {
        this.travelEntry = travelEntry;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
