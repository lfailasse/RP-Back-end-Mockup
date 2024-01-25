package com.lfailasse.RPBackend.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lfailasse.RPBackend.Models.EntityRP;

public interface RPRepository extends JpaRepository<EntityRP, String> {

    @Query(value = "select * from rp r where r.rp_id like %?1%", nativeQuery = true)
    public List<EntityRP> findByids(String id);

    public EntityRP findByid(String id);

    @Query(value = "select * from rp r where r.rp_favorecido like %?1%", nativeQuery = true)
    public Page<EntityRP> findByfavorecido(String param, Pageable pageable);

    @Query(value = "select * from rp r where r.rp_id like %?1%", nativeQuery = true)
    public Page<EntityRP> findByIdPage(String param, Pageable pageable);

    public EntityRP findTopByOrderByCountDesc();

}
