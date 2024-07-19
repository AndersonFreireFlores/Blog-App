package andersonfflores.blogapp.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String body;
    private String imgUrl;

    @ManyToOne
    private User user_id;

    @ManyToOne
    private Post post_id;

    public Comment() {
    }

    public Comment(UUID id, String body, String imgUrl, User user_id, Post post_id) {
        this.id = id;
        this.body = body;
        this.imgUrl = imgUrl;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Post getPost_id() {
        return post_id;
    }

    public void setPost_id(Post post_id) {
        this.post_id = post_id;
    }
}
