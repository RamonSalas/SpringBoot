package com.example.SpringBoot4.Repository;

import com.example.SpringBoot4.Entidades.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop,Long> {

}
