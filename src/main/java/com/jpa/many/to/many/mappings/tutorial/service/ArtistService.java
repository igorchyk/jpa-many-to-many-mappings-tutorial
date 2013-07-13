package com.jpa.many.to.many.mappings.tutorial.service;

import com.jpa.many.to.many.mappings.tutorial.domain.Artist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistService {

    private EntityManager em;

    public ArtistService(EntityManager em) {
        this.em = em;
    }

    public Artist createArtist(int id, String name) {
        Artist artist = new Artist(id, name);
        em.persist(artist);

        return artist;
    }

    public void removeArtist(int id) {
        Artist artist = em.find(Artist.class, id);

        if (artist != null) {
            em.remove(artist);
        }
    }

    public Artist changeArtistName(int id, String name) {
        Artist artist = em.find(Artist.class, id);

        if (artist != null) {
            artist.setName(name);
        }

        return artist;
    }

    public Artist findArtist(int id) {
        return em.find(Artist.class, id);
    }

    public List<Artist> findAllArtists() {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a", Artist.class);
        return query.getResultList();
    }
}
