package com.test.naren.base_app.service;

import com.test.naren.base_app.entity.Profile;
import com.test.naren.base_app.profilerepo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repo;

    public List<Profile> listAll() {
        return repo.findAll();
    }

    public void save(Profile profile) {
        repo.save(profile);
    }

    public Profile get(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}