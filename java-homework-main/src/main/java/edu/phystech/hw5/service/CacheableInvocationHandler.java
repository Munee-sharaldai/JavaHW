package edu.phystech.hw5.service;

import edu.phystech.hw5.annotation.Cacheable;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author kzlv4natoly
 */
public class CacheableInvocationHandler implements InvocationHandler {
    // Здесь необходимо реализовать логику по обработке @cacheable и вызову конкретного метода объекта

    private final Object target;
    private final Map<String, Object> argumentsAndResults = new HashMap<>();

    public CacheableInvocationHandler(Object target) throws IllegalAccessException {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] arguments) throws Throwable {
        String cacheKey = method.getName() + Arrays.toString(arguments);

        if (!argumentsAndResults.containsKey(cacheKey)) {
            var result = method.invoke(target, arguments);
            argumentsAndResults.put(cacheKey, result);
            return result;
        }

        return argumentsAndResults.get(cacheKey);
    }
}
