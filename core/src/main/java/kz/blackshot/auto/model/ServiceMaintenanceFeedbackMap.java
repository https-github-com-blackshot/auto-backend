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
@Table(name = "service_maintenance_feedback_map", schema = "auto_core_db")
public class ServiceMaintenanceFeedbackMap extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, insertable = true)
    private int id;

    @Basic
    @Column(name = "service_maintenance_id")
    private int serviceMaintenanceId;

    @Basic
    @Column(name = "feedback_id")
    private int feedbackId;
}
