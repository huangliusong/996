## 《告别996，开启Java高效编程之门》课程源代码

## 流是什么

> jdk1.8 引入都新成员，以声明式方式处理集合数据

> 将基础操作链接起来，完成复杂都数据处理流水线

> 提供透明都并行处理

从支持数据处理操作的源生成的元素序列---jdk8实战

### 流与集合的区别

1.时间与空间

2.只能遍历一次

3.外部迭代与内部迭代

### 流的组成
1.数据源 list

2.中间操作 filter——>sorted->map

3.终端操作 collect


### 流操作的分类
1.中间操作
    ｜-filter/map/peek等
    ｜-distinct/sorted/limit等

2.终端操作
    ｜-非短路操作：forEach/collect/count等
    ｜-短路操作：anyMatch/findFirst/findAny等