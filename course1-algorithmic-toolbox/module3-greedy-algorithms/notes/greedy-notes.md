# Intro :

Algorithmic strategy that bulids a solution piece by piece always choosing the next piece that offers the most immediate benefit or "greedily" picks the best option at each step. the main idea is to make sequence of choices at hope that will lead to optimal solution at the end

- **Local optimal solution :** the optimal solution to pick at each step (changes at each step) and without considering future choices
- **Global optimal solution :** for the greedy algo to work the problem must have a general choice with specific constraints that is applied to each step to give you the local optimal solution (not all problem suitable for this)

## General Greedy Strategy :

1.  find local optimal solution
2.  do something with it
3.  remove the optimal from the data
4.  repeat for the smaller problem [sub smaller]

## Car Fueling problem :

```md
Input: A car which can travel at most L
kilometers with full tank, a source
point A, a destination point B and
n gas stations at distances
x1 ≤ x2 ≤ x3 ≤ · · · ≤ xn in
kilometers from A along the path
from A to B.

Output: The minimum number of refills to
get from A to B, besides refill at A.
```

### Solving strategy :

- Make some greedy choice
- Reduce to a smaller problem
- iterate

### Greedy Choice :

```md
Refill at the farthest reachable gas station
```

### Greedy Algorithm :

1.  Start at A
2.  Refill at the fathest reachable gas station G
3.  Make G the new A
4.  Get from new A to B with minimum number of refills

### The subproblem :

```md
Min number of refills from A to B --> main problem   
== refill at farthest station G + subproblem(min number of refiils from G to B)
```

### Algorithm :

```md
numRefills ← 0, currentRefill ← 0

while currentRefill ≤ n:
lastRefill ← currentRefill

while (currentRefill ≤ n and
x[currentRefill + 1] − x[lastRefill] ≤ L):
currentRefill ← currentRefill + 1

if currentRefill == lastRefill:
return IMPOSSIBLE

if currentRefill ≤ n:
numRefills ← numRefills + 1

return numRefills
```

# Grouping Children :

## Problem statement :

Many children came to a celebration. Organize them into the minimum possible number of groups such that the age of any two children in the same group differ by at most one year.

## Efficient Algo :

imagine the student ages as a number line where each student age is xi , .... , xn we want to draw lines over the great line representing the minimum number of groups to make where each group max and min difference is 1 at most [we should cover all points on the line with minimum number of segments]

**Safe move :** cover the leftmost point with a unit segment which starts in this point   
**subproblem :** do the same for the right of the first point covering uncoverd points 

### Algorithm pesudocode :

```md
R ← {}, i ← 1
while i ≤ n:
  [ℓ, r ] ← [xi , xi + 1]

  R ← R ⋃︀ {[ℓ, r ]}
  i ← i +1

  while i ≤ n and xi ≤ r :
  i ←i +1

return R
```

running time is o(n)

# Fractional Knapsack :

## Problem Statement :

you want to take weights of different portions to give you the highest value where each portion has a value [money] and weight and you have a capacity max of W 

**Input :** Weights w1, .., wn and values v1, ..., vn of n items; Capacity W  
**Output :** max total value of fractions of itmes that fit into bag of capacity W 

## Efficient Algo :

uses as much as possible of an item with maximal value per unit of weight 

## Algo explantion and psuedocode :

- while knapsack is not full 
- choose item i with max vi/wi
- if item fits into kanpsack, take all of it
- else take as much as to fill the knapsack
- return total value and amounts taken

```md
Knapsack(W , w1, v1, . . . , wn , vn )

A ← [0, 0, . . . , 0], V ← 0

repeat n times:
 if W = 0:
 return (V , A)

 select i with wi > 0 and max vi/wi --> call other function method maybe 
 a ← min(wi , W )
 V ← V + a wvii
 wi ← wi − a, A[i] ← A[i] + a, W ← W − a

 return (V , A)
```

inner loop to select item with max vi/wi loop O(n) and outer loop is O(n) then overall O(n^2)

### Possible optimization :

sort them first before performing algo according to vi/wi with max at first --> O(n log n)

# Greedy Algorithms Review :

## Main ingredients :

- Safe move
- Prove safety of the move
- solve subproblem 
- Estimate running time 
- Space for optimization --> sort data

&nbsp;
