import java.util.Scanner;

class DepositCalculator {
    static double yearRate = 0.06; // годовая ставка

    public static void main(String[] args) {
        new DepositCalculator().depositCalculator();
    }

    void depositCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int depositType = scanner.nextInt();
        double result = 0;
        if (depositType == 1) {
            result = simpleDeposit(depositAmount, depositPeriod);
        } else if (depositType == 2) {
            result = compoundDeposit(depositAmount, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + result);
    }

    static double compoundDeposit(double deposit, int period) {
        double result = deposit * Math.pow((1 + yearRate / 12), 12 * period);
        return getRoundPersent(result, 2);
    }

    static double simpleDeposit(double deposit, int period) {
        double result = deposit + deposit * yearRate * period;
        return getRoundPersent(result, 2);
    }

    static double getRoundPersent(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public void getSomeFunction(){
        int x = 2;
        int y = 3;
        System.out.println(x + y);
    }
}