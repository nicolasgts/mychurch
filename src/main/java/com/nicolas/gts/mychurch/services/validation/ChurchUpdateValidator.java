package com.nicolas.gts.mychurch.services.validation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.nicolas.gts.mychurch.domain.Church;
import com.nicolas.gts.mychurch.domain.User;
import com.nicolas.gts.mychurch.dto.ChurchDTO;
import com.nicolas.gts.mychurch.repositories.ChurchRepository;
import com.nicolas.gts.mychurch.resources.exception.FieldMessage;

public class ChurchUpdateValidator implements ConstraintValidator<ChurchUpdate, ChurchDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ChurchRepository repo;
	
	
	@Override
	public void initialize(ChurchUpdate ann) {
	}

	@Override
	public boolean isValid(ChurchDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		
		List<FieldMessage> list = new ArrayList<>();
			
		
		Church aux = repo.findByName(objDto.getName());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("name", "Church's name exist already"));
		}

	
		aux = repo.findByCnpj(objDto.getCnpj());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("cpf", "Cnpj exist already!"));
		}
		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}