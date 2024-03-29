# UnionType for The Java Programming Language

## 1. What is union type?
you can see some details in the [`Typed-Racket`](https://docs.racket-lang.org/ts-guide/beginning.html#%28part._.Datatypes_and_.Unions%29) Programming Language:
```racket
#lang typed/racket
(define-type Tree (U leaf node))
(struct leaf ([val : Number]))
(struct node ([left : Tree] [right : Tree]))
 
(: tree-height (-> Tree Integer))
(define (tree-height t)
  (cond [(leaf? t) 1]
        [else (max (+ 1 (tree-height (node-left t)))
                   (+ 1 (tree-height (node-right t))))]))
 
(: tree-sum (-> Tree Number))
(define (tree-sum t)
  (cond [(leaf? t) (leaf-val t)]
        [else (+ (tree-sum (node-left t))
                 (tree-sum (node-right t)))]))
```
## 2. Use this library
`note: you can see the tests in test of this project for more details.`

### I. basic usage
```java
Union strOrInt = new Union(String.class, Integer.class, Null.class);
/* error: don't init the value */
// strOrInt.get(String.class);
/* set strOrInt to Integer 32 */
strOrInt.set(32);
/* reset strOrInt to Integer 132 */
strOrInt.set(132);
/* reset strOrInt type to String type */
strOrInt.set("hello");
/* error: don't specify type LinkedList */
// strOrInt.set(new LinkedList<>());
if (strOrInt.isType(Integer.class)) {
    System.out.println("number: " + strOrInt.get(Integer.class));
} else if (strOrInt.isType(String.class)) {
    System.out.println("string: " + strOrInt.get(String.class));
} else {
    System.out.println("other type");
}
```
### II. with the Null operation
```java
/* 1. use `Union` class to manipulate nullable instance */
Union nullableStr = new Union(String.class, Null.class);
nullableStr.set(Null.instance);
if (nullableStr.isType(Null.class)) {
    System.out.println("nullableStr is null");
} else {
    System.out.println("nullableStr: " + nullableStr.get(String.class));
}
/* 2. or simplify use the `Option` class */
Option canNullStr = new Option(String.class);
if (canNullStr.isNull()) {
    System.out.println("canNullStr is null");
} else {
    System.out.println("canNullStr: " + canNullStr.get(String.class));
}
```