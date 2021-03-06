package com.employee.employeeapplication.exception;

import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.employeeapplication.dto.ResponseDTO;

@ControllerAdvice
@Slf4j
public class EmployeeServiceExceptionHandler {

	private static final String message = "Exception while processing request";

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpNotReadableException(HttpMessageNotReadableException exception){

		log.error("Invalid Date Format" , exception);
		ResponseDTO responseDTO = new ResponseDTO(message , "Date should be of the format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleArgumentNotValidExceptionEntity (MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
															.collect(Collectors.toList());
		
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing ", errorMessage);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeServiceException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayRollException (EmployeeServiceException exception){
		
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing ", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
}
