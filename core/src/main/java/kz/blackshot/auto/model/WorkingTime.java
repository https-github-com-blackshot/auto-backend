package kz.blackshot.auto.model;


import kz.blackshot.auto.util.BaseAuditable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "working_time", schema = "auto_core_db")
public class WorkingTime extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, insertable = true)
    private int id;

    @Basic
    @Column(name = "is_weekend")
    private boolean isWeekend;

    @Basic
    @Column(name = "star_time")
    private Timestamp starTime;

    @Basic
    @Column(name = "end_time")
    private Timestamp endTime;

    @Basic
    @Column(name = "service_maintenance_id")
    private int serviceMaintenanceId;





}
