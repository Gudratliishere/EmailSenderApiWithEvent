package com.company.emailsenderapiwithevent.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDTO
{
    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object object;

    public static ResponseDTO of (Object object, String successMessage)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(object);
        responseDTO.setSuccessMessage(successMessage);
        return responseDTO;
    }

    public static ResponseDTO of (Object object, String errorMessage, Integer errorCode)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(object);
        responseDTO.setErrorMessage(errorMessage);
        responseDTO.setErrorCode(errorCode);
        return responseDTO;
    }
}
