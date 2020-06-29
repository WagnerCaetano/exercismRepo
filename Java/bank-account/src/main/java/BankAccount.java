public class BankAccount{
    private static final String negativeWithdrawOrDeposit = "Cannot deposit or withdraw negative amount";
    private static final String accountClosed = "Account closed";
    private static final String emptyAccount = "Cannot withdraw money from an empty account";
    private static final String withdrawMoreThanHave = "Cannot withdraw more money than is currently in the account";
    private int balance = 0;
    private boolean open = false;

    public void open(){
        this.open = true;
    }
    public void close() throws BankAccountActionInvalidException {
        isOpen();
        this.open = false;
    }

    public synchronized void deposit(int toDeposit) throws BankAccountActionInvalidException {
        isOpen();
        if (toDeposit > 0) {
            this.balance+=toDeposit;
        } else {
            throw new BankAccountActionInvalidException(negativeWithdrawOrDeposit);
        }
    }

    public synchronized void withdraw(int toWithdraw) throws BankAccountActionInvalidException {
        isOpen();
        if (toWithdraw > 0) {
            if(this.balance >= toWithdraw) {
                this.balance-=toWithdraw;
            }
            else if(this.balance == 0){
                throw new BankAccountActionInvalidException(emptyAccount);
            }
            else if(this.balance < toWithdraw){
                throw new BankAccountActionInvalidException(withdrawMoreThanHave);
            }
        }
        else {
            throw new BankAccountActionInvalidException(negativeWithdrawOrDeposit);
        }
    }

    public int getBalance() throws BankAccountActionInvalidException {
        isOpen();
        return balance;
    }

    private void isOpen() throws BankAccountActionInvalidException {
        if(!open)
        {
            throw new BankAccountActionInvalidException(accountClosed);
        }
    }
}