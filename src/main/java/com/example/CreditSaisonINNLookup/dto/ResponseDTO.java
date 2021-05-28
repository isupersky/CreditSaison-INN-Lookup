package com.example.CreditSaisonINNLookup.dto;

import java.util.Collection;

public class ResponseDTO<T> {
  private boolean success;
  private T payload;
  private long start;
  private long stop;
  private long limit;
  private long size;

  public ResponseDTO(boolean success, T payload) {
    this.success = success;
    this.payload = payload;
  }

  public boolean isSuccess() {
    return success;
  }

  public ResponseDTO setSuccess(boolean success) {
    this.success = success;
    return this;
  }

  public T getPayload() {
    return payload;
  }

  public ResponseDTO setPayload(T payload) {
    this.payload = payload;
    return this;
  }

  public long getStart() {
    return start;
  }

  public ResponseDTO setStart(long start) {
    this.start = start;
    return this;
  }

  public long getStop() {
    return stop;
  }

  public ResponseDTO setStop(long stop) {
    this.stop = stop;
    return this;
  }

  public long getLimit() {
    return limit;
  }

  public ResponseDTO setLimit(long limit) {
    this.limit = limit;
    return this;
  }

  public long getSize() {
    return size;
  }

  public ResponseDTO setSize(long size) {
    this.size = size;
    return this;
  }
  public static<T> ResponseDTO<T> success(T payload){
    return new ResponseDTO(true, payload);
  }
  public static<T> ResponseDTO<T> failure(String errorMessage){
    return new ResponseDTO(false, errorMessage);
  }
}
