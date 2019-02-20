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
@Table(name = "roles", schema = "auto_core_db")
public class ServiceBookContent extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, insertable = true)
    private int id;

    @Basic
    @Column(name = "mechanic_user_id")
    private int mechanicUserId;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "duration")
    private int duration;

    @Basic
    @Column(name = "service_book_id")
    private int serviceBookId;

}
