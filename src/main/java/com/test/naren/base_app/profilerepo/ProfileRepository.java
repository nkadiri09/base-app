package com.test.naren.base_app.profilerepo;

import com.test.naren.base_app.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}