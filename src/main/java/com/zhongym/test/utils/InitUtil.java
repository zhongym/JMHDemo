package com.zhongym.test.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class InitUtil {
    public static <T> List<T> init(Class<T> cl, int size) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(init(cl));
        }
        return list;
    }

    public static <T> T init(Class<T> cl) {
        try {
            T t = cl.newInstance();
            List<Field> fields = FieldUtils.getFieldsListWithAnnotation(cl, ApiModelProperty.class);
            for (Field field : fields) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                if (Long.class.isAssignableFrom(field.getType())) {
                    field.set(t, RandomUtils.nextLong(0, 100000000000L));
                }

                if (Integer.class.isAssignableFrom(field.getType())) {
                    field.set(t, 1);
                }

                if (String.class.isAssignableFrom(field.getType())) {
                    ApiModelProperty annotation = field.getAnnotation(ApiModelProperty.class);
                    String value = annotation.value() + RandomUtils.nextLong(0, 1000L);

                    field.set(t, value);
                }

                if (Boolean.class.isAssignableFrom(field.getType())) {
                    field.set(t, true);
                }

                if (LocalDateTime.class.isAssignableFrom(field.getType())) {
                    field.set(t, LocalDateTime.now());
                }

                if (BigDecimal.class.isAssignableFrom(field.getType())) {
                    field.set(t, BigDecimal.valueOf(RandomUtils.nextLong(0, 10000000L)));
                }
            }

            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
