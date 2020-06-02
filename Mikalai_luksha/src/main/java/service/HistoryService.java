package service;

import entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class HistoryService {

    public List calcResult(String operation, List <Operation> result) {

        switch (operation) {
            case ("all"):
                return HistoryService.allResult(result);
            case ("plus"):
                return HistoryService.plusResult(result);
            case ("minus"):
                return HistoryService.minusResult(result);
            case ("div"):
                return HistoryService.divResult(result);
            case ("times"):
                return HistoryService.timesResult(result);
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
    }

    public List allResult (List<Operation> list){
        List listAllResult = list;
        return listAllResult;
    }

    public List plusResult (List<Operation> list) {
        List plusList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOperation().equals ("plus")) {
                plusList.add(list.get(i));
            }
        }
        return plusList;
    }

    public List minusResult (List<Operation> list) {
        ArrayList minusList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOperation().equals ("minus")) {
                minusList.add(list.get(i));
            }
        }
        return minusList;
    }

    public List divResult (List<Operation> list) {
        List divList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOperation().equals ("minus")) {
                divList.add(list.get(i));
            }
        }
        return divList;
    }
    public List timesResult (List<Operation> list) {
        List timesList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOperation().equals ("minus")) {
                timesList.add(list.get(i));
            }
        }
        return timesList;
    }



}
