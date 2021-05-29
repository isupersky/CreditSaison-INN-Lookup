package com.example.CreditSaisonINNLookup.dto;

public class CommonResponseDTO<T> {
  private boolean success;
  private T payload;
  private long start;
  private long limit;

  public CommonResponseDTO(boolean success, T payload) {
    this.success = success;
    this.payload = payload;
  }

  public CommonResponseDTO(boolean success, T payload, long start, long limit) {
    this.success = success;
    this.payload = payload;
    this.start = start;
    this.limit = limit;
  }

  public boolean isSuccess() {
    return success;
  }

  public CommonResponseDTO setSuccess(boolean success) {
    this.success = success;
    return this;
  }

  public T getPayload() {
    return payload;
  }

  public CommonResponseDTO setPayload(T payload) {
    this.payload = payload;
    return this;
  }

  public long getStart() {
    return start;
  }

  public CommonResponseDTO setStart(long start) {
    this.start = start;
    return this;
  }

  public long getLimit() {
    return limit;
  }

  public CommonResponseDTO setLimit(long limit) {
    this.limit = limit;
    return this;
  }

  public static<T> CommonResponseDTO<T> success(T payload){
    return new CommonResponseDTO(true, payload);
  }

  public static <T> CommonResponseDTO<T> success(T payload, Long start, Long limit) {
    return new CommonResponseDTO(true, payload, start, limit);
  }

  public static<T> CommonResponseDTO<T> failure(String errorMessage){
    return new CommonResponseDTO(false, errorMessage);
  }
}
