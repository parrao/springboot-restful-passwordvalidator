package com.ppr.pw.constraint;

import com.ppr.pw.constraint.RuleResult;
/**
 * Interface for password Validator rules.
 * @author Parthi
 */
public interface ValidationRule {
	
	RuleResult validate(String passwordData);

}
