package com.example.DOSOPTaladin.repository;

import com.example.DOSOPTaladin.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartJpaRepository extends JpaRepository<Cart, Long> {

}
