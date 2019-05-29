package com.example.dao;

import com.example.model.Film;

import java.util.List;

public interface FilmDao {

    Integer save(Film film);
    Film get(Integer id);
    void update(Integer id, Film film);
    void delete(Integer id);
    List<Film> list();
}
