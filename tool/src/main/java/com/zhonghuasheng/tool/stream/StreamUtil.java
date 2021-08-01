package com.zhonghuasheng.tool.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamUtil {

    private static <T, K, V, C extends Collection<V>> Map<K, C> groupingBy(
            List<T> dataList,
            Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends V> valueMapper,
            Supplier<C> supplier) {

        if (DataUtil.isEmpty(dataList)) {
            return Collections.emptyMap();
        }

        if (Objects.isNull(valueMapper)) {
            valueMapper =  t -> (V) t;
        }

        return dataList.stream().collect(Collectors.groupingBy(keyMapper,
                Collectors.mapping(valueMapper, Collectors.toCollection(supplier))));
    }

    /**
     * 按指定key分组为list
     * @param dataList 待分组列表
     * @param keyMapper key映射
     * @param <T> 列表泛型
     * @param <K> key泛型
     * @return Map<K, List<T>>
     */
    public static <T, K> Map<K, List<T>> groupingToList(List<T> dataList, Function<? super T, ? extends K> keyMapper){
        return groupingBy(dataList, keyMapper, null, ArrayList::new);
    }

    /**
     * 按指定key分组为list
     * @param dataList 待分组列表
     * @param keyMapper key映射
     * @param valueMapper value映射
     * @param <T> 列表泛型
     * @param <K> key泛型
     * @param <V> 分组后的value泛型
     * @return Map<K, List<T>>
     */
    public static <T, K, V> Map<K, List<V>> groupingToList(List<T> dataList, Function<? super T, ? extends K> keyMapper
            ,Function<? super T, ? extends V> valueMapper) {
        return groupingBy(dataList, keyMapper, valueMapper, ArrayList::new);
    }

    /**
     * 按指定key分组为set
     */
    public static <T, K, V> Map<K, Set<V>> groupingToSet(List<T> dataList, Function<? super T, ? extends K> keyMapper
            ,Function<? super T, ? extends V> valueMapper) {
        return groupingBy(dataList, keyMapper, valueMapper, HashSet::new);
    }

    public static <T, K> Map<K, Set<T>> groupingToSet(List<T> dataList, Function<? super T, ? extends K> keyMapper) {
        return groupingBy(dataList, keyMapper, null, HashSet::new);
    }

    private static <T, R, C extends Collection<T>, Result extends Collection<R>> Result
    fetchCollection(C data, Function<? super T, ? extends R> fieldMapper, Supplier<Result> supplier) {
        if (DataUtil.isEmpty(data)) {
            return supplier.get();
        }
        return data.stream().map(fieldMapper).collect(Collectors.toCollection(supplier));
    }

    private static <T, R, Result extends Collection<R>> Result
    fetchCollection(T[] data, Function<? super T, ? extends R> fieldMapper, Supplier<Result> supplier) {
        if (DataUtil.isEmpty(data)) {
            return supplier.get();
        }
        return Arrays.stream(data).map(fieldMapper).collect(Collectors.toCollection(supplier));
    }

    /**
     * 将dataList映射为自定义的list
     */
    public static <T, R ,C extends Collection<T>> List<R> fetchList(C data, Function<? super T, ? extends R> fieldMapper) {
        return fetchCollection(data, fieldMapper, ArrayList::new);
    }

    public static <T, R> List<R> fetchList(T[] data, Function<? super T, ? extends R> fieldMapper) {
        return fetchCollection(data, fieldMapper, ArrayList::new);
    }

    /**
     * 将dataList映射为自定义的set
     */
    public static <T, R> Set<R> fetchSet(T[] data, Function<? super T, ? extends R> fieldMapper) {
        return fetchCollection(data, fieldMapper, HashSet::new);
    }

    public static <T, R ,C extends Collection<T>> Set<R> fetchSet(C data, Function<? super T, ? extends R> fieldMapper) {
        return fetchCollection(data, fieldMapper, HashSet::new);
    }

    /**
     * list to map
     */
    public static <T, K, V ,C extends Collection<T>> Map<K, V> map(C data, Function<? super T, ? extends K> keyMapper
            , Function<? super T, ? extends V> valueMapper) {
        if (DataUtil.isEmpty(data)) {
            return Collections.emptyMap();
        }

        if (Objects.isNull(valueMapper)) {
            valueMapper = t -> (V) t;
        }

        return data.stream().collect(Collectors.toMap(keyMapper, valueMapper, (oldData, newData) -> newData));
    }


    public static <T, K,C extends Collection<T>> Map<K, T> map(C data, Function<? super T, ? extends K> keyMapper) {
        return map(data, keyMapper, null);
    }

    /**
     * array to map
     */
    public static <T, K, V> Map<K, V> map(T[] arr, Function<? super T, ? extends K> keyMapper
            ,Function<? super T, ? extends V> valueMapper) {

        if (DataUtil.isEmpty(arr)) {
            return Collections.emptyMap();
        }

        if (Objects.isNull(valueMapper)) {
            valueMapper = t -> (V) t;
        }

        return Arrays.stream(arr).collect(Collectors.toMap(keyMapper, valueMapper, (oldData, newData) -> newData));
    }

    public static <T, K> Map<K, T> map(T[] arr, Function<? super T, ? extends K> keyMapper) {
        return map(arr, keyMapper, null);
    }

    private static <T, C extends Collection<T>> C stringToCollection(String source, String divider, Function<? super String, ? extends T> keyMapper, Supplier<C> supplier) {
        if (DataUtil.isNotEmpty(source) && DataUtil.isNotEmpty(divider)) {
            if (DataUtil.isNotEmpty(divider)) {
                source = trim(source, divider);
            }

            return Arrays.stream(source.split(divider)).filter(DataUtil::isNotEmpty).map(keyMapper).collect(Collectors.toCollection(supplier));
        }
        return supplier.get();
    }

    /**
     * 将字符串按指定分隔符分割为多个字符串
     * @param source 待分隔的字符串
     * @param divider 分隔符
     * @return 分割后的list
     */
    public static List<String> stringToList(String source, String divider){
        return stringToCollection(source, divider, t ->  t, ArrayList::new);
    }

    /**
     * 将字符串按指定分隔符分割为自定义类型的list
     * @param source 待分隔的字符串
     * @param divider 分隔符
     * @param keyMapper 分割后的字符映射
     * @param <T> 分割及映射后的泛型
     * @return List<T>
     */
    public static <T> List<T> stringToList(String source, String divider, Function<? super String, ? extends T> keyMapper) {
        return stringToCollection(source, divider, keyMapper, ArrayList::new);
    }

    /**
     * string to set
     */
    public static Set<String> stringToSet(String source, String divider){
        return stringToCollection(source, divider, t -> t, HashSet::new);
    }

    public static <T> Set<T> stringToSet(String source, String divider, Function<? super String, ? extends T> keyMapper) {
        return stringToCollection(source, divider, keyMapper , HashSet::new);
    }

    /**
     * 去掉字符串首尾多余的分隔符
     */
    private static String trim(String source, String divider) {
        if (source.startsWith(divider)) {
            source = source.substring(divider.length());
        }

        if (source.endsWith(divider)) {
            source = source.substring(0, source.length() - divider.length());
        }
        return source;
    }

    /**
     * 将<T>的某种映射按指定分隔符组装成字符串
     */
    public static <T, R> String listToString(List<T> source, String divider, Function<? super T, ? extends R> keyMapper) {
        if (DataUtil.isNotEmpty(source)) {
            String result = source.stream().map(keyMapper).filter(Objects::nonNull).map(String::valueOf).filter(DataUtil::isNotEmpty).reduce("", (a, b) -> a + divider + b);
            return trim(result, divider);
        }
        return "";
    }

    public static <T, C extends Collection<T>> T findFirst(C data) {
        if (DataUtil.isEmpty(data)) {
            return null;
        }
        return data.stream().findFirst().get();
    }

    public static <T, C extends Collection<T>> void forEach(C data, Consumer<? super T> action) {
        if (DataUtil.isNotEmpty(data)) {
            data.stream().filter(DataUtil::isNotNull).forEach(action);
        }
    }

    @SafeVarargs
    private static <T, C extends Collection<T>> C asCollection(Supplier<C> supplier, T... data) {
        if (DataUtil.isNotEmpty(data)) {
            return fetchCollection(data, t -> t, supplier);
        }
        return supplier.get();
    }

    @SafeVarargs
    public static <T> Set<T> asSet(T... data) {
        return asCollection(HashSet::new, data);
    }

    @SafeVarargs
    public static <T> List<T> asList(T... data) {
        return asCollection(ArrayList::new, data);
    }
}
