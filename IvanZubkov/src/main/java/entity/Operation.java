package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
    public class Operation implements Comparable<Operation> {

    private double num1;
    private double num2;
    private double result;
    private String symbol;
    private User user;

    @Override
    public int compareTo(Operation operation) {
        return Double.compare(this.result, operation.result);

        }
    }

