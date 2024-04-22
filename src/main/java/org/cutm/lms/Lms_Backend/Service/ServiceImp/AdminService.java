package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import lombok.AllArgsConstructor;
import org.cutm.lms.Lms_Backend.Entity.Admin;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Exception.ResourceNotFound;
import org.cutm.lms.Lms_Backend.Repository.UserRepo;
import org.cutm.lms.Lms_Backend.Service.AdminMethods;
import org.cutm.lms.Lms_Backend.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminService implements AdminMethods {

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public Admin createAdmin(Admin admin) {
		String s="AD";
		String t=String.valueOf(new Date().getTime()).substring(10,13);
		admin.setAdminId(s + UUID.randomUUID().toString().substring(0,4) +t);
		Admin savedAdmin = adminRepo.save(admin);
		User user1 = new User(savedAdmin.getAdminId(),savedAdmin.getAdminEmail(),savedAdmin.getAdminPasswd());
		userRepo.save(user1);
		return savedAdmin;
	}

	@Override
	public Admin getAdminById(String id) {
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
	public void deleteAdmin(String id) {
		adminRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Admin does not exist with id : " + id));
		adminRepo.deleteById(id);
	}

	@Override
	public Admin updateAdmin(String id, Admin updatedAdmin) {
		Admin previousAdmin = adminRepo.findById(id).orElseThrow(
				() -> new ResourceNotFound("Admin does not exist with id : " + id)
		);
		previousAdmin.setAdminEmail(updatedAdmin.getAdminEmail());
		previousAdmin.setAdminPasswd((updatedAdmin.getAdminPasswd()));
		Admin savedAdmin = adminRepo.save(previousAdmin);
		return savedAdmin;
	}
}