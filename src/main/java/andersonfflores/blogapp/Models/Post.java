package andersonfflores.blogapp.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @Column(name = "imgurl")
    private String imgUrl;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Comment> comments;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Post() {
    }

    public Post(UUID id, String title, String body, String imgUrl, User user_id, List<Comment> comments, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.imgUrl = imgUrl;
        this.user = user_id;
        this.comments = comments;
        this.createdAt = createdAt;
    }

    public Post(String title, String body, String imgUrl, User user_id, List<Comment> comments, LocalDateTime createdAt) {
        this.title = title;
        this.body = body;
        this.imgUrl = imgUrl;
        this.user = user_id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
