package com.zhonghuasheng.tool.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamUtilTest {

    public static void main(String[] args) {
        // 构建List数据
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(Long.valueOf(String.valueOf(i)), "name" + i, i);
            users.add(user);
        }

        // StreamUtil可避免NPE问题，无需每次判断users是否为null
        // 组装单个属性成List
        List<Integer> ages = StreamUtil.fetchList(users, User::getAge);
        // --- 使用原生写法如下
        List<Integer> ages2 = users.stream().map(User::getAge).collect(Collectors.toList());
        // 组装单个属性成Set
        Set<Integer> ageSet = StreamUtil.fetchSet(users, User::getAge);
        // --- 使用原生写法如下
        Set<Integer> ageSet2 = users.stream().map(User::getAge).collect(Collectors.toSet());
        // 组装两个属性成Map
        Map<Long, String> userIdNameMaps = StreamUtil.map(users, User::getId, User::getName);
        // --- 使用原生写法如下
        Map<Long, String> userIdNameMaps2 = users.stream().collect(Collectors.toMap(User::getId, User::getName));
        // 组装key和对象成map
        Map<Long, User> usermaps = StreamUtil.map(users, User::getId);
        // --- 使用原生写法如下
        Map<Long, User> usermaps2 = users.stream().collect(Collectors.toMap(User::getId, t -> (User) t, (oldData, newData) -> newData));
        // 分组
        users.add(new User(11L, "test1", 1));
        users.add(new User(12L, "test2", 2));
        users.add(new User(13L, "test3", 3));
        Map<Integer, List<User>> ageGroup = StreamUtil.groupingToList(users, User::getAge);
        // --- 使用原生写法如下
        Map<Integer, List<User>> ageGroups2 = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println("DONE");
    }
}
