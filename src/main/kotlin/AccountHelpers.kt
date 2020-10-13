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