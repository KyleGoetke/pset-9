import java.util.ArrayList;

public class Exercises {

    /*
    HOW TO RUN THIS
    1) cd ~/???/pset-9/tests
    2) ./grademe.sh [exercise]
    */

    public boolean commonEnd(ArrayList<Integer> a, ArrayList<Integer> b) {
        //input verification
        if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
            return false;
        }

        if ((a.get(0) == b.get(0)) || ( a.get(a.size()-1) == b.get(b.size()-1)) ) {
            return true;
        }

        return false;    // default return value to ensure compilation
    }

    public ArrayList<String> endsMeet(ArrayList<String> values, int n) {
        // input verification
        ArrayList<String> emptyArrayList = new ArrayList();
        if (values == null || values.isEmpty() || n < 0 || values.size() < n) {
            return emptyArrayList;
        }

        ArrayList<String> combinedArrayList = new ArrayList();
        int valueOfN = n;

        // go from first index until nth index
        for (int i = 0; i < n; i++) {
            combinedArrayList.add(values.get(i));
        }

        // go from length - nth index until last index
        for (int i = n; i < n * 2; i++) {
            combinedArrayList.add(values.get(values.size() - valueOfN));
            valueOfN--;
        }

        return combinedArrayList;

        // return null; default return value to ensure compilation
    }

    public int difference(ArrayList<Integer> numbers) {
        // input verification
        if (numbers == null || numbers.isEmpty() || numbers.size() < 1) {
            return -1;
        }

        int largestValue = numbers.get(0);
        int smallestValue = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > largestValue) {
                largestValue = numbers.get(i);
            }
            if (numbers.get(i) < smallestValue) {
                smallestValue = numbers.get(i);
            }
        }

        return largestValue - smallestValue;

        // return -1; // default return value to ensure compilation
    }

    public double biggest(ArrayList<Double> numbers) {
        // input verification
        if (numbers == null || numbers.isEmpty() || numbers.size() % 2 == 0 || numbers.size() < 3) {
            return -1;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0) {
                return -1;
            }
        }

        double firstElement = numbers.get(0);
        double lastElement = numbers.get(numbers.size() - 1);
        double middleElement = numbers.get(numbers.size() / 2);

        if (firstElement > lastElement && firstElement > middleElement) {
            return firstElement;
        } else if (lastElement > middleElement && lastElement > firstElement) {
            return lastElement;
        } else if (middleElement > lastElement && middleElement > firstElement) {
            return middleElement;
        } else if (middleElement == lastElement && middleElement == firstElement) {
            return firstElement;
        }

        return -1;        // default return value to ensure compilation
    }

    public ArrayList<String> middle(ArrayList<String> words) {
        // input verification
        ArrayList<String> empty = new ArrayList();
        if (words == null || words.isEmpty()) {
            return empty;
        } else if (words.size() < 3 || words.size() % 2 == 0) {
            return empty;
        }

        for (int i = 0; i < words.size(); i++) {
            if ((words.get(i) == null) ? true : false) {
                return empty;
            }
        }

        ArrayList<String> finalArrayList = new ArrayList();
        finalArrayList.add(words.get((int) Math.floor(words.size() / 2) - 1));
        finalArrayList.add(words.get((int) Math.floor(words.size() / 2)));
        finalArrayList.add(words.get((int) Math.floor(words.size() / 2) + 1));
        return finalArrayList;

        // return null;    // default return value to ensure compilation
    }

    public boolean increasing(ArrayList<Integer> numbers) {
        // input verification
        if (numbers == null) {
            return false;
        } else if (numbers.size() < 1) {
            return false;
        }

        for (int i = 1; i < numbers.size()-1; i++) {
            if (numbers.get(i-1) < numbers.get(i) && numbers.get(i) < numbers.get(i+1)) {
                return true;
            }
        }

        return false;    // default return value to ensure compilation
    }

    public boolean everywhere(ArrayList<Integer> numbers, int x) {
        // input verification
        if (numbers == null || numbers.size() < 1) {
            return false;
        }

        boolean inLastPosition = false;
        int gapBetween = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == x) {
                inLastPosition = true;
                gapBetween = 0;
            } else {
                if (i == 1 && inLastPosition == false) {
                    return false;
                } else if (inLastPosition == false) {
                    gapBetween++;
                }
                inLastPosition = false;
            }

            if (gapBetween == 2) {
                return false;
            }
        }

        return true;

        // return false;    // default return value to ensure compilation
    }

    public boolean consecutive(ArrayList<Integer> numbers) {
        // input verification
        if (numbers == null || numbers.size() < 3) {
            return false;
        }

        int remainder = -1;
        int previousRemainder = -1;
        int numbersInARow = 0;
        for (int i = 0; i < numbers.size(); i++) {
            remainder = numbers.get(i) % 2;
            if (remainder == 1) {
                if (previousRemainder == 1) {
                    numbersInARow++;
                } else {
                    numbersInARow = 1;
                }
            } else {
                if (previousRemainder == 0) {
                    numbersInARow++;
                } else {
                    numbersInARow = 1;
                }
            }

            if (numbersInARow == 3) {
                return true;
            }

            previousRemainder = remainder;
        }

        return false;    // default return value to ensure compilation
    }

    public boolean balance(ArrayList<Integer> numbers) {
        // input verification
        if (numbers == null || numbers.size() < 2) {
            return false;
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            int firstHalfSum = 0;
            int secondHalfSum = 0;

            for (int x = i; x >= 0; x--) {
                firstHalfSum += numbers.get(x);
            }

            for (int z = i + 1; z < numbers.size(); z++) {
                secondHalfSum += numbers.get(z);
            }

            if (firstHalfSum == secondHalfSum) {
                return true;
            }
        }

        return false;    // default return value to ensure compilation
    }

    public int clumps(ArrayList<String> values) {
        // input verification
        if (values == null) {
            return -1;
        }
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) == null) {
                return -1;
            }
        }

        boolean isSame = false;
        boolean prevSame = false;
        String previous = "";
        int clumps = 0;

        for (int i = 0; i < values.size(); i++) {
            if (previous.equals(values.get(i))) {
                isSame = true;
                if (prevSame != true) {
                    clumps++;
                }
            } else {
                isSame = false;
            }
            previous = values.get(i);
            prevSame = isSame;
        }

        return clumps;

        // return -1;        // default return value to ensure compilation
    }
}
