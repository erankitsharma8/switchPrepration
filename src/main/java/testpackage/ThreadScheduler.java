package testpackage;

/*
Thread scheduling - There are N threads numbered 0 to N - 1.
A thread can be dependent on one or more threads to be executed.
Given an array dependencies where dependencies[i] = [t1, t2] indicates that thread t2 must be completed before t1 starts execution.
 Return true if all threads can be executed.


Input - N = 2, dependencies[][] = [[0, 1]]

Output = true

Input - N = 4, dependencies[][] = [[0, 1][0, 2][0, 3]]  // [1,4]

Output = true

Input - N = 3, dependencies[][] = [[0, 1][1, 2][2, 0]]

0-> 1,2,3  -> 4,2,3.
1-> 4

0->0
1->2
2->0
Map O(N)
N+(M*N)

Output = false

[0,1,2
 1,2,0]

 0 -> 1 -> 2 -> 0
 0->1->




[0 0 0
 1 2 3]

 */



public class ThreadScheduler {
}
