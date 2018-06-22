package com.ppr.pw.constraint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;




/**
 * The ValidationRule implementation for evaluating password rules.
 * @author Parthi
 */
public class PasswordValidator implements ValidationRule {
	
	 private final List<? extends ValidationRule> passwordRules;
	 
	 /**
	   * Creates a new password validator with ValidationRule
	   *
	   * @param  rules  to validate
	   */
	 public PasswordValidator(final ValidationRule... rules)
	  {
	    this(Arrays.asList(rules));
	  }

	 
	 /**
	   * Creates a new password validator with ValidationRule List
	   *
	   * @param  rules  to validate
	   */
	  public PasswordValidator(final List<? extends ValidationRule> rules)
	  {
	    
	    passwordRules = rules;
	  }
	  
	  
	  /**
	   * Returns the password rules for this validator.
	   *
	   * @return  unmodifiable list of password rules
	   */
	  public List<ValidationRule> getRules()
	  {
	    return Collections.unmodifiableList(passwordRules);
	  }
 
	  
	  
	  /**
	   * Validates the input password against the rules in this validator.
	   *
	   * @param  passwordData  to validate
	   *
	   * @return  rule result
	   */
	  @Override
	  public RuleResult validate(final String passwordData)
	  {
	    final RuleResult result = new RuleResult(true);
	    for (ValidationRule rule : passwordRules) {
	      final RuleResult rr = rule.validate(passwordData);
	      if (!rr.isValid()) {
	        result.setValid(false);
	        result.getDetails().addAll(rr.getDetails());
	      }
	    }
	    return result;
	  }

}
