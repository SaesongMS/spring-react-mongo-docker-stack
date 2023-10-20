package com.tnbm.restapi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tnbm.restapi.models.UserList;
import com.tnbm.restapi.payload.response.GenreResponse;
import com.tnbm.restapi.services.ListService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/list")
public class ListController {
    @Autowired
    private ListService listService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("add/planned")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> addPlanned(@RequestBody Map<String, Object> requestBody) {
        String userId = (String) requestBody.get("userId");
        GenreResponse genreResponse = objectMapper.convertValue(requestBody.get("subject"), GenreResponse.class);
        return ResponseEntity.ok().body(listService.addPlanned(userId, genreResponse));
    }

    @PostMapping("add/watched")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> addWatched(@RequestBody Map<String, Object> requestBody) {
        String userId = (String) requestBody.get("userId");
        GenreResponse genreResponse = objectMapper.convertValue(requestBody.get("subject"), GenreResponse.class);
        return ResponseEntity.ok().body(listService.addWatched(userId, genreResponse));
    }

    @DeleteMapping("delete/planned")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> deletePlanned(@RequestBody Map<String, String> requestBody) {
        String userId = (String) requestBody.get("userId");
        return ResponseEntity.ok().body(listService.deletePlanned(userId));
    }

    @DeleteMapping("delete/watched")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> deleteWatched(@RequestBody Map<String, String> requestBody) {
        String userId = (String) requestBody.get("userId");
        return ResponseEntity.ok().body(listService.deleteWatched(userId));
    }

    @PostMapping("get/planned")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> getPlanned(@RequestBody Map<String, String> requestBody) {
        String userId = (String) requestBody.get("userId");
        return ResponseEntity.ok().body(listService.getPlanned(userId));
    }

    @PostMapping("get/watched")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GenreResponse>> getWatched(@RequestBody Map<String, String> requestBody) {
        String userId = (String) requestBody.get("userId");
        return ResponseEntity.ok().body(listService.getWatched(userId));
    }

    @PostMapping("get/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<UserList> getAll(@RequestBody Map<String, String> requestBody) {
        String userId = (String) requestBody.get("userId");
        return ResponseEntity.ok().body(listService.getAll(userId));
    }

}
