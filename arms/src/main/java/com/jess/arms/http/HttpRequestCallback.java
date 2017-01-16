package com.jess.arms.http;

import com.google.gson.internal.$Gson$Types;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;

/**
 * User: yxfang
 * Date: 2016-04-29
 * Time: 19:15
 * ------------- Description -------------
 * ---------------------------------------
 */
public abstract class HttpRequestCallback<T> {
    public Type type;

    public HttpRequestCallback() {
        type = getSuperclassTypeParameter(getClass());
    }

    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter");
        }
        ParameterizedType parameterizedType = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
    }

    public abstract void onStart();
    public abstract void onFinish();
    public abstract void onResponse(T t);
    public abstract void onFailure(Call call, HttpException e);
}
