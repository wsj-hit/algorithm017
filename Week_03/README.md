学习笔记

递归模板
```
    
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
 
}

```

###不要人肉递归
###找最近重复子问题
回溯法尝试分步解决一个问题，当其尝试发现现有的分步答案不能得到有效的正确的解答的时候，将取消上几步的计算，再通过其他可能的分步解答再次尝试寻找问题的答案