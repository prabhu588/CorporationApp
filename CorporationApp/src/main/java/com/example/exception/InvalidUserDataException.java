package com.example.exception;

public class InvalidUserDataException  extends RuntimeException {



		private static final long serialVersionUID = 1L;
		
		public InvalidUserDataException(String message) {
			super(message);
		}
		
		public InvalidUserDataException(String message, Throwable t) {
			super(message, t);
		}

	}

