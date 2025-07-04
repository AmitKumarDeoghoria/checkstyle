/*
OperatorWrap
option = (default)nl
tokens = (default)QUESTION, COLON, EQUAL, NOT_EQUAL, DIV, PLUS, MINUS, STAR, MOD, \
         SR, BSR, GE, GT, SL, LE, LT, BXOR, BOR, LOR, BAND, LAND, TYPE_EXTENSION_AND, \
         LITERAL_INSTANCEOF


*/
// non-compiled with javac: compilable with java21

package com.puppycrawl.tools.checkstyle.checks.whitespace.operatorwrap;

public class InputOperatorWrapGuardedPatterns {
    String typeGuardAfterParenthesizedTrueSwitchStatement1(Object o) {
        switch (o) {
            case (Integer i)
                    && i == 0: o = String.valueOf(i); return "true";
            case ((Integer i)
                    && i == 2): o = String.valueOf(i); return "second";
            case Object x: return "any";
        }
    }

    String typeGuardAfterParenthesizedTrueSwitchExpression1(Object o) {
        return switch (o) {
            case (Integer i)
                    && i == 0: o = String.valueOf(i); yield "true";
            case ((Integer i)
                    && i == 2): o = String.valueOf(i); yield "second";
            case Object x: yield "any";
        };
    }

    String typeGuardAfterParenthesizedTrueIfStatement1(Object o) {
        if (o != null
                && o instanceof ((Integer i)
                && i == 0)) {
            return "true";
        } else if (o != null
                && o instanceof (((Integer i)
                && i == 2))
                && (o = i) != null) {
            return "second";
        } else {
            return "any";
        }
    }

    String typeGuardAfterParenthesizedTrueSwitchStatement2(Object o) {
        switch (o) {
            case (Integer i) && // violation ''&&' should be on a new line.'
                    i == 0: o = String.valueOf(i); return "true";
            case ((Integer i) && // violation ''&&' should be on a new line.'
                    i == 2): o = String.valueOf(i); return "second";
            case Object x: return "any";
        }
    }

    String typeGuardAfterParenthesizedTrueSwitchExpression2(Object o) {
        return switch (o) {
            case (Integer i) && // violation ''&&' should be on a new line.'
                    i == 0: o = String.valueOf(i); yield "true";
            case ((Integer i) && // violation ''&&' should be on a new line.'
                    i == 2): o = String.valueOf(i); yield "second";
            case Object x: yield "any";
        };
    }

    String typeGuardAfterParenthesizedTrueIfStatement2(Object o) {
        if (o != null && // violation ''&&' should be on a new line.'
                o instanceof ((Integer i) && // violation ''&&' should be on a new line.'
                        i == 0)) {
            return "true";
        } else if (o != null && // violation ''&&' should be on a new line.'
                o instanceof (((Integer i) && // violation ''&&' should be on a new line.'
                        i == 2)) && // violation ''&&' should be on a new line.'
                (o = i) != null) {
            return "second";
        } else {
            return "any";
        }
    }
}
