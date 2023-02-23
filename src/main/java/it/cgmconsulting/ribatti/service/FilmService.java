package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.entity.Film;
import it.cgmconsulting.ribatti.payload.request.FilmRequest;
import it.cgmconsulting.ribatti.payload.response.ActorFilmsResponse;
import it.cgmconsulting.ribatti.payload.response.FilmMaxRentResponse;
import it.cgmconsulting.ribatti.payload.response.FilmResponse;
import it.cgmconsulting.ribatti.payload.response.FilmStoreResponse;
import it.cgmconsulting.ribatti.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;


    /**
     * usato da EP.1
     *
     * @param filmId
     * @param filmRequest
     */
    public void updateFilm(long filmId, FilmRequest filmRequest) {
        Optional<Film> film = filmRepository.findById(filmId);

        film.get().setTitle(filmRequest.getTitle());
        film.get().setDescription(filmRequest.getDescription());
        film.get().setReleaseYear(filmRequest.getReleaseYear());
    }

    /**
     * <p> Used by EP.4 </p>
     *
     * @param filmId
     * @return
     */
    public boolean existsById(long filmId) {
        return filmRepository.existsById(filmId);
    }

    public Optional<Film> findById(long filmId) {
        return filmRepository.findById(filmId);
    }

    /**
     * <p> EP.9 </p>
     */
    public List<FilmMaxRentResponse> findFilmMaxNrRentStream() {
        List<FilmMaxRentResponse> films = filmRepository.findFilmMaxNrRent();

        long noleggiMax = films.stream().max(
                Comparator.comparing(f -> f.getTotNoleggi())).get().getTotNoleggi();

        return films.stream().filter(f -> f.getTotNoleggi() == noleggiMax).collect(Collectors.toList());
    }

    /**
     * <p> EP.9 </p>
     */
    public List<FilmMaxRentResponse> findFilmMaxNrRent() {

        List<FilmMaxRentResponse> films = filmRepository.findFilmMaxNrRent();

        long noleggiMax = 0;
        List<FilmMaxRentResponse> filmTop = new ArrayList<>();

        for (FilmMaxRentResponse f : films) {
            if (noleggiMax < f.getTotNoleggi()) {
                filmTop.clear();
                noleggiMax = f.getTotNoleggi();
                filmTop.add(f);
                continue;
            }
            if (noleggiMax == f.getTotNoleggi()) {
                filmTop.add(f);
            }
        }
        return filmTop;
    }
}