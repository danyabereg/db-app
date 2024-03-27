package ru.danyabereg;


import ru.danyabereg.service.ResultService;

public class App {
    public static void main(String[] args) {
        ResultService resultService = ResultService.getInstance();
        resultService.getResultOutput();
    }
}