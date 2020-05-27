package com.leadconsult.palindromes.model;

import javax.persistence.*;


@Entity
@Table
public class Palindrome {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String value;

    public Palindrome() {
    }

    public Palindrome(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Palindrome [id=%s, value=%s]", id, value);
    }
}
