package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data @NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`from`")
    private Integer from;
    @Column(name = "`to`")
    private Integer to;
    @Column(name = "dialog")
    private Integer dialog;
    @NotEmpty
    @Column(name = "message")
    private String message;
    @Column(name = "date")
    private Timestamp date;

    public Message(Integer from, Integer to, Integer dialog, @NotEmpty String message, Timestamp date) {
        this.from = from;
        this.to = to;
        this.dialog = dialog;
        this.message = message;

        this.date = date;
    }

    public String getDateString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return(simpleDateFormat.format(this.date)) ;
    }
}
