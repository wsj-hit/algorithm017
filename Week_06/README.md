学习笔记

1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解为可重复解决的问题（面试一般都有解）
3. 数学归纳法思维（抵制人肉递归的诱惑） 本质：寻找重复性 人肉递归可以将递归状态树画出来

动态规划关键点 
1.最优子结构opt[n]=best_of(opt[n-1],opt[n-2],...) 
2.储存中间状态：opt[i] 
3.递推公式
```java
public void recur(int level, int param) { 
    //terminator 
    if (level > MAX_LEVEL) { 
        process result return; 
    } 
    //  process current logic 
    process(level, param);
     // drill down recur( level: level + 1, newParam);
     // restore current status

}
```