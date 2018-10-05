#lang scheme

;; Problem 3 (Bonus)

; Church Booleans
(define true (lambda (x y) x))
(define false (lambda (x y) y))
(define evalbool (lambda (b) (b #t #f)))

; Church pairs
(define pair (lambda (x y) (lambda (b) (b x y))))
(define fst (lambda (p) (p true)))
(define snd (lambda (p) (p false)))

; Church lists (put your definitions here)


;; some tests (they should all evaluate to #t)
;(evalbool (isnil nil))
;(equal? (evalbool (isnil (lambda (f n) (f 1 n)))) #f)
;(equal? (evallist nil) '())
;(equal? (evallist (cns 1 nil)) '(1))
;(equal? (evallist (cns 2 (cns 1 nil))) '(2 1))
;(equal? (head (cns 1 nil)) 1)
;(equal? (head (cns 2 (cns 1 nil))) 2)
;(equal? (evallist (tail (cns 2 (cns 1 nil)))) '(1))
;(equal? (head (tail (cns 2 (cns 1 nil)))) 1)
;(equal? (sum (cns 2 (cns 1 nil))) 3)
