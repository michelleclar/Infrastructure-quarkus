package org.carl.comment.Josn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.carl.comment.Josn.parse.adapter.LocalDateAdapter;
import org.carl.comment.Josn.parse.adapter.LocalDateTimeAdapter;
import org.carl.comment.Josn.parse.adapter.ZonedDateTimeTypeAdapter;

public class JSON {

    static Gson gson;

    static {
        gson =
                new GsonBuilder()
                        .setPrettyPrinting()
                        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                        .registerTypeAdapter(
                                ZonedDateTimeTypeAdapter.class, new ZonedDateTimeTypeAdapter())
                        //            // 为特定类型注册自定义的序列化器或反序列化器（不支持协变）
                        //            .registerTypeAdapter(Boolean:: class.java,
                        // BooleanTypeAdapter())
                        //            // 为特定类型注册自定义的序列化器或反序列化器（支持协变）
                        //            .registerTypeHierarchyAdapter(xxxx)
                        //            // 注册一个能够为多种类型提供适配器的工厂
                        //            .registerTypeAdapterFactory(xxxx)
                        //            // 设置长整型（Long）字段的序列化策略，例如将其序列化为字符串而不是数字
                        //            .setLongSerializationPolicy(LongSerializationPolicy.STRING)
                        // 自定义日期/时间字段的序列化格式
                        //            .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
                        //            // 设置字段命名策略，以控制字段如何映射到JSON键名（默认不改变命名风格）
                        //
                        // .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        //            // 设置自定义的字段命名策略，用于控制字段如何映射到JSON键名
                        //            .setFieldNamingStrategy(xxxx)
                        //            // 排除具有特定Java修饰符（默认 transient 和 static）的字段
                        //
                        // .excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT or
                        //                java.lang.reflect.Modifier.STATIC)
                        //            // 设置只序列化和反序列化带有@Expose注解的字段
                        //            .excludeFieldsWithoutExposeAnnotation()
                        //            // 设置类或字段过滤规则
                        //            .setExclusionStrategies(xxxx)
                        //            // 设置过滤规则（只适用于序列化）
                        //            .addSerializationExclusionStrategy(xxxx)
                        //            // 设置过滤规则（只适用于反序列化）
                        //            .addDeserializationExclusionStrategy(xxxx)
                        //            // 设置版本号，Gson将忽略所有高于此版本号的@Since注解和@Until注解的字段
                        //            .setVersion(1.0)
                        // 启用非基础类型 Map Key
                        .enableComplexMapKeySerialization()
                        // 默认情况下，Gson在序列化时会忽略值为null的字段。启用该设置后，Gson将包括值为null的字段
                        .serializeNulls()
                        // Gson将以更易读的格式输出JSON字符串，即格式化后的JSON，其中包含换行符和缩进。
                        .setPrettyPrinting()
                        .create();
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
