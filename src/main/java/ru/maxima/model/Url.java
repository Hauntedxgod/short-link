package ru.maxima.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "all_url")
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url" )
    @Size(min = 2 , max = 1000 , message = "Not found url")
    private String url;

    @Column(name = "shorts_url")
    private String shortsUrl;

    @Column(name = "click")
    private int clickUrl;
}
