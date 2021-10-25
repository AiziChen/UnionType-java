package org.quanye.uniontype;

import org.quanye.exttype.Null;

public class Option extends Union {
    public Option(Class<?> clazz) {
        super(Null.class, clazz);
        set(Null.instance);
    }

    public boolean isNull() {
        return isType(Null.class);
    }
}
