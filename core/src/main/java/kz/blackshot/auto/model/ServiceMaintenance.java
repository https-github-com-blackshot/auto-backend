package kz.blackshot.auto.model;


import kz.blackshot.auto.util.BaseAuditable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table (name = "service_maintenance", schema = "auto_core_db")
public class ServiceMaintenance extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false, updatable = false, insertable = true)
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String decription;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;

    @Basic
    @Column(name = "rating_id")
    private int ratingId;



}
