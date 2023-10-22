package com.example.staffmanagement.controller;


import com.example.staffmanagement.dao.entities.Staff;
import com.example.staffmanagement.dao.entities.User;
import com.example.staffmanagement.servicesStaff.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.staffmanagement.servicesStaff.userService;

import java.util.List;

@RestController
@RequestMapping(value="/api/staff")
public class StaffController {
    @Autowired
    private StaffServiceImpl staffServices;
    @Autowired
    private userService userService;

    @GetMapping
    public List<Staff> getAllStaffMembers() {
        return staffServices.getAllStaffMembers();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Integer id) {
        return staffServices.getStaffById(id);
    }

    @PostMapping("/add/{userId}")
    public Staff createStaff(@RequestBody Staff staff,@PathVariable String userId) {
        User user = userService.getUserById(userId);
        staff.setUserId(user.get_id());
        System.out.println("user id is "+user.get_id());
        Staff createdStaff = staffServices.createStaff(staff, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStaff).getBody();


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
