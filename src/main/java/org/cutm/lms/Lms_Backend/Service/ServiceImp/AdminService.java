package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import lombok.AllArgsConstructor;
import org.cutm.lms.Lms_Backend.Entity.Admin;
import org.cutm.lms.Lms_Backend.Exception.ResourceNotFound;
import org.cutm.lms.Lms_Backend.Service.AdminMethods;
import org.cutm.lms.Lms_Backend.Repository.AdminRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService implements AdminMethods {

	private AdminRepo adminRepo;

	@Override
	public Admin createAdmin(Admin admin) {
		Admin savedAdmin = adminRepo.save(admin);
		return savedAdmin;
	}

	@Override
	public Admin getAdminById(Long id) {
		Admin admin = adminRepo.findById(id).orElseThrow(
				() -> new ResourceNotFound("Admin not exist with id : "+id)
		);
		return admin;
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> admins = adminRepo.findAll();
		return admins;
	}

	@Override
	public void deleteAdmin(Long id) {
		adminRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Admin does not exist with id : " + id));
		adminRepo.deleteById(id);
	}

	@Override
	public Admin updateAdmin(Long id, Admin updatedAdmin) {
		Admin previousAdmin = adminRepo.findById(id).orElseThrow(
				() -> new ResourceNotFound("Admin does not exist with id : " + id)
		);
		previousAdmin.setAdminEmail(updatedAdmin.getAdminEmail());
		previousAdmin.setAdminPasswd((updatedAdmin.getAdminPasswd()));
		Admin savedAdmin = adminRepo.save(previousAdmin);
		return savedAdmin;
	}
}