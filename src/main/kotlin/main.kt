fun main() {
    println("Welcome to Bytebank!")

    val account = Account(owner = "Leonardo Negrão", accountNumber = "0001")
    account.deposit(0.0)
    val balance = account.balance
    println("Your current balance is $balance")
}

class Account(val owner: String, val accountNumber: String) {
    val agency: Int = 1000
    var balance: Double = 0.0
        private set

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

class AccountHelpers() {
    companion object {
        fun validateDeposit(value: Double): Boolean {
            if (value < 0) return false
            return true
        }

        fun validateWithdraw(value: Double, currentBalance: Double): Boolean {
            if (value > currentBalance) return false
            return true
        }
    }
}