package Homework_05;

import java.util.Scanner;

public class BankApp {

    public static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    public static class InvalidAmountException extends Exception {
        public InvalidAmountException(String message) {
            super(message);
        }
    }

    public static class BankAccount {
        private String accountNumber;
        private int balance;

        public BankAccount(String accountNumber, int initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public void deposit(int amount) throws InvalidAmountException {
            if (amount < 0) throw new InvalidAmountException("입력한 금액이 음수입니다.");
            balance += amount;
        }

        public void withdraw(int amount) throws InsufficientBalanceException, InvalidAmountException {
            if (amount < 0) throw new InvalidAmountException("입력한 금액이 음수입니다.");
            if (amount > balance) throw new InsufficientBalanceException("잔액이 부족합니다. (현재 잔액: " + balance + "원)");
            balance -= amount;
        }

        public int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount acct = new BankAccount("000-111-222", 30000);

        boolean running = true;
        while (running) {
            System.out.println("=== 영남 은행 계좌 ===");
            System.out.println("1. 입금");
            System.out.println("2. 출금");
            System.out.println("3. 잔액 조회");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("입금 금액: ");
                    String depStr = scanner.nextLine().trim();
                    try {
                        int amt = Integer.parseInt(depStr);
                        acct.deposit(amt);
                        System.out.println("입금 완료. 현재 잔액: " + acct.getBalance() + "원");
                    } catch (NumberFormatException e) {
                        System.out.println("[오류] 숫자를 입력하세요.");
                    } catch (InvalidAmountException e) {
                        System.out.println("[오류] " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.print("출금 금액: ");
                    String wdStr = scanner.nextLine().trim();
                    try {
                        int amt = Integer.parseInt(wdStr);
                        acct.withdraw(amt);
                        System.out.println("출금 완료. 현재 잔액: " + acct.getBalance() + "원");
                    } catch (NumberFormatException e) {
                        System.out.println("[오류] 숫자를 입력하세요.");
                    } catch (InvalidAmountException e) {
                        System.out.println("[오류] " + e.getMessage());
                    } catch (InsufficientBalanceException e) {
                        System.out.println("[오류] 잔액이 부족합니다. (현재 잔액: " + acct.getBalance() + "원)");
                    }
                    break;
                case "3":
                    System.out.println("현재 잔액: " + acct.getBalance() + "원");
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("올바른 선택이 아닙니다.");
            }

            System.out.println();
        }

        scanner.close();
    }
}