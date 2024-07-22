package andersonfflores.blogapp.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String body;

    @Column(name = "imgurl")
    private String imgUrl;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post_id;

    public Comment() {
    }

    public Comment(UUID id, String body, String imgUrl, User user_id, Post post_id) {
        this.id = id;
        this.body = body;
        this.imgUrl = imgUrl;
        this.user = user_id;
        this.post_id = post_id;
    }

    public Comment(String body, String imgUrl, User user_id, Post post_id) {
        this.body = body;
        this.imgUrl = imgUrl;
        this.user = user_id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost_id() {
        return post_id;
    }

    public void setPost_id(Post post_id) {
        this.post_id = post_id;
    }
}
