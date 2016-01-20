package com.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED,reason="spittle not found")
public class DefineHandleException extends RuntimeException{

}
