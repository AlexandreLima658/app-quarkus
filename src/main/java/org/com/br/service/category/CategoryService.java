package org.com.br.service.category;

import jakarta.enterprise.context.ApplicationScoped;
import org.com.br.entity.category.CategoryEntity;
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
}
