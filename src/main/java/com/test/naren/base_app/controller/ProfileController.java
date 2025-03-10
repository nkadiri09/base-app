package com.test.naren.base_app.controller;

import com.test.naren.base_app.entity.Profile;
import com.test.naren.base_app.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profiles")
    public List<Profile> getProfiles() {
        return profileService.listAll();
    }
}
