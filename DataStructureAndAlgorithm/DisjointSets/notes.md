# Disjoint Sets(并查集)
## 并查集的基本概念
- 概念：**并查集** 是一种树型的数据结构，用于处理一些不相交集的 **合并(union)** 及 **查询(find)** 问题
- 思想：用一个 *数组* 表示了整片森林(parent)，树的根节点(root)标识了一个集合，通过找到某个元素的根节点就可以确定它在哪个集合中。  
## 使用方法及其场景
- 场景：有N个元素的集合问题中。
- 方法：
  1. 先让每个元素构成一个单元素的集合
  2. 按一定顺序将属于同一个集合的元素合并
  3. 期间，要反复查找某个元素在哪个集合中

## Interface DisjointSets(并查集API)
- 并查集的两个基本操作
  1. void connect(int p, int q);连接两个元素
  2. boolean isConnected(int p, int q); 判断两个元素是否连接在一起
```java
public Interface DisjointSets {
    void connect(int p, int q);
    boolean isConnected(int p, int q);
}
```
- 如何储存元素所在集合的信息呢？可以通过一个数组来储存
## QuickFind(并查集快速查找)
时间复杂度分析：

|Implementation | constructor | conect | isConnected |
|--|--|--|--|
|QuickFindDS | Big-Theta(N) | Big-Theta(N) | Big-Theta(1) |

```java
public class QuickFindDS implements DisjointSets {
    private int[] id;
    
    public QuickFindDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
    //........
}
```
- 怎么减少connet所带来的开销？

## QuickUnion(并查集快速合并)
时间复杂度分析：

| Imlementation | Constructor | connect | isConnected |
|--|--|--|--|
| QuickUnion | Big-Theta(N) | Big-O(N) | Big-O(N) |

```java
public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
            return p;
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void connect(int p, int q) {
        int i = parent[p];
        int j = parent[q];

        parent[i] = j;
    }
    //......
}
```
- 当这个这颗树出现了一种极端情况时，时间复杂度任然会很高，该如何解决？

## WeightedQuickUnion(并查集size和rank优化)

| Imlementation | Constructor | connect | isConnected |
|--|--|--|--|
| WeightedQuickUnion | Big-Theta(N) | Big-O(logN) | Big-O(logN) |


## WeightedQuickUnionWithPathCompression(并查集路径压缩)
通过find(int val)在寻找一个元素的根节点的同时将每个遍历的元素的父节点更新为根节点

## 并查集的实际应用
并查集（Disjoint Set Union，简称 DSU 或 Union-Find）是一种非常高效的数据结构，广泛应用于处理动态连通性问题。以下是一些常见的实际应用场景：

### 1. 网络连接问题

**描述**：在网络中，判断两个节点（设备、计算机等）是否连通。

**应用场景**：检测网络中的设备是否在同一个子网中，网络故障检测等。

**示例**：
- 判断两个计算机是否在同一个局域网中。
- 通过合并操作模拟网络设备的连接。

### 2. 最小生成树（Minimum Spanning Tree）

**描述**：在加权图中，找到一棵包含所有顶点且边权重和最小的树。

**应用场景**：网络设计、道路建设、管道布线等。

**算法**：Kruskal 算法利用并查集来检测边的连接性，以避免环的形成。

**示例**：
- 通过最小生成树优化网络的铺设成本。
- 优化电力线路的架设方案。

### 3. 图的连通性问题

**描述**：判断图中的两个节点是否连通，以及检测图中的连通分量。

**应用场景**：社交网络分析、图的分割、区域划分等。

**示例**：
- 判断社交网络中两个人是否在同一个好友圈中。
- 检测地图中的独立区域。

### 4. 动态连通性问题

**描述**：实时处理节点的连通性变化，如新增连接或删除连接。

**应用场景**：实时网络监控、动态系统分析等。

**示例**：
- 实时监控电网的连通状态。
- 动态更新网络拓扑并检查连通性。

### 5. 图像处理

**描述**：在图像处理中，通过像素的连通性进行区域标记和分割。

**应用场景**：图像分割、物体检测等。

**示例**：
- 标记图像中的独立物体或区域。
- 处理二值图像中的连通分量。

### 6. 字符串合并问题

**描述**：将一组字符串根据某些合并规则进行分组。

**应用场景**：词典合并、数据清洗等。

**示例**：
- 合并具有相同根词的单词。
- 清洗数据库中的重复条目。

### 示例代码

以下是一个应用并查集解决图的连通性问题的示例代码：

```java
import java.util.*;

public class GraphConnectivity {
    public static void main(String[] args) {
        int n = 6; // 节点数
        int[][] edges = { {0, 1}, {1, 2}, {3, 4} }; // 边

        DisjointSet ds = new DisjointSet(n);
        for (int[] edge : edges) {
            ds.union(edge[0], edge[1]);
        }

        // 检查节点 0 和节点 2 是否连通
        System.out.println(ds.connected(0, 2)); // true

        // 检查节点 0 和节点 3 是否连通
        System.out.println(ds.connected(0, 3)); // false
    }
}

class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
```

### 其他应用场景

- **版图设计**：在 VLSI 电路设计中，用于检测电路网络的连通性。
- **协作过滤**：在推荐系统中，通过用户的相似性进行分组。
- **化学信息学**：在化学分子建模中，检测原子或分子是否连通。

通过这些实际应用，可以看出并查集是一种非常灵活和高效的数据结构，适用于各种需要处理动态连通性的问题。