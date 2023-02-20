package it.cgmconsulting.ribatti.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long languageId;

    @Column(nullable = false, unique = true, length = 20)
    private String languageName;
}
