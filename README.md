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

Put your answers to problem 2 into the text file `solution.md`.
The code template for solving Problem 1 is provided in the file

```
src/main/scala/pl/hw05/hw05.scala
```

relative to the root directory of the repository. Follow the
instructions in the notes for Class 2 to import the project into
InteliJ (or use your other favorite IDE or editor to work on the assignment).

There are also some unit tests in

```
src/test/scala/pl/hw05/hw05Spec.scala
```

to help you test your code for Problem 1.


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


## Problem 1: Tail Recursion in Scala (8 Points)

1. Write a Scala function

   ```scala
   def binom(n: Int, k: Int): Int
   ```

   that computes the binomial coefficient of two natural numbers `n`
   and `k`. Recall that for natural numbers <img
   src="http://latex.codecogs.com/svg.latex?k\le&space;n"
   style="margin-bottom:-3px" border="0"/>, the binomial coefficient,
   written

   <img src="http://latex.codecogs.com/svg.latex?\binom{n}{k}" border="0"/> 

   can be defined recursively as follows:

   <img src="http://latex.codecogs.com/svg.latex?\binom{n}{0}=\binom{n}{n}=1\quad\text{and}\quad\binom{n}{k}=\binom{n-1}{k-1}+\binom{n-1}{k}\quad\text{for}\;{}0<k<n" border="0"/>

   Your implementation should use recursion instead of loops but still
   run in constant stack space (assuming the compiler performs
   tail-call elimination). You will need to introduce a tail-recursive
   helper function to achieve this. See also the function `facTail`
   used to define the factorial function `fac` [here](https://github.com/nyu-pl-fa18/class05/blob/master/src/main/scala/pl/class05/Fac.scala).
 
   Hints

   1. A useful trick is to consider the following multiplicative identity
      of binomial coefficients for your implementation instead of the
      additive identity given above:

      <img src="http://latex.codecogs.com/svg.latex?\binom{n}{k}=\frac{n\binom{n-1}{k-1}}{k}\quad\text{for}\;0<k<n" border="0"/>

      Though, be careful not to introduce rounding errors.
 
   1. If you are unsure about whether your helper function is
      tail-recursive, you can prepend the `def` keyword with the
      `@tailrec` annotation. This will cause the Scala compiler to
      issue a warning if it cannot perform tail-call elimination on
      your function.

1. The *tribonacci* numbers are a generalization of fibonacci
   numbers. The *n*-th tribonacci number, *T(n)* is defined as
   follows:
   
   * *T(n) = 0* if *n = 0* or *n = 1*
   * *T(n) = 1* if *n = 2*
   * *T(n) = T(n - 1) + T(n - 2) + T(n - 3)* if *n > 2*

   Write a Scala function 
   
   ```scala
   def trib(n: Int): Int 
   ```
   
   that computes the *n*-th tribonnaci number. Your function should
   run in time and space that is linear in *n*. Use recursion instead
   of loops in your implementation, but feel free to introduce a
   tail-recursive helper function.

Put your solution into the file `src/main/scala/pl/hw05/hw05.scala`.

## Problem 2: Lambda Calculus (12 Points)

When submitting your solution to this problem in the file
`solution.md`, you may use the notation *(lambda x. t)* for lambda
terms *(λ x. t)*.

1. Consider the lambda term

   *t = λ x. (λ y. x (λ x. (λ y. y) y)) z (λ z. z y) x*
   
   1. Construct a new term *t'* from *t* by α-renaming all variables
      bound in *t* such that they are unique (i.e. the same variable
      name should not be bound by two different λs in *t'*).
   
   1. Calculate the set of free variables appearing in *t*.

2. Using the definitions from class, compute the normal form of the
   following lambda term and show that it is equal to *`true`*. Show
   all β-reduction steps.

   *`iszero` (`mult` `0` `2`)*

3. Give an alternative definition for the lambda term *`exp`* such
   that *`exp` n m* computes the Church encoding of the number *mⁿ*
   for two Church numerals *m* and *n*. (Hint: you can e.g. use
   *`mult`* to define *`exp`*). You can test your definition by
   transferring it to Scheme (see the file [church.scm](https://github.com/nyu-pl-fa18/class05/blob/master/church.scm)).

Put your solution into the file `solution.md`.

## Problem 3: Lambda Lists (Optional, 5 Bonus Points)

Lists are an important data structure. Many programming languages,
including Scheme and Scala, therefore provides an inbuilt list data
type.  However, from a theoretical point the list type is redundant
because, just like numbers and Booleans, lists can be encoded directly
in the untyped lambda calculus.

A list can be represented in the lambda calculus by its *fold*
function. For example, a list *xs* containing *`1`*, *`2`*, and *`3`*
becomes a function that takes two arguments *f* and *z* and returns *f
`1` (f `2` (f `3` z))*:

*xs = λ f z. f `1` (f `2` (f `3` z))*

Now, if one wants to implement, e.g., a function that sums up all
the elements in a list *xs* containing Church numerals, this can be
done as follows:

*`sum` = λ xs. xs `plus` `0`*

In particular, applying `sum` to the list *xs* defined above yields:

*`sum` xs → ... → `plus` `1` (`plus` `2` (`plus` `3` `0`)) → ... → `6`*

1. Write a lambda term `nil` that represents the empty list `()`.

2. Write a lambda term `cns` that takes an element *hd* and a list
   *tl* (represented as a fold function) and returns a list formed by
   prepending *hd* on *tl*.
   
3. Write a lambda term `isnil` that takes a list *xs* and returns
   `true` if *xs* is the empty list and `false` otherwise.
   
4. Write a lambda term `head` that takes a non-empty list *xs* and
   returns the head of the list (i.e. the left-most element).

5. Write a lambda term `tail` that takes a non-empty list *xs* and
   removes the remainder of *xs* obtained after removing its
   head. This is quite a bit harder and requires a trick analogous to
   the one used to define `pred` on Church numerals (see the class
   notes).
   
6. Transfer your lambda calculus terms into function definitions in
   Scheme and write a function `evallist` that translates the fold
   representation of a list to the corresponding inbuilt list
   representation provided by Scheme.

Put your solution into the file `lists.scm`.
