package com.uhg.tanmay.particle.api.dao;

import com.uhg.tanmay.particle.api.entity.Particle;
import com.uhg.tanmay.particle.api.wrappers.GetWrapper;
import com.uhg.tanmay.particle.api.wrappers.TotalWrapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface ParticleDao extends CrudRepository<Particle, Integer> {
    @Query(value = "SELECT p FROM Particle p WHERE p.tid = :#{#tid}")
    ArrayList<Particle> getFromTid(@Param("tid") int tid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Particle p SET p.quantity = p.quantity - :#{#quantity} WHERE p.tid = :#{#tid} AND p.price = :#{#price}")
    void update(@Param("tid") int tid, @Param("price") double price, @Param("quantity") long quantity);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Particle p SET p.quantity = p.quantity + :#{#quantity} WHERE p.tid = :#{#tid} AND p.price = :#{#price}")
    void updateAdd(@Param("tid") int tid, @Param("price") double price, @Param("quantity") long quantity);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Particle p SET p.price = :#{#price} WHERE p.tid = :#{#tid} AND p.quantity = :#{#quantity}")
    void putPrice(@Param("tid") int tid, @Param("price") double price, @Param("quantity") long quantity);

    @Query(value = "SELECT new com.uhg.tanmay.particle.api.wrappers.GetWrapper(p.tid, p.type, p.quantity, p.price) FROM Particle p")
    ArrayList<GetWrapper> getOnlyNecessary();

    @Query(value = "SELECT new com.uhg.tanmay.particle.api.wrappers.TotalWrapper(p.tid, SUM(p.quantity), SUM(p.price), AVG(p.price)) FROM Particle p GROUP BY(p.tid)")
    ArrayList<TotalWrapper> getTotal();

    @Query(value = "SELECT p from Particle p WHERE p.tid = :#{#tid} and p.price = :#{#price} and p.quantity >= :#{#quantity}")
    ArrayList<Particle> getbyPriceAndid(@Param("tid") int tid,@Param("price") double price,@Param("quantity") long quantity);

    @Query(value = "Select p from Particle p ORDER BY p.price DESC")
    ArrayList<Particle> filterByPrice();

    @Query(value = "Select p from Particle p ORDER BY p.quantity DESC")
    ArrayList<Particle> filterByQuantity();

    @Query(value = "Select p from Particle p ORDER BY p.charge DESC")
    ArrayList<Particle> filterByCharge();
}