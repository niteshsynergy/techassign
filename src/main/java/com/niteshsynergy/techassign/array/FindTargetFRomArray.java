package com.niteshsynergy.techassign.array;

public class FindTargetFRomArray {
    public static void main(String[] args) {

    }
}


/*
Part A-> select distinct salary from emp e1

where (
      Part B ->  select count(distinct salary) from emp e2
where
Part C-> e2.salary>e1.salary)=3-1;*/

/*
Part A:select distinct salary from emp e1
1) from emp e1
2) for each e1.salary evaluate of Part B

    select count(distinct salary) from emp e2

    where e2.sal>e1.sal

    =>
    if e1.sal===75,000 , it will choose how may salaries in e2 are gth than 75,000.

    evalute final Part C
    where ( subquery ) =N-1

    3=4-1 -> 3=3 OKay




    intenral code:

    for each row e1 in emp:
      {
        set countsol=e1.sal
        count=0;
        for each row e2 in emp:
        {
            if e2.sal>e1.sal
            {
               countsol++;
            }
            if(countsol==N-1) And countsol to zeroset
            {
            ...
            }
        }
     }
 */





