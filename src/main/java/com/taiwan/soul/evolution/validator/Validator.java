package com.taiwan.soul.evolution.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.taiwan.soul.evolution.core.URlName;
import com.taiwan.soul.evolution.exception.ValidateException;
import com.taiwan.soul.evolution.validator.ValidateRule.EmailValidateRule;
import com.taiwan.soul.evolution.validator.ValidateRule.MidValidateRule;
import com.taiwan.soul.evolution.validator.ValidateRule.PasswordValidateRule;
import com.taiwan.soul.evolution.validator.ValidateRule.ValidateRule;

public class Validator {

	@Autowired
	private MidValidateRule midValidateRule;

	@Autowired
	private EmailValidateRule emailValidateRule;

	@Autowired
	private PasswordValidateRule passwordValidateRule;

	public void executeValidattion(URlName urlName) throws ValidateException {
		for (ValidateRule validateRule : getValidateRuleList(urlName)) {
			validateRule.validate();
		}
	}

	public List<ValidateRule> getValidateRuleList(URlName urlName) {
		List<ValidateRule> validateRuleList = new ArrayList<ValidateRule>();
		switch (urlName) {
		case SIGNUP:
			validateRuleList.add(midValidateRule);
			validateRuleList.add(emailValidateRule);
			validateRuleList.add(passwordValidateRule);
			break;
		default:
			break;
		}
		return validateRuleList;
	}
}
