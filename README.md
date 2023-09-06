# Algorithm Analysis of Bubble, Selection, and Insertion Sorting Algorithm

## Bubble Sort
//Note: bubbles up the elements by swap and compare

- [x] Best-Case Scenario //Compare elements but no swap
-  Time Complexity: O(n) 

- [x] Average-Case Scenario
-  Time Complexity: O(n^2) <br/> 
> The amount of swapping depends on the elements of an array, thus we use the concept of probability (i.e., expected value formula),<br>
> E[x] = sum of possibilities * likelihood to occur <br>
> E[x] = (0 + 1) * 1/2 = 1/2 <br>

> Average-case and Worst-case are the same however the main difference is that; worst-case we always swap; in average-case
> it depends on how sorted the array, therefore,
> > *Time Complexity T(n)* <br>
> Expected value * [Outer loop + Inner loop] = 1/2*(6x + 3n) <br>
> Replace x with n since Time Complexity is in terms of n, <br>
> = 1/2*(6(n(n - 1 ) / 2) + 3n) <br>
> = 1/2*(3n^2) <br>
> = 3n^2/2 <br>
> T(n) is O(n^2) <br>

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
//Note: swap and compare in efficient action 

- [x] Best-Case Scenario // No swapping and assigning value to var
-  Time Complexity: O(n)

- [x] Average-Case Scenario
-  Time Complexity: #TODO

Solution: Use the concept of probability (i.e., expected value formula),<br>
> E[x] = sum of possibilities * likelihood to occur <br>
> E[x] = (0 + 1) * 1/2 = 1/2 <br>

> > *Time Complexity T(n)* <br>
> Expected value * [Outer loop + Inner loop] = 1/2(4 ((n^2 - n) / 2) + 7n) <br>
> Replace x with n since Time Complexity is in terms of n, <br>
> = 1/2(2n^2 + 5n) <br>
> = n^2 + 5n/2 <br>
> T(n) is O(n^2) <br>

- [x] Worst-Case Scenario
-  Time Complexity: O(n^2)

Solution:
* Outer loop: 1 + n + n - 1 
* Body of Outer loop: n - 1 + n - 1 + n + n + n 
> equal to 7n
* Inner Loop: Consider all cases of the outer loop, thus, <br/>
> Relating the Gauss Formula to x, we have, <br>
> = (n - 1) (n - 1 + 1) / 2 <br>
> = n(n - 1) / 2 <br>
* Inner loop: 1 + x + x - 1
* Body of Inner loop: x + x
> equal to 4x 

*Time Complexity T(n)* <br>
> Outer loop + Inner loop = 4x + 7n <br>
> Replace x with n since Time Complexity is in terms of n, <br>
> = 4(n^2 - n / 2) + 7n <br>
> = 2n^2 + 5n <br>
> T(n) is O(n^2) <br>


## Insertion Sort
//Note: slowly shift/move elements in array (build-up) -> grows the sorting process of elements

- [x] Best-Case Scenario // Linear
-  Time Complexity: O(n)

Solution:
* Outer loop: 1 + n + n - 1 = 2n
* Body of Outer loop: 3(n-1) = 3n - 3 
* Inner loop: 3(n-1) = 3n - 3 <br>

*Time Complexity T(n)* <br>
> Outer loop + Inner loop = 2n + 3n - 3 + 3n - 3 <br>
> = 8n - 6 <br>
> T(n) is O(n) <br>

- [ ] Average-Case Scenario
-  Time Complexity: O(n^2)

- [ ] Worst-Case Scenario
-  Time Complexity: O(n^2)
