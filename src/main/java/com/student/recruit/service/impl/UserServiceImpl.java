package com.student.recruit.service.impl;

import com.student.recruit.domain.User;
import com.student.recruit.repository.UserRepository;
import com.student.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description .
 * @Author xiachao
 * @CreateTime 2017/1/9 11:32
 */
@Service
@Transactional(readOnly = true)
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * @param user
     */
    @Override
    @Transactional(readOnly = false)
    @CacheEvict(value = "user")
    public void delete(User user) {
        System.out.println("删除user缓存");
        userRepository.delete(user);

    }

    /**
     * @param user
     */
    @Override
    @Transactional(readOnly = false)
    @CachePut(value = "user")
    public void update(User user) {
        userRepository.save(user);
    }

    /**
     * @param user
     */
    @Override
    @Transactional(readOnly = false)
    @Cacheable
    public void save(User user) {
        userRepository.save(user);
        System.out.println("id=" + user.getId() + "已做cache");
    }

    @Override
    @Cacheable
    public User findByPhone(String id) {
        return userRepository.findByPhone(id);
    }

    @Override
    @Cacheable
    public User findById(String id) {
        return userRepository.findById(id);
    }
}
