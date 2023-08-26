package ua.ithillel.travelapp.model.dto;

public class CommentDTO {
    private Long id;
    private String commentText;
    private UserDTO user;
    private TravelEntryDTO travelEntry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public TravelEntryDTO getTravelEntry() {
        return travelEntry;
    }

    public void setTravelEntry(TravelEntryDTO travelEntry) {
        this.travelEntry = travelEntry;
    }
}
