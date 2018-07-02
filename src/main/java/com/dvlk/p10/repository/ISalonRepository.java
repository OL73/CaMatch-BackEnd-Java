package com.dvlk.p10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dvlk.p10.bean.Lieu;
import com.dvlk.p10.bean.Salon;

@Repository
public interface ISalonRepository extends JpaRepository<Salon, Integer>{

	@Query("FROM Lieu lieu WHERE ")
	public Lieu findLieuBySalonId(@Param("aSalonId") int aSalonId);

}
