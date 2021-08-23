package org.quanye.uniontype;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Union {
    private final Set<Class<?>> types = new HashSet<>();
    private Object value;

    public Union(Class<?>... classes) {
        Collections.addAll(types, classes);
    }

    public <T> Union(T val, Class<?>... classes) {
        Collections.addAll(types, classes);
        set(val);
    }

    public void set(Object value) {
        Class<?> clazz = value.getClass();
        if (types.contains(clazz)) {
            this.value = value;
        } else {
            throw new RuntimeException("UnionType: don't specify type: " + clazz.getName() + ".");
        }
    }

    public boolean isType(Class<?> clazz) {
        return clazz.isInstance(value);
    }

    public <T> T get(Class<T> clazz) {
        if (value == null) {
            throw new RuntimeException("UnionType: don't init the value.");
        } else {
            return (T) value;
        }
    }

    @Override
    public String toString() {
        return "Union{" +
                "types=" + types +
                ", value=" + value +
                '}';
    }
}
