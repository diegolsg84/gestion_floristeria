package com.iudigital.floristeria.Repository;

import com.iudigital.floristeria.models.finanzas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanzasRepository extends JpaRepository<finanzas,Long> {
    
}
