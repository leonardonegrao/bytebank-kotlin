class Manager(
    name: String,
    document: String,
    salary: Double,
    private val password: String,
) : Employee(name, document, salary) {

    override fun bonus(): Double {
        return this.salary * 0.2;
    }

    fun authentication(password: String): Boolean {
        return (this.password == password)
    }
}