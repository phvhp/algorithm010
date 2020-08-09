## 第九周

#### 第19课 高级动态规划

递归

```java
public void recur(int level, int param) {
    //terminator
    if (level > MAX_LEVEL) {
        //process result
        return;
    }

    //process current logic
    process(level, param);

    //drill down
    recur(level: level + 1, newParam);

    // restore current status
}
```



分治代码模板

```python
def divide_conquer(problem, param1, param2, ...) :
    # recursion terminator
    if problem is None:
        print_result
        return

    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)


    # conquer subproblems
    subresult1 = self.divide_conquer(subproblem[0], p1, ...)
    subresult2 = self.divide_conquer(subproblem[1], p1, ...)
    subresult3 = self.divide_conquer(subproblem[2], p1, ...)
    
    ...

    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)

    # revert the current level states
```



DP顺推模板

```javascript
function DP():
        dp = [][] # ⼆维情况
        for i = 0 .. M {
        for j = 0 .. N {
        dp[i][j] = _Function(dp[i’][j’]…)
        }
        }
    return dp[M][N];
```





动态规划 和 递归 或者分治 没有根本上的区别 (关键看有无最优子结构)

拥有共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解



#### 第20课 字符串算法

String x = "abbc";

遍历

```java
String x = "abbc";
for (int i = 0; i < x.size(); ++i) {
    char ch = x.charAt(i);
}
for ch in x.toCharArray() {
    System.out.println(ch);
}
```



比较

```java
String x = "abb";

String y = "abb";

x == y --> false

x.equals(y) --> true

x.equalsIgnoreCase(y) --> true
```



atoi

```java
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    // 1. Empty string

    if(str.length() == 0) return 0;

    // 2. Remove Spaces
    while(str.charAt(index) == '' && index < str.length())
        index++;

    // 3. Handle signs
    if (str.charAt(index) == '+' || str.charAt(index) == '-') {
        sign = str.charAt(index) == '+'?1:-1;
        index++;
    }

    // 4. Convert number and avoid overflow

    while(index < str.length() ) {
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;

        // check if total will be overflow after 10 times and add digit
        if(Integer.MAX_VALUE / 10 < total ||
           Integer.MAX_VALUE / 10 == tatal && Integer.MAX_VLAUE % 10 < digit
        )
            return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE:

        total = 10 * total + digit;

        index++;


    }

    return total * sign;
}
```

```python
class Solution(object):

	def myAtoi(self, s):

		 if len(s) == 0 : return 0
		 ls = list(s.strip())

		 sign = -1 if ls[0] == '-' else 1
		 if ls[0] in ['-','+'] : del ls[0]

 		ret, i = 0, 0
		while i < len(ls) and ls[i].isdigit() :
			 ret = ret*10 + ord(ls[i]) - ord('0')
 			 i += 1
		return max(-2**31, min(sign * ret,2**31-1))
```



