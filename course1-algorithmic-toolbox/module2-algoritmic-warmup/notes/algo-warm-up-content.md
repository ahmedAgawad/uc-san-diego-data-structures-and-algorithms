# Fibonacci Numbers :

## Naive Algo :

```md
if n ≤ 1:
return n
else:
return FibRecurs(n − 1) + FibRecurs(n − 2)
```

### Running time for Naive :

let T(n) denote the number of lines of code executed by FibRecurs(n)

if(n <= 1) --> it will execute 2 lines only   
else it will need --> 3 + T(n-1) + T(n-2)

to slow be cause of the recursice tree calls (even computed values will needed to be computed again each time)

## Efficient Algo :

```md
create an array F [0 . . . n]
F [0] ← 0
F [1] ← 1
for i from 2 to n:
F [i] ← F [i − 1] + F [i − 2]
return F [n]
```

### Running time for Efficient algo :

again lets suppose T(n) denote the number of lines of code executed by Fib(n)

**first :** execute **2 lines** to iniliaze index 0, 1  
**second :** needs to loop from 2 - n which is (n-1) time where each loop it will peform two tasks (checking for the loop condition & initiliaze index i) then it will 2*(n-1) then it will be **2n-2 lines  
third :** execute **1 line** to return value

T(n) : 2 + 2n-2 + 1 = 2n + 2

&nbsp;

# Greatest Common Divisors :

## Naive Algo :

```md
Function NaiveGCD(a, b)
best ← 0
for d from 1 to a + b:
  if d |a and d |b:
    best ← d
return best
```

### Runtime approx :

a + b

## Efficient Algo : Euclidean Algo

```md
Let a′ be the remainder when a is divided by
b, then
gcd(a, b) = gcd(a′, b) = gcd(b, a′).
```

```md
if b = 0:
return a
a′ ← the remainder when a is
divided by b
return EuclidGCD(b, a′)
```

### Runtime :

each step reduces the size of numbers by about a factor of 2 --> takes about log(ab) steps

# Computing runtimes

## Runtime Analysis :

if you have the number of lines that's needed to be executed does this number really describe the runtime of the algorithm ?

the answer it depends on a lot of factors including memory management system , speed of the computer, System architecture, compiler in use, Details of memory hierarchy --> huge mess

## Goals

```md
Measure runtime without knowing these
details.
Get results that work for large inputs.
```

### Computing Runtimes is a hard process :

- Depends on fine details of program
- Depends on details of the computer itself

# Asysmptotic Notation :

## Idea :

All these issues can mulitply runtimes by (large) constant --> we ignore these constants simply

"Asymptotic runtime" describes how the execution time of an algorithm increases as the size of its input (often denoted as n) grows very large. Instead of focusing on exact execution time (which depends on the machine and context), asymptotic analysis gives a general idea of how efficiently an algorithm performs, especially with large inputs.  
This is typically expressed using Big O notation, which provides an upper bound on growth.

### What BIG O represent :

it represent the **upper bound on growth (Worst case scenario)** for how the runtime of an algo grows as input size increases

### Practical meaning of worst case scenario :

1.  **Upper bound of growth :** big O describes the worst case runtime for large input size
    - ex : if algo has runime of O(n^2) then it will take **no more than c x (n^2) steps** for some constant c even if the actual runtime is sometimes faster Big O assures use it won't be slower than O(n^2)
2.  **Abstracting Away Details :** big O abstracts away **constants & less significant terms** focusing only on the most critical terms only (higher order)
    - ex : if an algo's runtime is 5n^2 + 3n + 10 we simply say O(n^2) ignoring constants and less significant terms
3.  **Comparing algos**

&nbsp;NOTES : log n ≺ √ n ≺ n ≺ n log n ≺ n^2 ≺ 2^n < !n

&nbsp;

## Definition of Big-O :

```md
f (n) = O(g (n)) (f is Big-O of g ) or f ⪯ g
if there exist constants N and c so that for
all n ≥ N, f (n) ≤ c · g (n). 
```

f is bounded above by some constant multiple of g .

### Growth Rate :

for example : 3n^2 + 5n + 2 has the same growth rate as n^2 so it's = O(n^2)

### Using Big - O advantages :

- Clarifies Growth Rate
- Cleans up Notation --> pick the worst

NOTE : Big-O is only asymptotic

&nbsp;

&nbsp;

## Using Big - O :

### Common Rules :

- constants can be omiited
- Drop lower terms
- Exponential Growth Dominates Polynomial Growth
- Logarithmic Growth is more slower than linear functions
- Factorials dominate exponentials and Polynomials


&nbsp;

# Levels of Algorithms Design :

## Levels of Design

Naive Algorithm: Definition to algorithm.   
      Slow.

Algorithm by way of standard Tools:  
      Standard techniques.

Optimized Algorithm: Improve existing  
       algorithm.

Magic Algorithm: Unique insight.

&nbsp;

# Some Math Notes :

## Log rules :

log<sub>a</sub>n<sup>k</sup> = k log<sub>a</sub>n   
log(ab) = log a + log b  
n<sup>log<sub>a</sub>b</sup> = b<sup>log<sub>a</sub>n</sup>     
log<sub>a</sub>n * log<sub>b</sub>a = log<sub>b</sub>n  
log<sub>a</sub>b = ln b / lna

log n ≺ √ n ≺ n ≺ n log n ≺ n^2 ≺ 2^n < !n

## Nice example :

5<sup>log<sub>2</sub></sup><sup>n</sup> = 5<sup>ln (n)/ln(2)</sup> = e<sup>ln5 * (ln(n)/ ln(2))</sup> = n<sup>ln5/ln2</sup> = n<sup>2.32</sup>