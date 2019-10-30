package com.demo.repository;

import com.demo.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2019/7/26.
 */
public interface SystemLogRepository extends JpaRepository<Log, Long> {
}
