
package com.mtw.logeoregistrar.Repositories;

import com.mtw.logeoregistrar.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Puedes agregar métodos personalizados si es necesario
}