package com.example.generate_code;

import com.autumn.domain.repositories.DefaultEntityRepository;
import com.zjsm.sp.entities.IntegralLog;
import com.zjsm.sp.entities.User;
import org.springframework.stereotype.Repository;

/**
 * @author yanlianglong
 * @date 2020/6/3
 */
@Repository
public interface UserRepository extends DefaultEntityRepository<User> {

}
