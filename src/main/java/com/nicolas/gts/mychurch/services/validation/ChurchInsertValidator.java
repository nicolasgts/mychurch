package com.nicolas.gts.mychurch.services.validation;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.dto.ChurchNewDTO;
import com.nicolas.gts.mychurch.repositories.ChurchRepository;
import com.nicolas.gts.mychurch.repositories.UserRepository;
import com.nicolas.gts.mychurch.resources.exception.FieldMessage;

public class ChurchInsertValidator implements ConstraintValidator<ChurchInsert, ChurchNewDTO> {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ChurchRepository repo;
	
	
	@Override
	public void initialize(ChurchInsert ann) {
	}

	@Override
	public boolean isValid(ChurchNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
			

		User aux = userRepo.findByEmail(objDto.getEmail_user());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email exist already!"));
		}
		
		aux = userRepo.findByCpf(objDto.getCpf_user());
		if (aux != null) {
			list.add(new FieldMessage("cpf", "Cpf exist already!"));
		}
		
		Church aux1 = repo.findByName(objDto.getName());
		if (aux1 != null) {
			list.add(new FieldMessage("name", "Church's name exist already!"));
		}
		
		aux1 = repo.findByCnpj(objDto.getCnpj());
		if (aux1 != null) {
			list.add(new FieldMessage("cpf", "Cpf exist already!"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}