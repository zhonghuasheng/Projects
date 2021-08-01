package com.zhonghuasheng.tool.stream;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class DataUtil {

        public static final Integer ZERO = 0;

        public static <T, C extends Collection<T>> boolean isEmpty(C data) {
                return Objects.isNull(data) || ZERO.equals(data.size());
        }

        public static <T> boolean isEmpty(T[] data) {
                return Objects.isNull(data) || ZERO.equals(data.length);
        }

        public static <K, V, M extends Map<K, V>> boolean isEmpty(M data) {
                return Objects.isNull(data) || ZERO.equals(data.size());
        }

        public static boolean isEmpty(String data) {
                return Objects.isNull(data) || data.isEmpty();
        }

        public static <T, C extends Collection<T>> boolean isNotEmpty(C data) {
                return !isEmpty(data);
        }

        public static <T> boolean isNotEmpty(T[] data) {
                return !isEmpty(data);
        }

        public static <K, V, M extends Map<K, V>> boolean isNotEmpty(M data) {
                return !isEmpty(data);
        }

        public static boolean isNotEmpty(String data) {
                return !isEmpty(data);
        }

        public static <T> boolean isNull(T data) {
                return data == null;
        }

        public static <T> boolean isNotNull(T data) {
                return !isNull(data);
        }
}
