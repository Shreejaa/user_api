package com.Training.User_Service.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    private String firstname;

    private String lastname;

    private String username;

    private String useremail;

    private String phoneno;

    private String password;

    private String role;

    public User() {
        this.role="USER";
    }


    public User(Long userid, String firstname, String lastname, String username, String useremail, String phoneno, String password) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.useremail = useremail;
        this.phoneno = phoneno;
        this.password = password;
        this.role="USER";
    }

}
