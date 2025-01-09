function solution(ineq, eq, n, m) {
    var answer = 0;
    if((ineq==">"&&n>m)
||
       (ineq=="<"&&n<m)
||
       (eq=="="&&n==m))
        answer = 1;

    return answer;
}