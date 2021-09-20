package com.jc.sgtasec.service;

import java.util.List;

import com.jc.sgtasec.model.Rol;
import com.jc.sgtasec.repository.IRolRepository;

public class RolServiceImpl implements IRolService{
	
	private IRolRepository rolRepository;

	public RolServiceImpl(IRolRepository rolRepository) {
		super();
		this.rolRepository = rolRepository;
	}
	
	@Override
	public List<Rol> getAllRols() {
		return rolRepository.findAll();
	}

	@Override
	public Rol saveRol(Rol rol) {
		return rolRepository.save(rol);
	}

	@Override
	public Rol getRolById(Long id) {
		return rolRepository.findById(id).get();
	}

	@Override
	public Rol updateRol(Rol rol) {
		return rolRepository.save(rol);
	}

	@Override
	public void deleteRolById(Long id) {
		rolRepository.deleteById(id);
	}

}
