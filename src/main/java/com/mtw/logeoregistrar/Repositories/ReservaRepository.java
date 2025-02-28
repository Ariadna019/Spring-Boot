package com.mtw.logeoregistrar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtw.logeoregistrar.Models.ReservaModel;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel,Long>{

}
