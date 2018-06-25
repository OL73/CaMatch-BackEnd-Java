package com.dvlk.p10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvlk.p10.bean.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
