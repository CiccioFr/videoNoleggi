package it.cgmconsulting.ribatti.service;

import it.cgmconsulting.ribatti.entity.Film;
import it.cgmconsulting.ribatti.payload.request.FilmRequest;
import it.cgmconsulting.ribatti.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public boolean existsById(long filmId) {
        return filmRepository.existsById(filmId);
    }

    public Optional<Film> findById(long filmId) {
        return filmRepository.findById(filmId);
    }

    public void updateFilm(long filmId, FilmRequest filmRequest) {

        Optional<Film> film = filmRepository.findById(filmId);

        film.get().setTitle(filmRequest.getTitle());
        film.get().setDescription(filmRequest.getDescription());
        film.get().setReleaseYear(filmRequest.getReleaseYear());
    }
}