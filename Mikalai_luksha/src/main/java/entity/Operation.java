package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.ServiceCalc;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class Operation implements Comparable <Operation>{



    double num1;
    double num2;
    double res;
    String operation;
    User user;

    @Override
    public String toString() {
        ServiceCalc serviceCalc = new ServiceCalc();
        return num1 +" "+ serviceCalc.symbol(operation) + " "+ num2 + " = "+  res + " || "  + " User " + user.getName();
    }


    @Override
    public int compareTo(Operation o) {

        return Double.compare(this.res, o.res);
    }


    public int compareToRevers (Operation o) {
        return Double.compare(o.res, this.res);
    }
}
