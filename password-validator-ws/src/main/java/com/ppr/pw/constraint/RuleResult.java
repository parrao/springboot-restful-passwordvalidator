package com.ppr.pw.constraint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Result of a password rule validation.
 * @author Parthi
 */

public class RuleResult {
	
	 protected boolean valid;
	 protected List<String> details = new ArrayList<>();
	 
	 /** Default constructor. */
	  public RuleResult() {}


	  
	  /**
	   * Creates a new rule result.
	   *
	   * @param  b  result validity
	   */
	  public RuleResult(final boolean b)
	  {
	    setValid(b);
	  }
	  
	  
	  /**
	   * Creates a new rule result.
	   *
	   * @param  b  result validity 
	   * @param msg result message
	   */
	  public RuleResult(final boolean b,final String msg)
	  {
	    setValid(b);
	    details.add(msg);
	  }
	  
	  
	  /**
	   * Returns whether the result of the rule verification is a valid password.
	   *
	   * @return  valid password for this rule
	   */
	  public boolean isValid()
	  {
	    return valid;
	  }


	  /**
	   * Sets whether the result of the rule verification is a valid password.
	   *
	   * @param  b  valid password for this rule
	   */
	  public void setValid(final boolean b)
	  {
	    valid = b;
	  }


	  /**
	   * Returns any details associated with the rule verification.
	   *
	   * @return  rule result details
	   */
	  public List<String> getDetails()
	  {
	    return details;
	  }

	  /**
	   * Sets any details associated with the rule verification.
	   *
	   * @param  rrd  rule result details
	   */
	  public void setDetails(final String... rrd)
	  {
	    setDetails(Arrays.asList(rrd));
	  }


	  /**
	   * Sets any details associated with the rule verification.
	   *
	   * @param  rrd  rule result details
	   */
	  public void setDetails(final List<String> rrd)
	  {
	    details = rrd;
	  }
	  
	  
}
