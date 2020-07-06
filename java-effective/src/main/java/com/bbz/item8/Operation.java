package com.bbz.item8;

import java.util.stream.Stream;

public interface Operation {
    double apply(double x, double y);


    enum BasicOperation implements Operation {
        PLUS("+") {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            public double apply(double x, double y) {
                return x / y;
            }
        };

        private String symbol;

        BasicOperation(String symbol) {
            this.symbol = symbol;
        }
    }

    enum ExtendedOperation implements Operation {
        EXP("^") {
            public double apply(double x, double y) {
                return Math.pow(x, y);
            }
        },
        REMAINDER("%") {
            public double apply(double x, double y) {
                return x % y;
            }
        };
        private String symbol;

        ExtendedOperation(String symbol) {
            this.symbol = symbol;
        }
    }

    static void main(String[] args) {
        double x = Double.parseDouble("8");
        double y = Double.parseDouble("4");
        test(ExtendedOperation.class, x, y);
    }

    static <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }

}
