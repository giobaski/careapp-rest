package com.example.KnCare.model.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class ModelBase<T> implements Searchable<T>{

    @Transient
    private Integer limit;
    @Transient
    private Integer page;
    @Transient
    private String sort;
    @Transient
    private Sort.Direction dir;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    @ColumnDefault("now()")
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    @ColumnDefault("now()")
    private LocalDateTime updatedAt;

//    @PrePersist
//    protected void onCreate() {
//        createdAt = LocalDateTime.now();
//        updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = LocalDateTime.now();
//    }

    @Override
    @JsonIgnore
    public Specification<T> getSpecification() {
        Specification<T> spec = Specification.where(null);
        // TODO: 26/07/2021 add search by date
        return spec;
    }

    @Override
    @JsonIgnore
    public Pageable getPageable() {
        return PageRequest.of(
                (page != null) ? page: 0,
                (limit != null && limit >= 0) ? limit: 10,
                getSortSpec()
        );
    }

    @Override
    @JsonIgnore
    public Sort getSortSpec() {
        if (sort == null) return Sort.unsorted();
        return (dir != null && dir == Sort.Direction.DESC) ?
                Sort.by(sort).descending(): Sort.by(sort).ascending();
    }
}
