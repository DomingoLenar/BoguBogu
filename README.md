# Algorithm Analysis of Bubble, Selection, and Insertion Sorting Algorithm

## Bubble Sort

- [x] Best-Case Scenario //Compare elements but no swap
-  Time Complexity: O(n) 

- [ ] Average-Case Scenario
-  Time Complexity: #TODO 

- [x] Worst-Case Scenario
-  Time Complexity: O(n^2) <br/>

Solution: 
* Outer Loop: 1 + [(n-1) + 1] + (n - 1) = 2n
* Inner Loop: Consider all cases of the outer loop, thus, <br/>
> 1 + 2 + 3+...+(n-1) = x [times inner loop is executed]<br/>
> This is a series which is similar to Gauss sum of natural numbers, that is, <br/>
> * n(n+1)/2 <br/> 

> Relating the Gauss Formula to x, we have, <br>
> = (n - 1) (n - 1 + 1) / 2 <br>
> = n(n - 1) / 2 <br>

*Inner Loop Run Time*
* (n - 1) + (x + 1) + x
* x + x + x + x
> 6x + n 

> *Time Complexity T(n)* <br>
> Outer loop + Inner loop = 6x + 3n <br>
> Replace x with n since Time Complexity is in terms of n, <br>
> = 6(n(n - 1 ) / 2) + 3n <br>
> = 3n^2 <br>
> T(n) is O(n^2) <br>


## Selection Sort

- [ ] Best-Case Scenario 
-  Time Complexity: #TODO

- [ ] Average-Case Scenario
-  Time Complexity: #TODO

- [ ] Worst-Case Scenario
-  Time Complexity: #TODO


## Insertion Sort

- [ ] Best-Case Scenario
-  Time Complexity: #TODO

- [ ] Average-Case Scenario
-  Time Complexity: #TODO

- [ ] Worst-Case Scenario
-  Time Complexity: #TODO
