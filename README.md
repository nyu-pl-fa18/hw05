# Homework 5 (20 Points + 5 Bonus Points)

The deadline for Homework 5 is Saturday, October 13, 6pm. The late
submission deadline is Thursday, October 18, 6pm.

## Getting the code template

Before you perform the next steps, you first need to create your own
private copy of this git repository. To do so, click on the link
provided in the announcement of this homework assignment on
Piazza. After clicking on the link, you will receive an email from
GitHub, when your copy of the repository is ready. It will be
available at
`https://github.com/nyu-pl-fa18/hw05-<YOUR-GITHUB-USERNAME>`.  
Note that this may take a few minutes.

* Open a browser at `https://github.com/nyu-pl-fa18/hw05-<YOUR-GITHUB-USERNAME>` with your Github username inserted at the appropriate place in the URL.
* Choose a place on your computer for your homework assignments to reside and open a terminal to that location.
* Execute the following git command: <br/>
  ```git clone https://github.com/nyu-pl-fa18/hw05-<YOUR-GITHUB-USERNAME>.git```<br/>
  ```cd hw05```

Put your answers to problems 1-3 into the text file `solution.md`.
The code template for solving Problem 4 is provided in the file

```
src/main/scala/pl/hw05/hw05.scala
```

relative to the root directory of the repository. Follow the
instructions in the notes for Class 2 to import the project into
InteliJ (or use your other favorite IDE or editor to work on the assignment).


## Submitting your solution

Once you have completed the assignment, you can submit your solution
by pushing the modified code template to GitHub. This can be done by
opening a terminal in the project's root directory and executing the
following commands:

```bash
git add .
git commit -m "solution"
git push
```

You can replace "solution" by a more meaningful commit message.

Refresh your browser window pointing at
```
https://github.com/nyu-pl-fa18/hw05-<YOUR-GITHUB-USERNAME>/
```
and double-check that your solution has been uploaded correctly.

You can resubmit an updated solution anytime by reexecuting the above
git commands. Though, please remember the rules for submitting
solutions after the homework deadline has passed.


## Problem 1: Tail Recursion in Scala (4 Points)

Write a Scala function

```scala
def binom(n: Int, k: Int): Int
```

that computes the binomial coefficient of two natural numbers `n` and `k`. Recall that for <img style="margin-bottom:-3px" src="http://latex.codecogs.com/svg.latex?n,k\in\mathbb{N}" border="0"/>, the binomial coefficient  <img src="http://latex.codecogs.com/svg.latex?\binom{n}{k}" border="0"/> is defined as:

<img src="http://latex.codecogs.com/svg.latex?\binom{n}{0}=1" border="0"/> and

<img src="http://latex.codecogs.com/svg.latex?\binom{n}{k}=\binom{n-1}{k-1}+\binom{n-1}{k}" border="0"/> 

for <img src="http://latex.codecogs.com/svg.latex?n,k%20%3E%200" border="0"/>

Your implementation should use recursion instead of loops but still
run in constant stack space. Feel free to introduce a tail-recursive
helper function for the actual computation.

Hints

1. A useful trick is to consider the following multiplicative identity
   of binomial coefficients for your implementation instead of the
   additive identity given above:

   <img src="http://latex.codecogs.com/svg.latex?\binom{n}{k}=\frac{n\binom{n-1}{k-1}}{k}" border="0"/>
   for <img src="http://latex.codecogs.com/svg.latex?n,k%20%3E%200" border=0"/>

   Though, be careful not to introduce rounding errors.

2. If you are unsure about whether your helper function is
   tail-recursive, you can prepend the `def` keyword with the
   `@tailrec` annotation. This will cause the Scala compiler to issue
   a warning if it cannot perform tail-call elimination on your
   function.

## Problem 2: Lambda Calculus (4 Points)

1. Consider the lambda term

   *t =*
   
   a. Consistently rename all variables bound in *t* using -renaming
      such that they are unique.
   
   b. Calculate the set of free variables appearing in *t*.
   

2. Using the definitions from class, compute the normal form of the
   following lambda term (show all -reduction steps)

   *`iszero` (`mult` `0` `2`)*

## Problem 3: Scheme Programming (12 Points)



## Problem 4: Lambda Lists (Optional, 5 Bonus Points)

Lists are an important data structure. Scheme therefore provides an
inbuilt list data type.  However, from a theoretical point the list
type is redundant because, just like numbers and Booleans, lists can
be encoded directly in the untyped lambda calculus.

A list can be represented in the lambda calculus by its *fold*
function. For example, the list *`(list a b c)` becomes a function
that takes two arguments *f* and *z* and returns *f a (f b (f c
z))*. Now, if one want to implement, e.g., a function that sums up all
the elements in a list *xs* containing Church numerals, this can be
done as follows:

*`sum` = λ xs. xs `plus` `0`*

1. Write a lambda term `nil` that represents the empty list `()`.

2. Write a lambda term `cons` that takes an element *hd* and a list
   *tl* (represented as a fold function) and returns a list formed by
   prepending *hd* on *tl*.
   
3. Write a lambda term `isnil` that takes a list *xs* and returns
   `true` if *xs* is the empty list and `false` otherwise.
   
4. Write a lambda term `head` that takes a non-empty list *xs* and
   returns the head of the list (i.e. the left-most element).

5. Write a lambda term `tail` that takes a non-empty list *xs* and
   removes the remainder of *xs* obtained after removing its
   head. This is quite a bit harder and requires a trick analogous to
   the one used to define `pred` on Church numerals.
   
6. Transfer your lambda calculus terms into function definitions in
   Scheme and write a function `evallist` that translates the fold
   representation of a list to the corresponding inbuilt list
   representation provided by Scheme.
