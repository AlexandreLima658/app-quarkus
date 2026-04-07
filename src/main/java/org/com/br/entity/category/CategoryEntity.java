package org.com.br.entity.category;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_categories")
public class CategoryEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID categoryId;

    public String name;
    public String description;
    public boolean isActive;
    public Instant createdAt;
    public Instant updatedAt;
    public Instant deletedAt;
}
