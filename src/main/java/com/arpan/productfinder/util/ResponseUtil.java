package com.arpan.productfinder.util;

import com.arpan.productfinder.dto.ResponseDto;

import java.util.ArrayList;
import java.util.List;

public class ResponseUtil <T> {
    public static <T> ResponseDto <T> setSuccessResponse (List<T> responseList) {
        return (ResponseDto<T>) new ResponseDto<>()
                .setMessage("Success")
                .setStatus(400)
                .setResult((List<Object>) responseList);

    }

    public static <T> ResponseDto <T> setErrorResponse (String errorMessage) {
        return (ResponseDto<T>) new ResponseDto<>()
                .setMessage(errorMessage)
                .setStatus(200)
                .setResult(new ArrayList<>());

    }
}
