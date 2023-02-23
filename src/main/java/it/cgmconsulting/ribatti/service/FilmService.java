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
     * <p> EP.2 </p>
     *
     * @param filmId
     */
    public List<FilmStoreResponse> findFilmInStore(long filmId) {
        return filmRepository.findFilmInStore(filmId);
    }

    /**
     * <p> EP.3 </p>
     *
     * @param language
     * @return
     */
    public List<FilmResponse> findFilmsByLanguage(Long language) {
        return filmRepository.findFilmsByLanguage(language);
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

    /**
     * <p> EP.10 </p>
     *
     * @param actorId
     */
    public List<FilmResponse> findFilmsByActors(List<Long> actorId) {

        List<ActorFilmsResponse> actorsFilmsResponse = new ArrayList<>();

        // per ogni attore reperisco elenco di films in cui appare
        List<FilmResponse> films = new ArrayList<>();
        for (long a : actorId) {
            films = filmRepository.findFilmsByActors(a);
            // Ad ogni attore associo suo elenco di films e li colleziono
            actorsFilmsResponse.add(new ActorFilmsResponse(a, films));
        }

        if (actorsFilmsResponse.size() == 1)
            return films;

        Set<Long> ids = new HashSet<>();
        // Colleziono gli id dei film di un attore
        List<Long> filmsIdOfActors = actorsFilmsResponse.get(0).getFilmResponses().stream().map(f -> f.getFilmId()).collect(Collectors.toList());
        // ciclo gli elenchi di films di tutti gli attori e ne estraggo gli id dei film
        for (int i = 1; i < actorsFilmsResponse.size(); i++) {
            List<Long> filmsIdOfActorB = actorsFilmsResponse.get(i).getFilmResponses().stream().map(f -> f.getFilmId()).collect(Collectors.toList());
            // confronto e mantengo gli id dei films comuni
            for (Long n : filmsIdOfActors) {
                for (Long nb : filmsIdOfActorB) {
                    if (n == nb)
                        ids.add(n);
                }
            }
        }
        return filmRepository.findByIdList(ids.stream().toList());
    }
}