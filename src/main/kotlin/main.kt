fun main() {
    println("Welcome to Bytebank!")

    val account = Account("Leonardo Negrão", "0001")
    account.deposit(0.0)
    val balance = account.getBalance()
    println("Your current balance is $balance")
}

class Account(var owner: String, var accountNumber: String) {
    private val agency: Int = 1000
    private var balance: Double = 0.0
    
    fun getAgency(): Int {
        return this.agency
    }

    fun getBalance(): Double {
        return this.balance
    }

    fun setBalance(value: Double) {
        if (value <= 0) {
            this.balance -= value
        } else {
            this.balance += value
        }
    }

    fun deposit(value: Double) {
        val depositIsValid = AccountHelpers.validateDeposit(value)

        if (depositIsValid) {
            this.balance += value
        } else {
            throw Exception("Deposit value is invalid!")
        }
    }

    fun withdraw(value: Double) {
        val withdrawIsValid = AccountHelpers.validateWithdraw(value, this.balance)

        if (withdrawIsValid) {
            this.balance -= value
        } else {
            throw Exception("Withdraw value is invalid!")
        }
    }

    fun wireTransfer(receiver: Account, value: Double) {
        val wireTransferIsValid = AccountHelpers.validateWithdraw(value, this.balance)

        if (wireTransferIsValid) {
            this.balance -= value
            receiver.deposit(value)
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