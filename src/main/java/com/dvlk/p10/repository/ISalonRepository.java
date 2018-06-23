package com.dvlk.p10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvlk.p10.bean.Salon;

@Repository
public interface ISalonRepository extends JpaRepository<Salon, Integer>{

}
