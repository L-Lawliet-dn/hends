package Java;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

class Activity8{
    static void divideByZero(int a, int b) throws CustomException {
        if(b == 0)
        {
            throw new CustomException("Divide by zero is not possible");
        }else{
            System.out.println(a/b);;
        }
    }
}

class Main{
    public static void main(String[] args) throws CustomException {
        Activity8.divideByZero(8,0);
    }
}