package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
public class Dialog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user1")
    private Integer user1;
    @Column(name = "user2")
    private Integer user2;

    public Dialog(Integer user1_id, Integer user2_id) {
        this.user1 = user1_id;
        this.user2 = user2_id;
    }
}
