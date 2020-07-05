## 第四周

#### 第9课 深度优先搜索和广度优先搜索

1. 深度优先搜索

   DFS代码-递归写法

   ```python
   visited = set()
   def dfs(node, visited): 
   	if node in visited: # terminator 
   		# already visited 
   		return   
   
   	visited.add(node)  
   	# process current node here. 
   	...
   	for next_node in node.children():  
   	if not next_node in visited:     
   		dfs(next_node, visited) 
   ```

   DFS代码-非递归写法

   ```python
   def DFS(self, tree):  
   	if tree.root is None:  
   		return []   
   	visited, stack = [], [tree.root] 
   	while stack:    
   		node = stack.pop()    
   		visited.add(node)   
   		process (node)    
   		nodes = generate_related_nodes(node)    
   		stack.push(nodes)  
   		
   		# other processing work 
   		...
   ```

   

2. 广度优先搜索

   BFS代码

   ```python
   def BFS(graph, start, end):  
   	queue = []   
   	queue.append([start])   
   	visited.add(start) 
   	while queue:    
   		node = queue.pop()    
   		visited.add(node)   
   		process(node)    
   		nodes = generate_related_nodes(node)    
   		queue.push(nodes) 
   		# other processing work 
   		...
   ```

   

#### 第10课 贪心算法（Greedy）

​		贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

​		贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

​		使用场景：

​		简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。 

​		贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。



#### 第12课 二分查找

前提：

​	目标函数单调性（单调递增或者递减）

​	存在上下界（bounded） 

​	能够通过索引访问（index accessible)



```python
left, right =0, len(array) -1
while left <= right:   
  mid = (left + right) /2
  if array[mid] == target:
    # find the target!!  
    break or return result     
  elif array[mid] < target:      
    left = mid +1
  else:      
    right = mid -1
```

