package com.yibai.output;

public class OutputHelper {

    IOutputGenerator outputGenerator;

//    public OutputHelper() {
//        outputGenerator = new CsvOutputGenerator();
//    }
//
//
//    public void generateOutput() {
//        outputGenerator.generateOutput();
//    }

    public void generateOutput() {
        outputGenerator.generateOutput();
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }

}
