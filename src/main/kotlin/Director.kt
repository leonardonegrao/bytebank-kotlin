class Director(
        name: String,
        document: String,
        salary: Double,
        plr: Double,
        private val password: String,
) : Employee(name, document, salary) {

    override fun bonus(): Double {
        return super.bonus() + this.salary
    }

    fun authentication(password: String): Boolean {
        return (this.password == password)
    }
}