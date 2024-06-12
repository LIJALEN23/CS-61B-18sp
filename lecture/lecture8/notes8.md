# note7-1
## Asymptotic1
Asymptotic : Asymptotic analysis is a mathematical technique used for understanding the behavior of algorithms as their input increases. It uses asymptotic notations to describe the growth rate or time complexity of an algorithm, which allows us to compare different algorithms and understand how they perform in realistic scenarios.

渐进分析：渐近分析是一种数学技术，用于理解算法随着输入增加而表现的行为。它使用渐近符号来描述算法的增长率或时间复杂度，这使我们能够比较不同的算法并了解它们在现实场景中的表现。

即执行一段代码，不仅仅只考虑代码完成一个功能。而不能忽视为了完成这个功能，这段代码消耗了多少时间和空间

这一节就是学习如何分析代码的***时间复杂度***和***空间复杂度***

### 时间复杂度
计算算法的时间复杂度是一种分析和估算算法执行效率的方法。时间复杂度描述了随着输入规模的增加，算法运行时间如何增长。常见的时间复杂度表示包括O(1), O(log n), O(n), O(n log n), O(n^2), O(2^n), O(n!)等。下面是计算时间复杂度的一些基本步骤和方法：

#### 1. 基本操作的计数
首先，确定算法中的基本操作（如加法、赋值、比较等），并统计这些基本操作的执行次数。

#### 2. 循环结构分析
对循环结构进行分析：
- **单层循环**：如果循环执行n次，且每次循环的操作是O(1)，那么循环的时间复杂度是O(n)。
- **嵌套循环**：如果有两个嵌套的循环，每个循环执行n次，那么时间复杂度是O(n^2)。

#### 3. 递归结构分析
递归算法的时间复杂度通常通过递推关系式来求解。常用的方法是递归树或主定理。

#### 4. 分析条件分支
对条件分支进行分析，考虑最坏情况下每个分支的时间复杂度。

#### 5. 忽略常数项和低阶项
在大O表示法中，忽略常数项和低阶项，只保留最高阶的项。

#### 示例分析

##### 示例1：简单循环
```python
def example1(n):
    sum = 0
    for i in range(n):
        sum += i
    return sum
```
分析：循环执行n次，每次加法操作是O(1)，因此时间复杂度是O(n)。

##### 示例2：双层嵌套循环
```python
def example2(n):
    sum = 0
    for i in range(n):
        for j in range(n):
            sum += i * j
    return sum
```
分析：外层循环执行n次，内层循环也执行n次，每次乘法操作是O(1)，因此时间复杂度是O(n^2)。

##### 示例3：递归
```python
def example3(n):
    if n <= 1:
        return 1
    return example3(n-1) + example3(n-1)
```
分析：这个函数调用了两次`example3(n-1)`，所以递推关系式是T(n) = 2T(n-1) + O(1)。根据递归树分析，时间复杂度是O(2^n)。

#### 主定理（Master Theorem）
主定理用于解决形如 T(n) = aT(n/b) + f(n) 的递归关系。主定理的三种情况：
1. 如果f(n) = O(n^c)，且a > b^c，则 T(n) = O(n^log_b(a))。
2. 如果f(n) = O(n^c)，且a = b^c，则 T(n) = O(n^c log n)。
3. 如果f(n) = O(n^c)，且a < b^c，则 T(n) = O(f(n))。

通过以上方法和示例，可以计算出大多数常见算法的时间复杂度。实际分析中可能会遇到更复杂的情况，需要综合使用以上方法。

### 空间复杂度

空间复杂度分析是衡量算法在运行过程中使用的存储空间的量。它与时间复杂度相似，也是一种衡量算法效率的重要指标。空间复杂度主要关注的是算法在执行过程中所需的额外内存，包括变量、数据结构、递归调用栈等。以下是计算空间复杂度的一些基本步骤和方法：

#### 1. 基本变量的空间
首先，统计算法中使用的基本变量（如整数、浮点数、数组等）的空间。这些通常是常量空间，记为O(1)。

#### 2. 数组和容器
分析数组、列表、哈希表等数据结构的空间占用：
- **一维数组**：如果数组长度为n，空间复杂度为O(n)。
- **二维数组**：如果数组大小为n x m，空间复杂度为O(n * m)。

#### 3. 递归空间
递归算法会占用递归调用栈的空间。递归的深度是影响空间复杂度的主要因素。

#### 4. 动态分配空间
分析动态分配的数据结构（如链表、树等）所占用的空间。

#### 5. 临时空间
统计算法运行过程中临时变量和辅助数据结构所占用的空间。

#### 示例分析

##### 示例1：简单变量
```python
def example1(n):
    sum = 0
    for i in range(n):
        sum += i
    return sum
```
分析：`sum`和`i`是常量空间，占用O(1)的空间。因此，空间复杂度是O(1)。

##### 示例2：数组
```python
def example2(n):
    arr = [0] * n
    for i in range(n):
        arr[i] = i
    return arr
```
分析：数组`arr`占用了n个元素的空间，因此空间复杂度是O(n)。

##### 示例3：递归
```python
def example3(n):
    if n <= 1:
        return 1
    return example3(n-1) + example3(n-1)
```
分析：每次递归调用都需要在栈上保存当前函数的执行环境。递归深度是n，所以空间复杂度是O(n)。

#### 主定理（Master Theorem）在空间复杂度中的应用
主定理一般用于时间复杂度分析，但在递归算法的空间复杂度分析中也有帮助。例如，对于递归关系T(n) = aT(n/b) + f(n)，可以分析每次递归调用的空间分配情况。

#### 实际案例
##### 示例4：快速排序（Quicksort）
```python
def quicksort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quicksort(left) + middle + quicksort(right)
```
分析：快速排序使用了递归调用栈空间。在最坏情况下（每次都选到最小或最大元素为pivot），递归深度为n，因此空间复杂度为O(n)。在平均情况下，递归深度为log n，空间复杂度为O(log n)。此外，构建`left`、`middle`和`right`数组也需要额外的O(n)空间。

#### 总结
空间复杂度分析需要综合考虑基本变量、数据结构、递归调用栈和临时空间的占用情况。常见的空间复杂度有O(1), O(log n), O(n), O(n log n), O(n^2)等。在实际分析中，需要具体问题具体分析，根据算法的结构和实现方式来确定其空间复杂度。

# note7-2
## Asymptotic2
### *如何进行算法分析* ： 将时间消耗的和式列出来，再进行求和。
### 二分查找
### 归并排序(N * logN)


# note7-3
## Asymptotic3
#### Big-Theta and Big-O
在算法分析中，Big-Theta (Θ)、Big-O (O) 和 Big-Omega (Ω) 是三种用于描述算法复杂度的符号，它们分别表示算法在最坏情况下、最优情况下和平均情况下的性能。具体定义如下：

#### 1. **Big-O (O)**
Big-O 表示算法在最坏情况下的上界，即算法在最差情况下所需要的时间或空间的增长速度。

**定义**：
对于函数 \( f(n) \) 和 \( g(n) \)，如果存在正数常数 \( c \) 和 \( n_0 \)，使得对于所有 \( n \geq n_0 \)，都满足 \( f(n) \leq c \cdot g(n) \)，那么 \( f(n) \) 是 \( O(g(n)) \) 的。

**数学表示**：
\[ f(n) = O(g(n)) \]
表示存在正数常数 \( c \) 和 \( n_0 \)，使得对于所有 \( n \geq n_0 \)，都有
\[ f(n) \leq c \cdot g(n) \]

#### 2. **Big-Omega (Ω)**
Big-Omega 表示算法在最优情况下的下界，即算法在最理想情况下所需要的最少时间或空间的增长速度。

**定义**：
对于函数 \( f(n) \) 和 \( g(n) \)，如果存在正数常数 \( c \) 和 \( n_0 \)，使得对于所有 \( n \geq n_0 \)，都满足 \( f(n) \geq c \cdot g(n) \)，那么 \( f(n) \) 是 \( \Omega(g(n)) \) 的。

**数学表示**：
\[ f(n) = \Omega(g(n)) \]
表示存在正数常数 \( c \) 和 \( n_0 \)，使得对于所有 \( n \geq n_0 \)，都有
\[ f(n) \geq c \cdot g(n) \]

#### 3. **Big-Theta (Θ)**
Big-Theta 表示算法的精确增长率，即算法在最坏和最优情况下的时间或空间增长速度都在某个范围内。

**定义**：
对于函数 \( f(n) \) 和 \( g(n) \)，如果存在正数常数 \( c_1 \)、\( c_2 \) 和 \( n_0 \)，使得对于所有 \( n \geq n_0 \)，都满足 \( c_1 \cdot g(n) \leq f(n) \leq c_2 \cdot g(n) \)，那么 \( f(n) \) 是 \( \Theta(g(n)) \) 的。

**数学表示**：
\[ f(n) = \Theta(g(n)) \]
表示存在正数常数 \( c_1 \)、\( c_2 \) 和 \( n_0 \)，使得对于所有 \( n \geq n_0 \)，都有
\[ c_1 \cdot g(n) \leq f(n) \leq c_2 \cdot g(n) \]

#### 举例说明
假设我们有一个函数 \( f(n) = 3n^2 + 2n + 1 \)。

- **Big-O**：考虑最高阶项，即 \( f(n) \) 在最坏情况下的上界是 \( O(n^2) \)，因为 \( 3n^2 + 2n + 1 \leq c \cdot n^2 \) 对于某个常数 \( c \) 以及足够大的 \( n \) 成立。

- **Big-Omega**：考虑最低阶项，即 \( f(n) \) 在最优情况下的下界是 \( \Omega(n^2) \)，因为 \( 3n^2 + 2n + 1 \geq c \cdot n^2 \) 对于某个常数 \( c \) 以及足够大的 \( n \) 成立。

- **Big-Theta**：因为 \( f(n) \) 的增长率精确是 \( n^2 \) 量级，即 \( 3n^2 + 2n + 1 \) 同时被 \( n^2 \) 的上界和下界夹住，所以 \( f(n) = \Theta(n^2) \)。

通过这些符号，我们可以更准确地描述和比较算法的效率。