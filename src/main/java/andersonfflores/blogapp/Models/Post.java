package andersonfflores.blogapp.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String body;
    private String imgUrl;
    @ManyToOne
    private User user_id;
    @OneToMany
    private List<Comment> comments;
    private LocalDateTime createdAt;

    public Post() {
    }

    public Post(UUID id, String title, String body, String imgUrl, User user_id, List<Comment> comments, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.imgUrl = imgUrl;
        this.user_id = user_id;
        this.comments = comments;
        this.createdAt = createdAt;
    }

    public Post(String title, String body, String imgUrl, User user_id, List<Comment> comments, LocalDateTime createdAt) {
        this.title = title;
        this.body = body;
        this.imgUrl = imgUrl;
        this.user_id = user_id;
        this.comments = comments;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
