package org.quanye.uniontype;

import org.quanye.exttype.Null;

public class Option extends Union {
    public Option(Class<?> clazz) {
        super(Null.class, clazz);
    }

    public Option(Null nullVal, Class<?> clazz) {
        super(Null.class, clazz);
        set(nullVal);
    }
}
