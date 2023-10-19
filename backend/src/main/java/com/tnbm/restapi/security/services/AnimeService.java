package com.tnbm.restapi.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnbm.restapi.repository.AnimeRepository;

@Service
public class AnimeService {
    @Autowired
    private AnimeRepository animeRepository;

}
