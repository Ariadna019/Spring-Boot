package com.mtw.logeoregistrar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtw.logeoregistrar.Models.MenuModel;


@Repository
public interface PideOnlineRepository extends JpaRepository<MenuModel, Integer> {
}
