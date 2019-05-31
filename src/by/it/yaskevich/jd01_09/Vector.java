package by.it.yaskevich.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] value;

    double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        Matcher matcher = Pattern.compile("^\\{(((,)?(\\d+(\\.\\d)?))+)\\}$").matcher(strVector);
        if (!matcher.find())
            throw new IllegalArgumentException("Incorrect format: " + strVector);

        String rawData = matcher.group(1);
        String[] numbers = Pattern.compile(",").split(rawData);

        value = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            value[i] = Double.parseDouble(numbers[i]);
        }
    }

    @Override
    public String toString() {
        if (value.length == 0)
            return "{}";
        StringBuilder result = new StringBuilder();
        result.append("{");
        String delimiter = "";
        for (double element : value) {
            result.append(delimiter).append(element);
            delimiter = ", ";
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar)other).getValue();
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += s;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] v = ((Vector)other).value;
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += v[i];
            }
            return new Vector(result);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar)other).getValue();
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= s;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] v = ((Vector)other).value;
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= v[i];
            }
            return new Vector(result);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar)other).getValue();
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= s;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] v = ((Vector)other).value;
            double result = 0;
            for (int i = 0; i < value.length; i++) {
                result += v[i] * value[i];
            }
            return new Scalar(result);
        } else
            return super.sub(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar)other).getValue();
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= s;
            }
            return new Vector(result);
        } else
            return super.div(other);
    }
}
