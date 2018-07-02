package com.dvlk.p10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dvlk.p10.bean.Terrain;

@Repository
public interface ITerrainRepository extends JpaRepository<Terrain, Integer> {

	@Query("FROM Terrain terrain WHERE terrain.lieu.id = :aLieuId")
	public List<Terrain> findAllTerrainByLieuId(@Param("aLieuId") int aLieuId);

}
