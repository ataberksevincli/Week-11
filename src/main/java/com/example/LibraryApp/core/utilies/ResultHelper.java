package com.example.LibraryApp.core.utilies;

import com.example.LibraryApp.core.result.Result;
import com.example.LibraryApp.core.result.ResultData;
import com.example.LibraryApp.dto.CursorResponse;
import org.springframework.data.domain.Page;

public class ResultHelper {
    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true, Message.CREATED, "201", data);
    }

    public static <T> ResultData<T> validateError(T data) {
        return new ResultData<>(false, Message.VALIDATE_ERROR, "400", data);
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(true, Message.OK, "200", data);
    }

    public static Result notFoundError(String message) {
        return new Result(false, message, "404");
    }
    public static Result successResult() {
        return new Result(true, Message.OK, "200");
    }


    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData){
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());
        return ResultHelper.success(cursor);
    }
}