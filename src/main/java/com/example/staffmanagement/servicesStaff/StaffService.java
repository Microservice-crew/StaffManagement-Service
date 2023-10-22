package com.example.staffmanagement.servicesStaff;


import com.example.staffmanagement.dao.entities.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getAllStaffMembers();
    Staff getStaffById(Integer id);
    Staff createStaff(Staff staff,String userId);


    Staff updateStaff(Integer id, Staff staff);
    void deleteStaff(Integer id);
}
