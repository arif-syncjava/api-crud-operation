package com.arifsyncjava.apicrudoperation.simcard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimRepository extends JpaRepository<SimCard,Integer> {
}
