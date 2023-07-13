package com.camelstudio.myapp.web.rest.extended;

import com.camelstudio.myapp.domain.Movie;
import com.camelstudio.myapp.service.extended.MovieServiceExtended;
import com.camelstudio.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;

/**
 * REST controller for managing {@link com.camelstudio.myapp.domain.Movie}.
 */
@RestController
@RequestMapping("/api")
public class MovieResourceExtended {

    private final Logger log = LoggerFactory.getLogger(com.camelstudio.myapp.web.rest.MovieResource.class);

    private static final String ENTITY_NAME = "movie";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MovieServiceExtended movieServiceExtended;

    public MovieResourceExtended(MovieServiceExtended movieServiceExtended) {
        this.movieServiceExtended = movieServiceExtended;
    }

    @GetMapping("/movie-extended")
    public List<Movie> getAllMoviesOrGetMoviesBySearch(@RequestParam(required = false, name = "search") String search) {
        log.debug("REST request to get all Movies");
        return movieServiceExtended.getAllMoviesOrGetMoviesBySearch(search);
    }

    /**
     * {@code POST  /movie-extended} : Create a new movie.
     *
     * @param movie the movie to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new movie, or with status {@code 400 (Bad Request)} if the movie has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/movie-extended")
    public ResponseEntity<Movie> createMovieWithStaffAndCategories(@RequestBody Movie movie) throws URISyntaxException {
        log.debug("REST request to save Movie azizTest : {}", movie);
        log.debug("\n azizeesdghjgbjkdxfvnkjwkjxvn;xwvn:kdx;n \n");

        if (movie.getId() != null) {
            throw new BadRequestAlertException("A new movie cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Movie result = movieServiceExtended.addMovieWithStaffAndCategories(movie);
        return ResponseEntity
            .created(new URI("/api/movie-extended/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
}
