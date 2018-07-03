package com.munifec.carpool.images.exception;

public class ImageStorageException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5431538290641367197L;

	public ImageStorageException(String message) {
        super(message);
    }

    public ImageStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
