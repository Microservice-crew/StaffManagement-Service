package com.example.staffmanagement.servicesStaff;

import com.example.staffmanagement.dao.entities.Staff;
import com.example.staffmanagement.dao.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;


    @Override
    public List<Staff> getAllStaffMembers() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffById(Integer id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }



    @Override
    public Staff updateStaff(Integer id, Staff staff) {
        Staff existingStaff = staffRepository.findById(id).orElse(null);
        if (existingStaff != null) {
            // Mettez à jour les champs nécessaires de l'employé existant avec les nouvelles valeurs
            existingStaff.setNom(staff.getNom());
            existingStaff.setPrenom(staff.getPrenom());
            existingStaff.setTelephone(staff.getTelephone());
            existingStaff.setDepartement(staff.getDepartement());

            // Enregistrez les modifications dans la base de données
            return staffRepository.save(existingStaff);
        }
        return null;
    }

    @Override
    public void deleteStaff(Integer id) {
        staffRepository.deleteById(id);
    }
}
