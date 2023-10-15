package com.example.staffmanagement.controller;


import com.example.staffmanagement.dao.entities.Staff;
import com.example.staffmanagement.servicesStaff.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/staff")
public class StaffController {
    @Autowired
    private StaffServiceImpl staffServices;
    @GetMapping
    public List<Staff> getAllStaffMembers() {
        return staffServices.getAllStaffMembers();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Integer id) {
        return staffServices.getStaffById(id);
    }

    @PostMapping
    public Staff createStaff(@RequestBody Staff staff) {
        return staffServices.createStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Integer id, @RequestBody Staff staff) {
        return staffServices.updateStaff(id, staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Integer id) {
        staffServices.deleteStaff(id);
    }

}
