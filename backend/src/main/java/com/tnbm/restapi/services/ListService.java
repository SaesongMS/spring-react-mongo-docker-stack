package com.tnbm.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.tnbm.restapi.models.User;
import com.tnbm.restapi.models.UserList;
import com.tnbm.restapi.payload.response.GenreResponse;
import com.tnbm.restapi.repository.ListRepository;
import com.tnbm.restapi.repository.UserRepository;

@Service
public class ListService {
    @Autowired
    private ListRepository listRepository;

    @Autowired
    private UserRepository userRepository;

    public List<GenreResponse> addPlanned(String userId, GenreResponse subject) {
        Optional<UserList> ul = listRepository.findById(userId);
        if (ul.isPresent()) {
            UserList list = ul.get();
            if (list.getPlanned() != null && list.getPlanned().contains(subject)) {
                return list.getPlanned();
            } else {
                List<GenreResponse> temp = list.getPlanned();
                temp.add(subject);
                list.setPlanned(temp);
                listRepository.save(list);
                return list.getPlanned();
            }
        } else {
            if (userRepository.findById(userId).isPresent()) {
                UserList list = new UserList();
                list.setId(userId);
                list.setPlanned(Arrays.asList(subject));
                listRepository.insert(list);
                return Arrays.asList(subject);
            }
            return Arrays.asList();
        }
    }

    public List<GenreResponse> addWatched(String userId, GenreResponse subject) {
        Optional<UserList> ul = listRepository.findById(userId);
        if (ul.isPresent()) {
            UserList list = ul.get();
            if (list.getWatched() != null && list.getWatched().contains(subject)) {
                return list.getWatched();
            } else {
                List<GenreResponse> temp = list.getWatched();
                temp.add(subject);
                list.setWatched(temp);
                listRepository.save(list);
                return list.getWatched();
            }
        } else {
            if (userRepository.findById(userId).isPresent()) {
                UserList list = new UserList();
                list.setId(userId);
                list.setWatched(Arrays.asList(subject));
                listRepository.insert(list);
                return Arrays.asList(subject);
            }
            return Arrays.asList();
        }
    }

    public List<GenreResponse> deletePlanned(String userId, GenreResponse subject) {
        Optional<UserList> ul = listRepository.findById(userId);
        if (ul.isPresent()) {
            UserList list = ul.get();
            if (list.getPlanned() != null) {
                list.getPlanned().remove(subject);
                listRepository.save(list);
                return list.getPlanned();
            }
        }
        return new ArrayList<>();
    }

    public List<GenreResponse> deleteWatched(String userId, GenreResponse subject) {
        Optional<UserList> ul = listRepository.findById(userId);
        if (ul.isPresent()) {
            UserList list = ul.get();
            if (list.getWatched() != null) {
                list.getWatched().remove(subject);
                listRepository.save(list);
                return list.getWatched();
            }
        }
        return new ArrayList<>();
    }

    public List<GenreResponse> getPlanned(String userId) {
        Optional<UserList> ul = listRepository.findById(userId);
        if (ul.isPresent()) {
            UserList list = ul.get();
            List<GenreResponse> res = list.getPlanned() != null ? list.getPlanned() : Arrays.asList();
            return res;
        } else {
            Optional<User> u = userRepository.findById(userId);
            if (u.isPresent()) {
                UserList list = new UserList();
                list.setId(userId);
                listRepository.insert(list);
            }
            return Arrays.asList();
        }
    }

    public List<GenreResponse> getWatched(String userId) {
        Optional<UserList> ul = listRepository.findById(userId);
        if (ul.isPresent()) {
            UserList list = ul.get();
            List<GenreResponse> res = list.getWatched() != null ? list.getWatched() : Arrays.asList();
            return res;
        } else {
            Optional<User> u = userRepository.findById(userId);
            if (u.isPresent()) {
                UserList list = new UserList();
                list.setId(userId);
                listRepository.insert(list);
            }
            return Arrays.asList();
        }
    }

    public UserList getAll(String userId) {
        Optional<UserList> ul = listRepository.findById(userId);
        if (ul.isPresent()) {
            UserList list = ul.get();
            return list;
        } else {
            Optional<User> u = userRepository.findById(userId);
            if (u.isPresent()) {
                UserList list = new UserList();
                list.setId(userId);
                listRepository.insert(list);
                return list;
            }
            return new UserList();
        }
    }
}
