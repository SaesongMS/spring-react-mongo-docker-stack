package com.tnbm.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnbm.restapi.models.UserList;
import com.tnbm.restapi.payload.request.ListIdRequest;
import com.tnbm.restapi.payload.request.ListRequest;
import com.tnbm.restapi.payload.response.GenreResponse;
import com.tnbm.restapi.services.ListService;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/list")
public class ListController {
    @Autowired
    private ListService listService;

    @PostMapping("add/planned")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> addPlanned(@RequestBody ListRequest requestBody) {
        String id = requestBody.getId();
        GenreResponse genreResponse = requestBody.getSubject();
        return ResponseEntity.ok().body(listService.addPlanned(id, genreResponse));
    }

    @PostMapping("add/watched")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> addWatched(@RequestBody ListRequest requestBody) {
        String id = requestBody.getId();
        GenreResponse genreResponse = requestBody.getSubject();
        return ResponseEntity.ok().body(listService.addWatched(id, genreResponse));
    }

    @DeleteMapping("delete/planned")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> deletePlanned(@RequestBody ListRequest requestBody) {
        String id = requestBody.getId();
        GenreResponse genreResponse = requestBody.getSubject();
        return ResponseEntity.ok().body(listService.deletePlanned(id, genreResponse));
    }

    @DeleteMapping("delete/watched")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> deleteWatched(@RequestBody ListRequest requestBody) {
        String id = requestBody.getId();
        GenreResponse genreResponse = requestBody.getSubject();
        return ResponseEntity.ok().body(listService.deleteWatched(id, genreResponse));
    }

    @PostMapping("get/planned")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> getPlanned(@RequestBody ListIdRequest requestBody) {
        String id = (String) requestBody.getId();
        return ResponseEntity.ok().body(listService.getPlanned(id));
    }

    @PostMapping("get/watched")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> getWatched(@RequestBody ListIdRequest requestBody) {
        String id = (String) requestBody.getId();
        return ResponseEntity.ok().body(listService.getWatched(id));
    }

    @PostMapping("get/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<UserList> getAll(@RequestBody ListIdRequest requestBody) {
        String id = (String) requestBody.getId();
        return ResponseEntity.ok().body(listService.getAll(id));
    }

}
