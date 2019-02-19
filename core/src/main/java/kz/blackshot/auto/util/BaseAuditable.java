package kz.blackshot.auto.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public abstract class BaseAuditable {

    @JsonIgnore
    @CreatedBy
    @Column(name = "created_by")
    protected String createdBy;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_at")
    protected Timestamp createdAt;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "updated_by")
    protected String updatedBy;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "updated_at")
    protected Timestamp updatedAt;

    @JsonIgnore
    @Column(name = "state")
    protected int state;


}
