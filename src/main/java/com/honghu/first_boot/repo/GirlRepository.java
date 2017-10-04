package com.honghu.first_boot.repo;

import com.honghu.first_boot.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer>{
     List<Girl> findGirlsByAge(Integer age);
}
