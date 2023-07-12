package com.camelstudio.myapp.service.extended;

import com.camelstudio.myapp.domain.Category;
import com.camelstudio.myapp.domain.Movie;
import com.camelstudio.myapp.domain.Staff;
import com.camelstudio.myapp.repository.extended.MovieRepositoryExtended;
import com.camelstudio.myapp.service.CategoryService;
import com.camelstudio.myapp.service.MovieService;
import com.camelstudio.myapp.service.StaffService;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieServiceExtended extends MovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceExtended.class);

    private final MovieRepositoryExtended movieRepositoryExtended;
    private final CategorieServiceExtended categorieServiceExtended;
    private final MovieService movieService;
    private final StaffServiceExtended staffServiceExtended;
    private final StaffService staffService;
    private final CategoryService categoryService;

    public MovieServiceExtended(
        MovieRepositoryExtended movieRepositoryExtended,
        CategorieServiceExtended categorieServiceExtended,
        MovieService movieService,
        StaffServiceExtended staffServiceExtended,
        StaffService staffService,
        CategoryService categoryService
    ) {
        super(movieRepositoryExtended);
        this.movieRepositoryExtended = movieRepositoryExtended;
        this.categorieServiceExtended = categorieServiceExtended;
        this.movieService = movieService;
        this.staffServiceExtended = staffServiceExtended;
        this.staffService = staffService;
        this.categoryService = categoryService;
    }

    public Movie addMovieWithStaffAndCategories(Movie movie) {
        Movie movie1 = new Movie();
        movie
            .getCategories()
            .forEach(category -> {
                if (!categorieServiceExtended.CategoryExist(category)) {
                    Category category1 = categoryService.save(category);
                    movie1.getCategories().add(category1);
                } else {
                    movie1.getCategories().add(category);
                }
            });
        movie
            .getMembreStaffs()
            .forEach(staff -> {
                if (!staffServiceExtended.StaffExist(staff)) {
                    Staff staff1 = staffService.save(staff);
                    movie1.getMembreStaffs().add(staff1);
                } else {
                    movie1.getMembreStaffs().add(staff);
                }
            });
        movie.setCategories(movie1.getCategories());
        movie.setMembreStaffs(movie1.getMembreStaffs());
        return movieService.save(movie);
    }
}
