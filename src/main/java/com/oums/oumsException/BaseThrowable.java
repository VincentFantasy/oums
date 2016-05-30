package com.oums.oumsException;

/**
 * 
 * @author 谭治
 *
 */
public class BaseThrowable extends Throwable {

	/**
    * 序列化ID
    */
    private static final long serialVersionUID = 1L;
	
    public BaseThrowable() {
        super();
    }
    
    public BaseThrowable(String msg) {
        super(msg);
    }
    
    public BaseThrowable(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public BaseThrowable(Throwable cause) {
        super(cause);
    }
}
