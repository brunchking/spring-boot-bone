package com.taiwan.soul.evolution.validator.ValidateRule;

import com.taiwan.soul.evolution.exception.ValidateException;

public interface ValidateRule {
	public void validate() throws ValidateException;
}
