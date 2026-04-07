package org.com.br.service.category;

import jakarta.enterprise.context.ApplicationScoped;
import org.com.br.entity.category.CategoryEntity;

@ApplicationScoped
public class CategoryService {

    public CategoryEntity create(final CategoryEntity category){
        CategoryEntity.persist(category);
        return category;
    }
}
