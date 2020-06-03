package service;

import entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class HistoryService {

    public List calcResult(String operation, List <Operation> result) {

        switch (operation) {
            case ("all"):
                return allResult(result);
            case ("plus"):
                return plusResult(result);
            case ("minus"):
                return minusResult(result);
            case ("div"):
                return divResult(result);
            case ("times"):
                return timesResult(result);
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
    }

    private List allResult (List<Operation> list){
        return list;
    }

    private List plusResult (List<Operation> list) {
        List plusList = new ArrayList();
        for (Operation operation : list) {
            if (operation.getOperation().equals("plus")) {
                plusList.add(operation);
            }
        }
        return plusList;
    }

    private List minusResult (List<Operation> list) {
        ArrayList minusList = new ArrayList();
        for (Operation operation : list) {
            if (operation.getOperation().equals("minus")) {
                minusList.add(operation);
            }
        }
        return minusList;
    }

    private List divResult (List<Operation> list) {
        List divList = new ArrayList();
        for (Operation operation : list) {
            if (operation.getOperation().equals("minus")) {
                divList.add(operation);
            }
        }
        return divList;
    }
    private List timesResult(List<Operation> list) {
        List timesList = new ArrayList();
        for (Operation operation : list) {
            if (operation.getOperation().equals("minus")) {
                timesList.add(operation);
            }
        }
        return timesList;
    }

    public List<Operation> sortRes (String sort, List<Operation> operationList){

        if (sort != null && sort.equalsIgnoreCase("asc")){
            operationList.sort(Operation::compareTo);
        }
        if (sort != null && sort.equalsIgnoreCase("desc")){
            operationList.sort(Operation::compareToRevers);
        }
        if (sort != null && sort.equalsIgnoreCase("no")){
            return operationList;
        }
        return operationList;
    }



}
