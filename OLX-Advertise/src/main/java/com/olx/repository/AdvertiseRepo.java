package com.olx.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.entity.AdvertiseEntity;

public interface AdvertiseRepo extends JpaRepository<AdvertiseEntity, Integer> {

}
