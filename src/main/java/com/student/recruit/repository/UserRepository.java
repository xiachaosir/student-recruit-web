package com.student.recruit.repository;

import com.student.recruit.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Description .
 * @Author xiachao
 * @CreateTime 2017/1/9 11:32
 */
public interface UserRepository extends JpaRepository<User, String> {

    Page<User> findAll(Pageable pageable);


    User findById(String id);

    List<User> findByUsernameIgnoreCase(String username);

    User findByUsername(String username);

    Long countByPhone(String phone);

    @Modifying
    Long deleteByPhone(String phone);

    User findByPhone(String id);
}
