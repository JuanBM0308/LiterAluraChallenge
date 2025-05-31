package com.juanba.LiteAluraChallenge.service;

public interface IConvertData {
    <T> T getData(String json, Class<T> tClass);
}
