package com.nicolas.gts.mychurch.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.dto.UserNewDTO;
import com.nicolas.gts.mychurch.repositories.UserRepository;
import com.nicolas.gts.mychurch.resources.exception.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsert, UserNewDTO> {
	
	@Autowired
	private UserRepository repo;
	
	
	@Override
	public void initialize(UserInsert ann) {
	}

	@Override
	public boolean isValid(UserNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		User aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email exist already!"));
		}
		
		aux = repo.findByCpf(objDto.getCpf());
		if (aux != null) {
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
