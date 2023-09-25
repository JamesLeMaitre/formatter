package com.mtj.formatterresponse.dataFormatter;

import org.springframework.validation.FieldError;

import java.util.List;

public class DataFormatter<T> {
    public Formatter<T> renderData(boolean status, T data, String message){
        Formatter formatter = new Formatter<T>();
        formatter.setStatus(status);
        formatter.setData(data);
        formatter.setMessage(message);
        return formatter;
    }

    public Formatter<T> renderErrorData(boolean status, List<FieldError> data, String message){
        Formatter formatter = new Formatter<T>();
        formatter.setStatus(status);
        formatter.setData(data);
        formatter.setMessage(message);
        return formatter;
    }

    public Object renderObjectData(boolean status, Object data, String message) {
        Formatter formatter = new Formatter<Object>();
        formatter.setStatus(status);
        formatter.setData(data);
        formatter.setMessage(message);
//        return {
//                success: success,
//                data: data,
//                message: message
//    };
        return formatter;
    }

    public Formatter<List<T>> renderDataArray(boolean status, List<T> data, String message){
        Formatter formatter = new Formatter<List<T>>();
        formatter.setStatus(status);
        formatter.setData(data);
        formatter.setTotal(data.size());
        formatter.setMessage(message);
        return formatter;
    }


    public  Formatter<String> renderStringData(boolean status, String data, String message){
        Formatter formatter = new Formatter<>();
        formatter.setStatus(status);
        formatter.setData(data);
        formatter.setMessage(message);
        return formatter;
    }

    public  Formatter<Double> renderDoubleData(boolean status, Double data, String message){
        Formatter formatter = new Formatter<>();
        formatter.setStatus(status);
        formatter.setData(data);
        formatter.setMessage(message);
        return formatter;
    }





}
