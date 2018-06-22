package com.ppr.pw.constraint;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * ValidationRule for determining if a password length is between 5 and 12 chars
 * @author Parthi
 */
public class LengthRule implements ValidationRule {

	  private int minLength;
	  private int maxLength;

	  
	  /**
	   * Create a new length rule.
	   *
	   * @param  minLength  minimum length of a password
	   * @param  maxLength  maximum length of a password
	   */
	  public LengthRule(final int minLength, final int maxLength)
	  {
	    this.minLength = minLength;
	    this.maxLength = maxLength;
	  }


	  /**
	   * Sets the minimum password length.
	   *
	   * @param  minLength  minimum length of a password
	   */
	  public void setMinimumLength(final int minLength)
	  {
		  this.minLength = minLength;
	  }


	  /**
	   * Returns the minimum password length.
	   *
	   * @return  minimum password length
	   */
	  public int getMinLength()
	  {
	    return minLength;
	  }


	  /**
	   * Sets the maximum password length.
	   *
	   * @param  maxLength  maximum length of a password
	   */
	  public void setMaxLength(final int maxLength)
	  {
	    this.maxLength = maxLength;
	  }


	  /**
	   * Returns the maximum password length.
	   *
	   * @return  maximum length of a password
	   */
	  public int getMaxLength()
	  {
	    return maxLength;
	  }

	  /**
	   * Validates the input password min and max length.
	   *
	   * @param  passwordData  to validate
	   *
	   * @return  rule result
	   */
	  @Override
	  public RuleResult validate(final String passwordData)
	  {
	    final RuleResult result = new RuleResult();
	    final int length = passwordData.length();
	    if (length >= minLength && length <= maxLength) {
	      result.setValid(true);
	    } else {
	      result.setValid(false);
	      if (length < minLength) {
	        result.getDetails().add(new String("TOO SHORT - The Length should be between "+minLength+" and "+maxLength));
	      } else {
	        result.getDetails().add(new String("TOO LONG - The Length should be between "+minLength+" and "+maxLength));
	      }
	    }
	   
	    return result;
	  }

}
