package com.mtw.logeoregistrar.Repositories;

import com.mtw.logeoregistrar.Models.EventosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<EventosModel, Long> {
}
