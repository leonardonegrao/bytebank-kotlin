class Account(val owner: String, val accountNumber: String) {
    val agency: Int = 1000
    private var balance: Double = 0.0

    fun deposit(value: Double) {
        val depositIsValid = AccountHelpers.validateDeposit(value = value)

        if (depositIsValid) {
            this.balance += value
        } else {
            throw Exception("Deposit value is invalid!")
        }
    }

    fun withdraw(value: Double) {
        val withdrawIsValid = AccountHelpers.validateWithdraw(value = value, currentBalance = this.balance)

        if (withdrawIsValid) {
            this.balance -= value
        } else {
            throw Exception("Withdraw value is invalid!")
        }
    }

    fun wireTransfer(receiver: Account, value: Double) {
        val wireTransferIsValid = AccountHelpers.validateWithdraw(value = value, currentBalance = this.balance)

        if (wireTransferIsValid) {
            this.balance -= value
            receiver.deposit(value = value)
        }
    }
}
