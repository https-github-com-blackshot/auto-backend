package kz.blackshot.auto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.blackshot.auto.util.BaseAuditable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "users", schema = "auto_core_db")
public class Users extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, insertable = true)
    private int id;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "firstname")
    private String firstName;

    @Basic
    @Column(name = "lastname")
    private String lastName;

    @Basic
    @Column(name = "middlename")
    private String middleName;

    @Basic
    @Column(name = "birthdate")
    private Timestamp birthDate;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;


}
