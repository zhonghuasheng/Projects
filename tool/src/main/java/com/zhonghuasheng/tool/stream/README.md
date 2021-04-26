### StreamUtil工具类
对StreamApi的封装。用来简化代码，省去繁琐的notNull、notEmpty判断，使代码远离NullPointExpcetion。返回值为集合时，绝不返回null，省去外部代码的非空判断
```java
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
```