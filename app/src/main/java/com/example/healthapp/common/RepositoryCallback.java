package com.example.healthapp.common;

/** Receives an asynchronous database result on the Android main thread. */
public interface RepositoryCallback<T> {
    void onSuccess(T result);

    void onError(Throwable error);
}
