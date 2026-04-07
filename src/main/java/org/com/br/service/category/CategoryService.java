package org.com.br.service.category;

import jakarta.enterprise.context.ApplicationScoped;
import org.com.br.entity.category.CategoryEntity;

import java.util.List;

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
}
