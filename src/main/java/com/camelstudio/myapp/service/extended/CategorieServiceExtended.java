package com.camelstudio.myapp.service.extended;

import com.camelstudio.myapp.domain.Category;
import com.camelstudio.myapp.repository.extended.CategoryRepositoryExtended;
import com.camelstudio.myapp.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategorieServiceExtended extends CategoryService {

    CategoryRepositoryExtended categoryRepositoryExtended;
    CategoryService categoryService;

    public CategorieServiceExtended(CategoryRepositoryExtended categoryRepositoryExtended, CategoryService categoryService) {
        super(categoryRepositoryExtended);
        this.categoryRepositoryExtended = categoryRepositoryExtended;
        this.categoryService = categoryService;
    }

    public Boolean CategoryExist(Category category) {
        if (category.getId() != null) {
            return true;
        } else return false;
    }
}
