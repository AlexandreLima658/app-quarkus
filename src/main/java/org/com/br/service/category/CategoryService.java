package org.com.br.service.category;

import jakarta.enterprise.context.ApplicationScoped;
import org.com.br.entity.category.CategoryEntity;
import org.com.br.entity.user.UserEntity;
import org.com.br.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CategoryService {

    public CategoryEntity create(final CategoryEntity category){
        CategoryEntity.persist(category);
        return category;
    }

    public List<CategoryEntity> findAll(final Integer page, final Integer pageSize) {
        return CategoryEntity.findAll()
                .page(page, pageSize)
                .list();
    }

    public CategoryEntity findById(final UUID categoryId) {
        return (CategoryEntity) CategoryEntity.findByIdOptional(categoryId)
                .orElseThrow(() -> NotFoundException.with(CategoryEntity.class, categoryId));
    }

    public CategoryEntity update(final UUID userId, final CategoryEntity categoryEntity){
        final var category = findById(userId);

        category.name = categoryEntity.name;
        category.description = categoryEntity.description;
        CategoryEntity.persist(category);

        return category;

    }
}
