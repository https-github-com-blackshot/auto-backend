package kz.blackshot.auto.model;

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
@Table(name = "rating", schema = "auto_core_db")
public class Rating extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, insertable = true)
    private int id;

    @Basic
    @Column(name = "very_low")
    private int veryLow;

    @Basic
    @Column(name = "low")
    private int low;

    @Basic
    @Column(name = "medium")
    private int medium;

    @Basic
    @Column(name = "high")
    private int high;

    @Basic
    @Column(name = "very_high")
    private int veryHigh;

}
