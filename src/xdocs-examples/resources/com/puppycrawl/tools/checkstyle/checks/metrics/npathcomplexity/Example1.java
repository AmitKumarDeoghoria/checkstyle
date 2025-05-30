/*xml
<module name="Checker">
  <module name="TreeWalker">
    <module name="NPathComplexity"/>
  </module>
</module>
*/
package com.puppycrawl.tools.checkstyle.checks.metrics.npathcomplexity;

// xdoc section -- start
public abstract class Example1 {
  final int a = 0;
  int b = 0;

  public void foo() { // ok, NPath complexity is less than default threshold
    // function consists of one if-else block with an NPath Complexity of 3
    if (a > 10) {
      if (a > b) { // nested if-else decision tree adds 2 to the complexity count
        buzz();
      } else {
        fizz();
      }
    } else { // last possible outcome of the main if-else block, adds 1 to complexity
      buzz();
    }
  }

  public void boo() { // violation, NPath complexity is 217 (max allowed is 200)
    // looping through 3 switch statements produces 6^3 + 1 (217) possible outcomes
    for(int i = 0; i < b; i++) { // for statement adds 1 to final complexity
      switch(i) { // each independent switch statement multiplies complexity by 6
        case a:
          // ternary with && adds 3 to switch's complexity
          print(f(i) && g(i) ? fizz() : buzz());
        default:
          // ternary with || adds 3 to switch's complexity
          print(f(i) || g(i) ? fizz() : buzz());
      }
      switch(i - 1) { // multiplies complexity by 6
        case a:
          print(f(i) && g(i) ? fizz() : buzz());
        default:
          print(f(i) || g(i) ? fizz() : buzz());
      }
      switch(i + 1) { // multiplies complexity by 6
        case a:
          print(f(i) && g(i) ? fizz() : buzz());
        default:
          print(f(i) || g(i) ? fizz() : buzz());
      }
    }
  }

  public abstract boolean f(int x);
  public abstract boolean g(int x);
  public abstract String fizz();
  public abstract String buzz();
  public abstract void print(String str);
}
// xdoc section -- end
