% 1 == yes
% 2 == no
% 3 == null

add(1, X0, Y0, X1, Y1) :- X1 is X0 + 1, Y1 is Y0 + 1
add(2, X0, Y0, X1, Y1) :- X1 is X0 + 1, Y1 is Y0
add(3, X0, Y0, X1, Y1) :- X1 is X0, Y1 is Y0

calc([],
    [X0, X1, X2],
    [Y0, Y1, Y2],
    [Z0, Z1, Z2]
) :-
    Z0 is X0 / Y0,
    Z1 is X1 / Y1,
    Z2 is X2 / Y2.

verify(Q1, Q2, Q3) :-
    Q1 < 74,
    Q1 >= 73,
    Q2 < 59,
    Q2 >= 58,
    Q3 < 33,
    Q3 >= 32.
% calc()
