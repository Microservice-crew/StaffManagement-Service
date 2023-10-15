package com.example.staffmanagement.dao.repository;

import com.example.staffmanagement.dao.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
